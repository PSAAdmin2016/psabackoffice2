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
    };


    $scope.gridSteelFARowdblclick = function($event, $isolateScope, $rowData) {
        if (!$scope.Variables.staticEditMode.dataSet.dataValue) {
            $scope.Variables.staticEditMode.setValue("dataValue", true);
            $scope.Widgets.gridSteelFA.editRow();
        }
    };


    $scope.gridSteelFARowupdate = function($event, $isolateScope, $rowData) {
        $scope.Variables.liveUpdateSteelActivity.setInput("activityId", $rowData.activityId);

        if ($rowData.fkActivityStatus == 6 || $rowData.fkActivityStatus == 8) {
            $scope.Variables.liveUpdateSteelActivity.setInput("fkActivityStatus", 8); // Progress Rejected Mod
        } else {
            $scope.Variables.liveUpdateSteelActivity.setInput("fkActivityStatus", 4); //Supervisor Modified
        }

        if ($rowData.activityTypeId == 61 || $rowData.activityTypeId == 65 || $rowData.activityTypeId == 68) {
            $scope.Variables.liveUpdateSteelActivity.setInput({
                "steelFa": {
                    "fasortGroup1": $rowData.fasortGroup1,
                    "fapieceNumber": $rowData.fapieceNumber,
                    "activityType": $rowData.activityTypeId,
                    "fatimeInForm": $rowData.fatimeInForm,
                    "faquantity": $scope.Widgets.gridSteelFA.formfields.faquantity.getProperty('value'),
                    "fapercentCompleted": 1.00,
                    "farework": $scope.Widgets.gridSteelFA.formfields.farework.getProperty('value'),
                    "fanotes": $scope.Widgets.gridSteelFA.formfields.fanotes.getProperty('value')
                }
            });
        } else {
            $scope.Variables.liveUpdateSteelActivity.setInput({
                "steelFa": {
                    "fasortGroup1": $rowData.fasortGroup1,
                    "fapieceNumber": $rowData.fapieceNumber,
                    "activityType": $rowData.activityTypeId,
                    "fatimeInForm": $rowData.fatimeInForm,
                    "faquantity": $scope.Widgets.gridSteelFA.formfields.faquantity.getProperty('value'),
                    "fapercentCompleted": $scope.Widgets.gridSteelFA.formfields.fapercent.getProperty('value'),
                    "farework": $scope.Widgets.gridSteelFA.formfields.farework.getProperty('value'),
                    "fanotes": $scope.Widgets.gridSteelFA.formfields.fanotes.getProperty('value')
                }
            });
        }

        $scope.Variables.liveUpdateSteelActivity.updateRecord({
            row: {
                "submissionId": $scope.$parent.Widgets.gridSuperReviewSteel.selecteditem.submissionId,
                "activityType": $scope.Widgets.gridSteelFA.selecteditem.activityTypeId,
                "fkLastModifiedBy": $scope.Variables.loggedInUser.dataSet.id
            },
            function(data) {
                $scope.Variables.serviceGetSteelFAData.invoke();
            }
        });
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
                    $scope.$parent.$parent.$parent.Variables.serviceGetFAsSteel.invoke();
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