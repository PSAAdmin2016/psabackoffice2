Application.$controller("PartPSREquipPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
    "use strict";

    $scope.onPageReady = function() {

    };


    $rootScope.gridApprovalReviewSelectEquip = function() {
        //Get Matches
        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1
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
                    "value": $parent.Widgets.gridApprovalReview.selecteditem.ActivityID
                }
            }
        });
    };


    $scope.buttonAssign1Click = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.serviceLockSASActivity.invoke(); //Calls dialog onResults
        $scope.Variables.serviceGetQuantities.invoke(); //Get quantities query running asap..
    };


    $scope.serviceLockSASActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            DialogService.open('dialogAssignQuantities', $scope);
        } else {
            $scope.$parent.Variables.staticRecordLockedMessage.setData({
                "dataValue": data[0].ErrorText
            });
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) {
        if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelFAHoursRemaining.caption) {
            if ($scope.Variables.staticBrightLabel === false) {
                //console.log("Normal" + $scope.Widgets.textShakeHrsEarned.datavalue);
                $scope.Widgets.labelFAHoursRemaining.fontsize = '';
                $scope.Widgets.labelFAHoursRemaining.borderstyle = '';
                $scope.Widgets.labelFAHoursRemaining.bordercolor = '';
                $scope.Widgets.labelFAHoursRemaining.padding = '';
                $scope.Widgets.labelFAHoursRemaining.color = '';
                $scope.Widgets.labelFAHoursRemaining.backgroundcolor = '';
                $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
            } else {
                //console.log("Bright");
                $scope.Widgets.labelFAHoursRemaining.fontsize = "16";
                $scope.Widgets.labelFAHoursRemaining.borderstyle = "solid";
                $scope.Widgets.labelFAHoursRemaining.bordercolor = "#fffd00";
                $scope.Widgets.labelFAHoursRemaining.padding = "1%";
                $scope.Widgets.labelFAHoursRemaining.color = 'black';
                $scope.Widgets.labelFAHoursRemaining.backgroundcolor = 'red';
                $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
            }
        }

    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        $scope.$parent.Variables.navigationToClassicEquip.setData({
            'PageLoadBidID': parseInt($scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1),
            'PageLoadFiltered': true
        });
        //Fire Nav Call
        $scope.$parent.Variables.navigationToClassicEquip.invoke();
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) {
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonHoldClick = function($event, $isolateScope) {
        $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 44);
        $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
    };

}]);




Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUnLockSASActivity.invoke();

            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 6);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("RejectID", $scope.Widgets.formReject.formWidgets.selectRejectReason.datavalue);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", null);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

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


Application.$controller("dialogAssignQuantitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonQuantitiesUpdateClick = function($event, $isolateScope) {

            debugger;
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 5);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", $scope.Widgets.livelistBidActivities.selecteditem.bidId);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.Variables.timerLabelFlasher.cancel();
        };


        $scope.dialogAssignQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher.invoke();
        };


        $scope.dialogAssignQuantitiesClose = function($event, $isolateScope) {
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.Variables.timerLabelFlasher.cancel();
        };

    }
]);