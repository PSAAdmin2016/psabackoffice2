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
        $scope.Variables.serviceUpdateSteelFA.invoke();
    };


    $scope.serviceUpdateSteelFAonBeforeUpdate = function(variable, inputData) {
        inputData.Quantity = $scope.Widgets.gridSteelFA.formfields.faquantity.getProperty('value');
        inputData.Percent = $scope.Widgets.gridSteelFA.formfields.fapercent.getProperty('value');
        inputData.Rework = $scope.Widgets.gridSteelFA.formfields.farework.getProperty('value');
    };

}]);




Application.$controller("gridSteelFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customRowAction = function($event, $rowData) { //REJECT
            $scope.Variables.serviceUpdateSASReject.setInput("FieldActivityID", $rowData.activityId);
            $scope.Variables.serviceUpdateSASReject.invoke() //ReInvokes serviceGetSteelFAData onSuccess
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