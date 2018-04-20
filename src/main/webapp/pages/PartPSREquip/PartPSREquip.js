Application.$controller("PartPSREquipPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
    "use strict";

    $scope.onPageReady = function() {

    };


    $rootScope.gridApprovalReviewSelectEquip = function() {
        //Get Matches
        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": $scope.pageParams.BidID
            }
        });
    };


    $rootScope.gridApprovalReviewDeselectEquip = function() {
        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": 0
            }
        });
    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        $scope.Variables.liveEquipFA.listRecords({
            filterFields: {
                "activityId": {
                    "value": $scope.pageParams.ActivityID
                }
            }
        });
    };


    $scope.popoverAssignHide = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.serviceUnLockSASActivity.invoke();
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        $scope.$parent.Variables.navigationToClassicEquip.setData({
            'PageLoadBidID': $scope.pageParams.BidID,
            'PageLoadFiltered': true
        });
        //Fire Nav Call
        $scope.$parent.Variables.navigationToClassicEquip.invoke();
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) {
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonHoldClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 44);
        $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
    };


    $scope.serviceUpdateSASonSuccess = function(variable, data) {
        $scope.$parent.$parent.Variables.serviceGetActivitiesPendingApproval.invoke();
    };

}]);




Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.$parent.$parent.savePageSettings();

            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 6);
            $scope.Variables.serviceUpdateSAS.setInput("RejectID", $scope.Widgets.formReject.formWidgets.selectRejectReason.datavalue);
            $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
            $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSASNote.setInput("Note", $scope.Widgets.formReject.formWidgets.textareaSASNoteReject.datavalue);
            $scope.$parent.$parent.Variables.serviceCreateSASNote.invoke();
        };


        $scope.buttonDialogRejectionSaveClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };

    }
]);


Application.$controller("dialogPSAActivityDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogBidActivityDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);