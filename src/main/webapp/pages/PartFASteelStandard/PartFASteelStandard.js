Application.$controller("PartFASteelStandardPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.gridSteelFARowclick = function($event, $isolateScope, $rowData) {
        $scope.Widgets.gridSteelFA.cancelRow();
        $scope.Variables.staticEditMode.setValue("dataValue", false);

        $scope.Variables.liveGetSubDetails.listRecords({
            filterFields: {
                "submissionId": {
                    "value": $rowData.activityId
                }
            }
        });

    };


    $scope.gridSteelFARowdblclick = function($event, $isolateScope, $rowData) {
        if (!$scope.Variables.staticEditMode.dataSet.dataValue) {
            $scope.Variables.staticEditMode.setValue("dataValue", true);
            $scope.Widgets.gridSteelFA.editRow();
        }
    };


    $scope.gridSteelFARowupdate = function($event, $isolateScope, $rowData) {
        $scope.Variables.serviceUpdateSteelFA.invoke({},
            function(data) {
                $scope.Variables.serviceUpdateSAS.setInput("ActivityID", $rowData.activityId);
                $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 4);
                $scope.Variables.serviceUpdateSAS.invoke({},
                    function(data) {
                        $scope.$parent.Variables.serviceGetFAsSteel.invoke();
                    }
                );
            }
        );
    };


    $scope.serviceUpdateSteelFAonBeforeUpdate = function(variable, inputData) {
        inputData.Quantity = $scope.Widgets.gridSteelFA.formfields.faquantity.getProperty('value');
        inputData.PercentCompleted = $scope.Widgets.gridSteelFA.formfields.fapercent.getProperty('value');
        inputData.Rework = $scope.Widgets.gridSteelFA.formfields.farework.getProperty('value');
        inputData.Notes = $scope.Widgets.gridSteelFA.formfields.fanotes.getProperty('value');
    };
}]);




Application.$controller("gridSteelFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customRowAction = function($event, $rowData) { //REJECT
            $scope.Variables.serviceUpdateSAS.setInput("ActivityID", $rowData.activityId);
            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 3);
            $scope.Variables.serviceUpdateSAS.invoke({},
                function(data) {
                    $scope.Variables.serviceGetSteelFAData.invoke();
                    $scope.$parent.Variables.serviceGetFAsSteel.invoke();
                }
            );

            $scope.Widgets.gridSteelFA.cancelRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };


        $scope.customRow1Action = function($event, $rowData) { //SAVE
            $scope.Widgets.gridSteelFA.saveRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };


        $scope.customRow3Action = function($event, $rowData) { //Cancel
            $scope.Widgets.gridSteelFA.cancelRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };
    }
]);