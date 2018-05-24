Application.$controller("PopSteelFAExpandedPageController", ["$scope", "DialogService", function($scope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {};


    $scope.buttonReturnClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.serviceUpdateSASReturnToList.invoke({},
            function(data) {
                $scope.Variables.serviceGetBidWorkHistoryExpanded.invoke();
                $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistory.invoke();
                $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceUpdateClassicTracker.invoke();
            });
    };


    $scope.buttonOverRideClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogOverrideOpen(item);
    };


    $scope.buttonHistoryClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogActivityHistoryOpen(item);
    };

}]);