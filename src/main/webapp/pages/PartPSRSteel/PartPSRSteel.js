Application.$controller("PartPSRSteelPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
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


    $rootScope.gridApprovalReviewSelectSteel = function() {
        //Set Manual Search Switch to off
        $scope.Widgets.toggleManualSearch.datavalue = '0';
        //Get Matches
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 66) {
            $scope.Variables.serviceGetBidActivityMatchesByTestPackage.invoke();
        } else {
            $scope.Variables.serviceGetMatches.invoke();
        }
    };


    $rootScope.gridApprovalReviewDeselectSteel = function() {
        $scope.Variables.serviceGetMatches.setInput('Area', "");
        $scope.Variables.serviceGetMatches.setInput('PieceMark', "");
        $scope.Variables.serviceGetMatches.invoke();
    };


    $scope.serviceGetMatchesonBeforeUpdate = function(variable, data) {

        if ($scope.Widgets.toggleManualSearch.datavalue == 1) {
            if ($scope.Widgets.textAreaSearch.datavalue) {
                data.Area = "%" + $scope.Widgets.textAreaSearch.datavalue + "%";
            } else {
                data.Area = "%";
            }

            if ($scope.Widgets.textPieceMarkSearch.datavalue) {
                data.PieceMark = "%" + $scope.Widgets.textPieceMarkSearch.datavalue + "%";
            } else {
                data.PieceMark = "%";
            }

            data.BidActivityType = "%";
            data.SteelType = "%";

            if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 67) {
                data.PieceMark = "%";
                data.BidActivityType = "D";
                data.SteelType = "%" + $scope.Widgets.textPieceMarkSearch.datavalue + "%";
            }
        } else {
            if ($scope.Widgets.toggleFilterArea.datavalue == '1') {
                data.Area = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Area + "%";
            } else {
                data.Area = "%";
            }

            if ($scope.Widgets.toggleFilterPieceMark.datavalue == '1') {
                data.PieceMark = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1 + "%";
                data.BidActivityType = "%";
                data.SteelType = "%";
                if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 67) {
                    data.PieceMark = "%";
                    data.BidActivityType = "D";
                    data.SteelType = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1;
                }
            } else {
                data.PieceMark = "%";
                data.BidActivityType = "%";
                data.SteelType = "%";
                if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 67) {
                    data.BidActivityType = "D";
                }
            }
        }
    };


    $scope.toggleManualSearchChange = function($event, $isolateScope, newVal, oldVal) {
        if (newVal === 0) {
            $scope.Variables.serviceGetMatches.invoke();
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) { //Called By dialogAssignQuantitiesOpened
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 61) {
            if ($scope.Widgets.textShakeHrsEarned.datavalue > $scope.Widgets.labelShakeHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textShakeHrsEarned.datavalue);
                    $scope.Widgets.labelShakeHoursRemaining.fontsize = '';
                    $scope.Widgets.labelShakeHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelShakeHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelShakeHoursRemaining.padding = '';
                    $scope.Widgets.labelShakeHoursRemaining.color = '';
                    $scope.Widgets.labelShakeHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelShakeHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelShakeHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelShakeHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelShakeHoursRemaining.padding = "1%";
                    $scope.Widgets.labelShakeHoursRemaining.color = 'black';
                    $scope.Widgets.labelShakeHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 62) {
            if ($scope.Widgets.textErectHrsEarned.datavalue > $scope.Widgets.labelErectHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textErectHrsEarned.datavalue);
                    $scope.Widgets.labelErectHoursRemaining.fontsize = '';
                    $scope.Widgets.labelErectHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelErectHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelErectHoursRemaining.padding = '';
                    $scope.Widgets.labelErectHoursRemaining.color = '';
                    $scope.Widgets.labelErectHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelErectHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelErectHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelErectHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelErectHoursRemaining.padding = "1%";
                    $scope.Widgets.labelErectHoursRemaining.color = 'black';
                    $scope.Widgets.labelErectHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 63) {
            if ($scope.Widgets.textBoltoutHrsEarned.datavalue > $scope.Widgets.labelBoltoutHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textBoltoutHrsEarned.datavalue);
                    $scope.Widgets.labelBoltoutHoursRemaining.fontsize = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.padding = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.color = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelBoltoutHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelBoltoutHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelBoltoutHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelBoltoutHoursRemaining.padding = "1%";
                    $scope.Widgets.labelBoltoutHoursRemaining.color = 'black';
                    $scope.Widgets.labelBoltoutHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 64) {
            if ($scope.Widgets.textImpHrsEarned.datavalue > $scope.Widgets.labelImpHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textImpHrsEarned.datavalue);
                    $scope.Widgets.labelImpHoursRemaining.fontsize = '';
                    $scope.Widgets.labelImpHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelImpHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelImpHoursRemaining.padding = '';
                    $scope.Widgets.labelImpHoursRemaining.color = '';
                    $scope.Widgets.labelImpHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelImpHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelImpHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelImpHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelImpHoursRemaining.padding = "1%";
                    $scope.Widgets.labelImpHoursRemaining.color = 'black';
                    $scope.Widgets.labelImpHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 65) {
            if ($scope.Widgets.textSellHrsEarned.datavalue > $scope.Widgets.labelSellHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textSellHrsEarned.datavalue);
                    $scope.Widgets.labelSellHoursRemaining.fontsize = '';
                    $scope.Widgets.labelSellHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelSellHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelSellHoursRemaining.padding = '';
                    $scope.Widgets.labelSellHoursRemaining.color = '';
                    $scope.Widgets.labelSellHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelSellHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelSellHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelSellHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelSellHoursRemaining.padding = "1%";
                    $scope.Widgets.labelSellHoursRemaining.color = 'black';
                    $scope.Widgets.labelSellHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 67) {
            if ($scope.Widgets.textDemoHrsEarned.datavalue > $scope.Widgets.labelDemoHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textDemoHrsEarned.datavalue);
                    $scope.Widgets.labelDemoHoursRemaining.fontsize = '';
                    $scope.Widgets.labelDemoHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelDemoHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelDemoHoursRemaining.padding = '';
                    $scope.Widgets.labelDemoHoursRemaining.color = '';
                    $scope.Widgets.labelDemoHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelDemoHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelDemoHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelDemoHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelDemoHoursRemaining.padding = "1%";
                    $scope.Widgets.labelDemoHoursRemaining.color = 'black';
                    $scope.Widgets.labelDemoHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 68) {
            if ($scope.Widgets.textWeldHrsEarned.datavalue > $scope.Widgets.labelWeldHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textWeldHrsEarned.datavalue);
                    $scope.Widgets.labelWeldHoursRemaining.fontsize = '';
                    $scope.Widgets.labelWeldHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelWeldHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelWeldHoursRemaining.padding = '';
                    $scope.Widgets.labelWeldHoursRemaining.color = '';
                    $scope.Widgets.labelWeldHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelWeldHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelWeldHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelWeldHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelWeldHoursRemaining.padding = "1%";
                    $scope.Widgets.labelWeldHoursRemaining.color = 'black';
                    $scope.Widgets.labelWeldHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 96) {
            if ($scope.Widgets.textMiscHrsEarned.datavalue > $scope.Widgets.labelMiscHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textMiscHrsEarned.datavalue);
                    $scope.Widgets.labelMiscHoursRemaining.fontsize = '';
                    $scope.Widgets.labelMiscHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelMiscHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelMiscHoursRemaining.padding = '';
                    $scope.Widgets.labelMiscHoursRemaining.color = '';
                    $scope.Widgets.labelMiscHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelMiscHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelMiscHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelMiscHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelMiscHoursRemaining.padding = "1%";
                    $scope.Widgets.labelMiscHoursRemaining.color = 'black';
                    $scope.Widgets.labelMiscHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
    };


    $scope.serviceLockSSActivityonBeforeUpdate = function(variable, inputData) {
        $scope.Variables.serviceGetBidActivityQuantities.invoke(); //Invoke here because "update on change" in gui doesn't work if NEXT bid match selected is the SAME BidID as current
    };


    $scope.serviceLockSSActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 66) { //Open different dialog for Testing activities
                DialogService.open('dialogAssignTestingQuantities', $scope);
            } else {
                DialogService.open('dialogAssignQuantities', $scope);
            }
        } else {
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.ResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        $scope.$parent.Variables.navigationToClassicSteel.setData({
            'PageLoadArea': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Area,
            'PageLoadPieceMark': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1,
            'PageLoadFiltered': true
        });
        //Fire Nav Call
        $scope.$parent.Variables.navigationToClassicSteel.invoke();
    };


    $scope.buttonDissmissClick = function($event, $isolateScope) {
        $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '13';
        $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
        $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
    };


    $scope.serviceGetBidActivityMatchesByTestPackageonBeforeUpdate = function(variable, inputData) {
        inputData.TestPackage = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1;
    };


    $scope.buttonReviewNotes1Click = function($event, $isolateScope) {
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.dataBinding.ActivityID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.invoke();
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonReviewNotes2Click = function($event, $isolateScope) {
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.dataBinding.ActivityID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.invoke();
        DialogService.open('dialogNotes', $scope.$parent);
    };

}]);


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
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.BidID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            $scope.Variables.timerLabelFlasher.cancel();
        };



        $scope.dialogAssignQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher.invoke();
        };


        $scope.dialogAssignQuantitiesClose = function($event, $isolateScope) {
            console.log("PSReview: dialogAssign: closed");
            //$scope.Variables.timerLabelFlasher.cancel();
        };


        $scope.buttonDialogAssignCancelClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };
    }
]);


Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUnLockSSActivity.invoke();
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '6';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.BidID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.CreatedBy = $scope.Variables.loggedInUser.dataSet.id;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.Note = $scope.Widgets.textareaSSNoteReject.datavalue;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.invoke(); //Updates GetNotesByActivityID
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


Application.$controller("dialogAssignTestingQuantitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonQuantitiesUpdate2Click = function($event, $isolateScope) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '5';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = '';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            //$scope.Variables.timerLabelFlasher2.cancel();
            if ($scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 66) {
                $scope.Variables.serviceCreateLooseHoursActivities.invoke();
            }
        };

    }
]);