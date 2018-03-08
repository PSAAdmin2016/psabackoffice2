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


}]);




Application.$controller("gridSteelFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customRowAction = function($event, $rowData) { //REJECT

            $scope.Widgets.gridSteelFA.cancelRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };


        $scope.customRow1Action = function($event, $rowData) { //SAVE

            $scope.Widgets.gridSteelFA.cancelRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };


        $scope.customRow3Action = function($event, $rowData) { //Cancel

            $scope.Widgets.gridSteelFA.cancelRow();
            $scope.Variables.staticEditMode.setValue("dataValue", false);
        };
    }
]);