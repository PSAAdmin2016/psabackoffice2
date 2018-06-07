Application.$controller("ReviewLandingPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        //Invoke Application Variables that are only needed in Review pages

        //SuperReview Variables
        $scope.Variables.PSARefPipeSizesData.listRecords();
        $scope.Variables.PSARefWeldTypesData.listRecords();
        $scope.Variables.PSARefWeldMaterialsData.listRecords();
        $scope.Variables.PSARefPipeSchedulesData.listRecords();

        //PSReview Variables
        $scope.Variables.PSARefActivityRejectionsData.listRecords();

        //Both Pages Variables
        $scope.Variables.PSARefWeldPositionsData.listRecords();
        $scope.Variables.Job1111RefWeldSpecProcedures.listRecords();

        //No Pages Variables
        //$scope.Variables.PSARefGenericPipeSpoolsData.listRecords();
        //$scope.Variables.PSARefActivityTypesData.listRecords();
        //$scope.Variables.PSARefActivityStatusesData.listRecords();
    };



}]);