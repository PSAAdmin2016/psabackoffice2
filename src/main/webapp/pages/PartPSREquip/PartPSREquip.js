Application.$controller("PartPSREquipPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
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


    $rootScope.gridApprovalReviewSelectEquip = function() {
        //Get Matches
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 80) {
            $scope.Variables.serviceGetMatches.invoke();
        }
    };


    $rootScope.gridApprovalReviewDeselectEquip = function() {
        $scope.Variables.serviceGetMatches.setInput('BidID', "");
        $scope.Variables.serviceGetMatches.setInput('TagNumber', "");
        $scope.Variables.serviceGetMatches.setInput('Description', "");
        $scope.Variables.serviceGetMatches.invoke();
    };


    $scope.serviceGetMatchesonBeforeUpdate = function(variable, inputData) {
        inputData.BidID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool2;
        inputData.TagNumber = "";
        inputData.Description = "";
    };




    $scope.buttonDetail1Click = function($event, $isolateScope) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 80) {
            $scope.Variables.liveEquipFA.listRecords();
        }
    };


    $scope.serviceLockSSActivityonBeforeUpdate = function(variable, inputData) {
        //Invoke here because "update on change" in gui doesn't work if NEXT bid match selected is the SAME BidID as current
        $scope.Variables.serviceGetBidActivityQuantities.invoke();
    };

    $scope.serviceLockSSActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            DialogService.open('dialogAssignQuantities', $scope);
        } else {
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 80) {
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
        }
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 80) {
            $scope.$parent.Variables.navigationToClassicEquip.setData({
                'PageLoadBidID': parseInt($scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool2),
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.$parent.Variables.navigationToClassicEquip.invoke();
        }
    };

}]);


Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '6';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.PSAActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.PSAActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.BidID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.PSAActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.PSAActivityID;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.CreatedBy = $scope.Variables.loggedInUser.dataSet.id;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.Note = $scope.Widgets.textareaSSNoteReject.datavalue;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.invoke(); //Updates GetNotesByPSAActivityID
        };


        $scope.textareaSSNoteRejectKeyup = function($event, $isolateScope) {
            if ((Date.now() - $scope.Variables.staticVariableMachineStateTimer.dataValue) > 300) {
                $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();
                $scope.Widgets.labelRejectTextCount.caption = 252 - $scope.Widgets.textareaSSNoteReject.datavalue.length;
            }
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
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '5';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.PSAActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.PSAActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.bidId;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            $scope.Variables.timerLabelFlasher.cancel();
        };



        $scope.dialogAssignQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher.invoke();
        };


        $scope.buttonDialogAssignCancelClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };
    }
]);