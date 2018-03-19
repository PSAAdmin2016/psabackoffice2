Application.$controller("PartPSRPipePageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
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


    $scope.buttonAssign2Click = function($event, $isolateScope) {
        $scope.Variables.serviceLockSSActivity.invoke();
    };


    $scope.ResearchClick = function($event, $isolateScope) {
        debugger;
        $scope.$parent.savePageSettings();

        if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool2') {
            // Set DWG & Sheet of Nav call 
            $scope.$parent.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2,
                'PageLoadSheet': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2,
                'PageLoadECT': $scope.Variables.staticECT.dataSet.dataValue,
                'PageLoadECTSubType': $scope.Variables.staticECTType.dataSet.dataValue,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.$parent.Variables.navigationToClassicPipe.invoke();
        } else {
            // Set DWG & Sheet of Nav call 
            $scope.$parent.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1,
                'PageLoadSheet': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1,
                'PageLoadECT': $scope.Variables.staticECT.dataSet.dataValue,
                'PageLoadECTSubType': $scope.Variables.staticECTType.dataSet.dataValue,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.$parent.Variables.navigationToClassicPipe.invoke();

        }

    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        //Update only the Required Live variable as needed on Detail click.
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 11 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 10) {
            $scope.Variables.liveApprovalErection.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 21) {
            $scope.Variables.liveApprovalBoltUp.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 22 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 23) {
            $scope.Variables.liveApprovalWeld.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 31 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 33 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 34 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 35 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 39) {
            $scope.Variables.liveApprovalTrim.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 32) {
            $scope.Variables.liveApprovalSupports.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 51 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 52 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 53 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 59) {
            $scope.Variables.liveApprovalDemo.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 91) {
            $scope.Variables.liveApprovalMisc.listRecords();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 93) {
            $scope.Variables.liveApprovalEWO.listRecords();
        }
    };


    $scope.toggleManualSearchChange = function($event, $isolateScope, newVal, oldVal) {
        if (newVal === 0) {
            $scope.Variables.serviceGetBidActivityMatches.invoke();
        }
    };


    $scope.timerAssignDelayonTimerFire = function(variable, data) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 11) {
            $scope.Variables.serviceGetQuantityLFInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityLFInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 21) {
            $scope.Variables.serviceGetQuantityBoltUpInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityBoltUpInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 22) {
            $scope.Variables.serviceGetQuantityWeldInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityWeldInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 23) {
            $scope.Variables.serviceGetQuantityCutPrepInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityCutPrepInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 31 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 33 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 34 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 35 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 39) {
            $scope.Variables.serviceGetQuantityTrimInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityTrimInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 32) {
            $scope.Variables.serviceGetQuantitySupportsInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantitySupportsInstalled.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 40 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 42 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 43) {
            $scope.Variables.serviceGetQuantitiesTestPackage.setInput('TestPackage', $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1);
            $scope.Variables.serviceGetQuantitiesTestPackage.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 51 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 52 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 53 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 59) {
            $scope.Variables.serviceGetQuantityDemoRem.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityDemoRem.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 91) {
            $scope.Variables.serviceGetQuantityMiscInstalled.setInput('BidID', $scope.Widgets.livelistBidActivities.selecteditem.BidID);
            $scope.Variables.serviceGetQuantityMiscInstalled.invoke();
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) { // Fired from Assign Dialog On Open
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 10 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 11) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelErectionHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelErectionHoursRemaining.fontsize = '';
                    $scope.Widgets.labelErectionHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelErectionHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelErectionHoursRemaining.padding = '';
                    $scope.Widgets.labelErectionHoursRemaining.color = '';
                    $scope.Widgets.labelErectionHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelErectionHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelErectionHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelErectionHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelErectionHoursRemaining.padding = "1%";
                    $scope.Widgets.labelErectionHoursRemaining.color = 'black';
                    $scope.Widgets.labelErectionHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 21) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelBoltUpHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelBoltUpHoursRemaining.fontsize = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.padding = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.color = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelBoltUpHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelBoltUpHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelBoltUpHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelBoltUpHoursRemaining.padding = "1%";
                    $scope.Widgets.labelBoltUpHoursRemaining.color = 'black';
                    $scope.Widgets.labelBoltUpHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 22) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelWeldHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
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
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 23) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelCutHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelCutHoursRemaining.fontsize = '';
                    $scope.Widgets.labelCutHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelCutHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelCutHoursRemaining.padding = '';
                    $scope.Widgets.labelCutHoursRemaining.color = '';
                    $scope.Widgets.labelCutHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelCutHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelCutHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelCutHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelCutHoursRemaining.padding = "1%";
                    $scope.Widgets.labelCutHoursRemaining.color = 'black';
                    $scope.Widgets.labelCutHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 30 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 31 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 33 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 34 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 35 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 39) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelTrimHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelTrimHoursRemaining.fontsize = '';
                    $scope.Widgets.labelTrimHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelTrimHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelTrimHoursRemaining.padding = '';
                    $scope.Widgets.labelTrimHoursRemaining.color = '';
                    $scope.Widgets.labelTrimHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelTrimHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelTrimHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelTrimHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelTrimHoursRemaining.padding = "1%";
                    $scope.Widgets.labelTrimHoursRemaining.color = 'black';
                    $scope.Widgets.labelTrimHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 32) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelSupportHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelSupportHoursRemaining.fontsize = '';
                    $scope.Widgets.labelSupportHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelSupportHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelSupportHoursRemaining.padding = '';
                    $scope.Widgets.labelSupportHoursRemaining.color = '';
                    $scope.Widgets.labelSupportHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelSupportHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelSupportHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelSupportHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelSupportHoursRemaining.padding = "1%";
                    $scope.Widgets.labelSupportHoursRemaining.color = 'black';
                    $scope.Widgets.labelSupportHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 51 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 52 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 53 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 59) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelDemoHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
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
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 91) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelMiscHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
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


    $scope.timerLabelFlasher2onTimerFire = function(variable, data) { //Fired from Assign Testing Dialog On Open
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41) {
            if ($scope.Widgets.textReadyForTestHrsEarned.datavalue > $scope.Widgets.labelRFTHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelRFTHoursRemaining.fontsize = '';
                    $scope.Widgets.labelRFTHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelRFTHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelRFTHoursRemaining.padding = '';
                    $scope.Widgets.labelRFTHoursRemaining.color = '';
                    $scope.Widgets.labelRFTHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelRFTHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelRFTHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelRFTHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelRFTHoursRemaining.padding = "1%";
                    $scope.Widgets.labelRFTHoursRemaining.color = 'black';
                    $scope.Widgets.labelRFTHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 42) {
            if ($scope.Widgets.textHydroHrsEarned.datavalue > $scope.Widgets.labelHydroHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelHydroHoursRemaining.fontsize = '';
                    $scope.Widgets.labelHydroHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelHydroHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelHydroHoursRemaining.padding = '';
                    $scope.Widgets.labelHydroHoursRemaining.color = '';
                    $scope.Widgets.labelHydroHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelHydroHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelHydroHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelHydroHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelHydroHoursRemaining.padding = "1%";
                    $scope.Widgets.labelHydroHoursRemaining.color = 'black';
                    $scope.Widgets.labelHydroHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 43) {
            if ($scope.Widgets.textClientTurnoverHrsEarned.datavalue > $scope.Widgets.labelClientTurnoverHoursRemainin.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelClientTurnoverHoursRemainin.fontsize = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.borderstyle = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.bordercolor = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.padding = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.color = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelClientTurnoverHoursRemainin.fontsize = "16";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.borderstyle = "solid";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.bordercolor = "#fffd00";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.padding = "1%";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.color = 'black';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
    };


    $rootScope.gridApprovalReviewSelectPipe = function() {
        //Set Filter Switch to Spool1
        $scope.Widgets.switchSpool1Spool2.datavalue = 'Spool1';

        //Set Manual Search Switch to off
        $scope.Widgets.toggleManualSearch.datavalue = '0';

        //Logic to update only approriate live variable based on gridApproval selected item activity type. 
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 11 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 10) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalErection.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "E";
            $scope.Variables.staticECTType.dataSet.dataValue = "PE";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 20) {
            //Set Live Variable Data Filter.
            //$scope.Variables.liveApprovalConnectionBasic.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            //$scope.Variables.liveApprovalConnectionBasic.invoke();
            //Set ECT and ECTType
            //$scope.Variables.staticECT.dataSet.dataValue = "C";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 21) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalBoltUp.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "C";
            $scope.Variables.staticECTType.dataSet.dataValue = "BU";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 22) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalWeld.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "C";
            $scope.Variables.staticECTType.dataSet.dataValue = "W";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 23) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalWeld.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "C";
            $scope.Variables.staticECTType.dataSet.dataValue = "CUT";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 30) {
            //Set Live Variable Data Filter.
            //$scope.Variables.liveApprovalTrimBasic.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            //$scope.Variables.liveApprovalTrimBasic.invoke();
            //Set ECT and ECTType
            //$scope.Variables.staticECT.dataSet.dataValue = "T";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 31) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalTrim.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "V";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 32) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalSupports.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "S";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 33) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalTrim.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "Plug";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 34) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalTrim.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "Blind";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 35) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalTrim.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "HpLp";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 39) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalTrim.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "Other";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 40 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 42 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 43) {
            //Set Live Variable Data Filter.
            $scope.Variables.serviceGetBidActivityMatchesByTestPackage.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 51) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalDemo.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "D";
            $scope.Variables.staticECTType.dataSet.dataValue = "DE";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 52) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalDemo.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "D";
            $scope.Variables.staticECTType.dataSet.dataValue = "UB";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 53) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalDemo.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "D";
            $scope.Variables.staticECTType.dataSet.dataValue = "CUT";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 59) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalDemo.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "D";
            $scope.Variables.staticECTType.dataSet.dataValue = "MISC";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 90 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 91) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalMisc.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "T";
            $scope.Variables.staticECTType.dataSet.dataValue = "MISC";
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 93) {
            //Set Live Variable Data Filter.
            $scope.Variables.liveApprovalEWO.setFilter('ActivityID', $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID);
            $scope.Variables.serviceGetBidActivityMatches.invoke();
            //Set ECT and ECTType
            $scope.Variables.staticECT.dataSet.dataValue = "Field EWO";
            $scope.Variables.staticECTType.dataSet.dataValue = "Field EWO";
        }
    };


    $rootScope.gridApprovalReviewDeselectPipe = function() {
        $scope.Widgets.switchSpool1Spool2.datavalue = 'Spool1';
        $scope.Variables.staticECT.dataSet.dataValue = "";
        $scope.Variables.staticECTType.dataSet.dataValue = "";
        $scope.Variables.serviceGetBidActivityMatches.setInput('LineNumber', "");
        $scope.Variables.serviceGetBidActivityMatches.setInput('DrawingNumber', "");
        $scope.Variables.serviceGetBidActivityMatches.setInput('SheetNumber', "");
        $scope.Variables.serviceGetBidActivityMatches.setInput('ECT', '');
        $scope.Variables.serviceGetBidActivityMatches.setInput('ECTType', '');
        $scope.Variables.serviceGetBidActivityMatches.invoke();
    };


    $scope.serviceGetBidActivityMatchesonBeforeUpdate = function(variable, data) {

        if ($scope.Widgets.toggleManualSearch.datavalue == 1) {
            console.log("ManualSearch: " + $scope.Widgets.toggleManualSearch.datavalue);
            if ($scope.Widgets.textLineNumberSearch.datavalue) {
                data.LineNumber = "%" + $scope.Widgets.textLineNumberSearch.datavalue + "%";
            } else {
                data.LineNumber = "%";
            }
            if ($scope.Widgets.textDrawingNumberSearch.datavalue) {
                data.DrawingNumber = "%" + $scope.Widgets.textDrawingNumberSearch.datavalue + "%";
            } else {
                data.DrawingNumber = "%";
            }
            if ($scope.Widgets.textSheetNumberSearch.datavalue) {
                data.SheetNumber = $scope.Widgets.textSheetNumberSearch.datavalue;
            } else {
                data.SheetNumber = "%";
            }
        } else {
            if ($scope.Widgets.toggleFilterLineNumber.datavalue == '1') {
                if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1) {
                        data.LineNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1 + "%";
                    } else {
                        data.LineNumber = "%";
                    }
                } else {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Line2) {
                        data.LineNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line2 + "%";
                    } else {
                        data.LineNumber = "%";
                    }
                }
            } else {
                data.LineNumber = "%";
            }
            if ($scope.Widgets.toggleFilterDrawingNumber.datavalue == '1') {
                if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1) {
                        data.DrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1 + "%";
                    } else {
                        data.DrawingNumber = "%";
                    }
                } else {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2) {
                        data.DrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2 + "%";
                    } else {
                        data.DrawingNumber = "%";
                    }
                }
            } else {
                data.DrawingNumber = "%";
            }
            if ($scope.Widgets.toggleFilterSheetNumber.datavalue == '1') {
                if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1) {
                        data.SheetNumber = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1;
                    } else {
                        data.SheetNumber = "%";
                    }
                } else {
                    if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2) {
                        data.SheetNumber = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2;
                    } else {
                        data.SheetNumber = "%";
                    }
                }
            } else {
                data.SheetNumber = "%";
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 11 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 10) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'E';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'PE';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 20) {
            /*
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'C';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = '%';
            } else {
                data.ECTType = '%';
            }*/
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 21) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'C';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'BU';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 22) {

            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'C';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'W';
            } else {
                data.ECTType = '%';
            }

        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 23) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'C';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'CUT';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 30) {
            /*
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = '%';
            } else {
                data.ECTType = '%';
            }
            */
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 31) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'V';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 32) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'S';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 33) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'Plug';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 34) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'Blind';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 35) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'HpLp';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 39) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'Other';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 51) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'D';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'DE';
            } else {
                data.ECTType = '%';
            }
        }

        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 52) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'D';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'UB';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 53) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'D';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'CUT';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 59) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'D';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = 'MISC';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 90 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 91) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = 'T';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = '%';
            } else {
                data.ECTType = '%';
            }
        }


        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 93) {
            if ($scope.Widgets.toggleFilterECT.datavalue == '1') {
                data.ECT = '%';
            } else {
                data.ECT = '%';
            }

            if ($scope.Widgets.toggleFilterECTType.datavalue == '1') {
                data.ECTType = '%';
            } else {
                data.ECTType = '%';
            }
        }
    };


    $scope.serviceGetBidActivityMatchesByTestPackageonBeforeUpdate = function(variable, data) {
        data.TestPackage = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1;
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) {
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.serviceLockSSActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            //Open different dialog for Testing activities
            if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 40 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 42 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 43) {
                $scope.Variables.timerAssignDelay.invoke();
                DialogService.open('dialogAssignTestingQuantities', $scope);
            } else {
                $scope.Variables.serviceGetBidActivityQuantity.invoke(); // This variable is not used for Testing Activities
                $scope.Variables.timerAssignDelay.invoke();
                DialogService.open('dialogAssignQuantities', $scope);

            }
        } else {
            $scope.$parent.Variables.staticRecordLockedMessage.dataSet.dataValue = data[0].ErrorText;
            DialogService.open('alertRecordLocked', $scope.$parent);
        }

    };


}]);


Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '6';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = '';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.CreatedBy = $scope.Variables.loggedInUser.dataSet.id;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.Note = $scope.Widgets.textareaSSNoteReject.datavalue;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.invoke(); //Updates serviceGetNotesByFieldActivityID
        };


        $scope.textareaSSNoteRejectKeyup = function($event, $isolateScope) {
            if ((Date.now() - $scope.Variables.staticVariableMachineStateTimer.dataValue) > 300 && $scope.Widgets.textareaSSNoteReject.datavalue) {
                $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();
                $scope.Widgets.labelRejectTextCount.caption = 252 - $scope.Widgets.textareaSSNoteReject.datavalue.length;
            }
        };


        $scope.buttonDialogRejectionSaveClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
            $scope.Variables.timerLabelFlasher2.cancel();
        };

    }
]);


Application.$controller("dialogFielActivityDetailsController", ["$scope",
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


Application.$controller("dialogAssignTestingQuantitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonQuantitiesUpdate2Click = function($event, $isolateScope) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '5';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = '';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            $scope.Variables.timerLabelFlasher2.cancel();
            if ($scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41 && $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1 != '1') {
                //NOTE: I'm using Sheet1 variable to pass in TestingRework Value of 0 or 1  this is handled within the Job1111.GetActivitiesPendingApproval query
                $scope.Variables.serviceCreateLooseHoursActivities.invoke();
            }
        };


        $scope.dialogAssignTestingQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher2.invoke();
        };


        $scope.buttonDialogAssignTestCancelClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher2.cancel();
        };

    }
]);