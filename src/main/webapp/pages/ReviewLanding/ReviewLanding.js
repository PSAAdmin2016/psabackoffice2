Application.$controller("ReviewLandingPageController", ["$scope", function($scope) {
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

        //Invoke Application Variables that are only needed in Review pages
        $scope.Variables.PSARefWeldTypesData.listRecords();
        $scope.Variables.PSARefWeldPositionsData.listRecords();
        $scope.Variables.PSARefWeldMaterialsData.listRecords();
        $scope.Variables.PSARefPipeSizesData.listRecords();
        $scope.Variables.PSARefPipeSchedulesData.listRecords();
        $scope.Variables.PSARefGenericPipeSpoolsData.listRecords();
        $scope.Variables.PSARefActivityTypesData.listRecords();
        $scope.Variables.PSARefActivityStatusesData.listRecords();
        $scope.Variables.PSARefActivityRejectionsData.listRecords();
    };



}]);