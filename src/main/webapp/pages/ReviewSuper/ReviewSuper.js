Application.$controller("ReviewSuperPageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        //Invoke all REF Variables, needed for all PartialPage Select and Search boxes  
        //Currently done on ReviewLanding page
        //$scope.Variables..listRecords();
        //$scope.Variables..listRecords();
        //$scope.Variables..listRecords();

        //Initialize Signiture pad canvas
        var signaturePad = new SignaturePad(document.getElementById('signature-pad'), {
            backgroundColor: 'rgb(255, 255, 255)',
            penColor: 'rgb(0, 0, 0)'
        });
        $scope.signaturePad = signaturePad;
        $scope.signaturePad.off();
    };


    $scope.buttonRefreshClick = function($event, $isolateScope) {
        $scope.Variables.serviceGetFAs.invoke();
        $scope.Variables.serviceGetFAsSteel.invoke();
    };


    $scope.btnAcceptClick = function($event, $isolateScope) {
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 1 || $scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 10) { //New || Returned To List
            $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = 2;
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 6 || $scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 8) { //Progress Returned || Progress Rejected mod
            $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = 7;
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 4) { // Supervisor Modified
            $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = 9;
        }
        $scope.Variables.serviceUpdateSS.invoke();
    };


    $scope.btnRejectClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "3");
        $scope.Variables.serviceUpdateSS.invoke();
    };


    $scope.btnModifyClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = true;
    };


    $scope.btnCancelClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false;
    };


    $scope.btnSaveClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false; //disable all fields
        if ($scope.Variables.staticTabSelect.dataValue == '1') {

        }

        //Update changes to Field Activities
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 22) {
            $scope.Widgets.containerFADetails.Variables.serviceUpdateWeld.invoke();
        } else if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 23) {
            $scope.Widgets.containerFADetails.Variables.serviceUpdateCutPrep.invoke();
        } else {
            $scope.Widgets.containerFADetails.Variables.serviceUpdateActivity.invoke();
        }

        //Update changes to Field Activity status (SS)

        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 6 || $scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus == 8) {
            $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = 8; // Progress Rejected Mod
        } else {
            $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = 4; //Supervisor Modified
        }
        $scope.Variables.serviceUpdateSS.invoke();

    };


    $scope.gridSuperReviewActivitiesSelect = function($event, $isolateScope, $rowData) {
        if ($rowData.activityId === undefined) {
            // Avoid unneeded logic and Data requests on initial page load.
            return;
        }

        $scope.Variables.staticEditMode.dataSet.dataValue = false;

        $scope.Variables.liveGetSubsDetails.setFilter('submissionId', $rowData.submissionId);
        $scope.Variables.liveGetSubsDetails.listRecords();

        if ($rowData.activityType == 10) {
            console.log('Activity Type 10 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($rowData.activityType == 11) {
            $scope.Variables.liveGetPipeErection.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeErection.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeErection';
        }
        if ($rowData.activityType == 20) {
            console.log('Activity Type 20 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($rowData.activityType == 21) {
            $scope.Variables.liveGetPipeBoltUp.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeBoltUp.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeBoltUp';
        }
        if ($rowData.activityType == 22 || $rowData.activityType == 23) {
            $scope.Variables.liveGetPipeWeld.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeWeld.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeWeld';
        }
        if ($rowData.activityType == 30) {
            console.log('Activity Type 30 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($rowData.activityType == 31 || $rowData.activityType == 33 || $rowData.activityType == 34 || $rowData.activityType == 35 || $rowData.activityType == 39) {
            $scope.Variables.liveGetPipeTrim.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeTrim.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeTrim';
        }
        if ($rowData.activityType == 32) {
            $scope.Variables.liveGetPipeSupports.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeSupports.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeSupport';
        }
        if ($rowData.activityType == 40 || $rowData.activityType == 41 || $rowData.activityType == 42 || $rowData.activityType == 43) {
            $scope.Variables.liveGetPipeTesting.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeTesting.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeTesting';
        }
        if ($rowData.activityType == 50 || $rowData.activityType == 51 || $rowData.activityType == 52 || $rowData.activityType == 53 || $rowData.activityType == 59) {
            $scope.Variables.liveGetPipeDemo.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeDemo.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeDemo';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType == 66) {
            $scope.Variables.liveGetSteelSellPackage.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetSteelSellPackage.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelSellPackage';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType == 67) {
            $scope.Variables.liveGetSteelDemo.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetSteelDemo.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelDemo';
        }

        if ($rowData.activityType == 70 || $rowData.activityType == 71) {
            $scope.Variables.liveGetCivilTracker.setFilter('BidID', $rowData.bidId);
            $scope.Variables.liveGetCivilTracker.listRecords();
            $scope.Variables.liveGetCivilFA.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetCivilFA.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilStandard';
        }
        if ($rowData.activityType == 72) {
            $scope.Variables.liveGetCivilSellPackage.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetCivilSellPackage.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilSellPackage';
        }

        if ($rowData.activityType == 80) {
            $scope.Variables.liveGetEquipFA.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetEquipFA.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAEquipStandard';
        }

        if ($rowData.activityType == 90 || $rowData.activityType == 91) {
            $scope.Variables.liveGetPipeMisc.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAPipeMisc';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType == 93) {
            $scope.Variables.liveGetPipeEWO.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetPipeEWO.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAEWO';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType == 96) {
            $scope.Variables.liveGetSteelMisc.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetSteelMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelMisc';
        }
        if ($rowData.activityType == 97) {
            $scope.Variables.liveGetCivilMisc.setFilter('ActivityID', $rowData.activityId);
            $scope.Variables.liveGetCivilMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilMisc';
        }
    };


    $scope.gridSuperReviewSteelSelect = function($event, $rowData) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false;

        $scope.Variables.liveGetSubsDetails.setFilter('submissionId', $rowData.submissionId);
        $scope.Variables.liveGetSubsDetails.listRecords();
    };


    $scope.gridSuperReviewActivitiesDatarender = function($isolateScope, $data) {
        $timeout(function() {
            $scope.Widgets.gridSuperReviewActivities.onRowFilterChange();
        });
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 11) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeErection.dataSet.data[0].erectionDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeErection.dataSet.data[0].erectionSheetNumber,
                'PageLoadECT': 'E',
                'PageLoadECTSubType': 'PE',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 21) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeBoltUp.dataSet.data[0].boltUpDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeBoltUp.dataSet.data[0].boltUpSheetNumber,
                'PageLoadECT': 'C',
                'PageLoadECTSubType': 'BU',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 22 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 23) {
            // Set DWG & Sheet of Nav call 
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeWeld.dataSet.data[0].weldDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeWeld.dataSet.data[0].weldSheetNumber,
                'PageLoadECT': 'C',
                'PageLoadECTSubType': 'W',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 31 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 33 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 34 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 35 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 39) {
            // Set DWG & Sheet of Nav call 
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeTrim.dataSet.data[0].trimDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeTrim.dataSet.data[0].trimSheetNumber,
                'PageLoadECT': 'T',
                'PageLoadECTSubType': '',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();

        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 32) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeSupports.dataSet.data[0].supportDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeSupports.dataSet.data[0].supportSheetNumber,
                'PageLoadECT': 'T',
                'PageLoadECTSubType': 'S',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 41 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 42 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 43) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': '',
                'PageLoadSheet': '',
                'PageLoadECT': '',
                'PageLoadECTSubType': '',
                'PageLoadTestPackage': $scope.Variables.liveGetPipeTesting.dataSet.data[0].testingTestPackageNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 51 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 52 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 53 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 59) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeDemo.dataSet.data[0].demoDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeDemo.dataSet.data[0].demoSheetNumber,
                'PageLoadECT': 'D',
                'PageLoadECTSubType': '',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 91) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetPipeMisc.dataSet.data[0].miscDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetPipeMisc.dataSet.data[0].miscSheetNumber,
                'PageLoadECT': 'T',
                'PageLoadECTSubType': 'MISC',
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 61) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelShake.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelShake.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 62) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelErect.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelErect.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 63) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelBoltOut.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelBoltOut.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 64) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelImp.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelImp.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 68) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelWeld.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelWeld.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 65) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelSell.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelSell.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 67) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelDemo.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelDemo.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 96) {
            $scope.Variables.navigationToClassicSteel.setData({
                'PageLoadArea': $scope.Variables.liveGetSteelMisc.dataSet.data[0].faarea,
                'PageLoadPieceMark': $scope.Variables.liveGetSteelMisc.dataSet.data[0].fapieceNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicSteel.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 70 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 71) {
            $scope.Variables.navigationToClassicCivil.setData({
                'PageLoadBidID': $scope.Variables.liveGetCivilFA.dataSet.data[0].fabidId,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicCivil.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 80) {
            $scope.Variables.navigationToClassicEquip.setData({
                'PageLoadBidID': $scope.Variables.liveGetEquipFA.dataSet.data[0].fabidId,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicEquip.invoke();
        }
    };


    $scope.tabFAsSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '1');

        $scope.Variables.liveGetSubsDetails.setFilter('submissionId', $scope.Widgets.gridSuperReviewActivities.selecteditem.submissionId);
        $scope.Variables.liveGetSubsDetails.listRecords();

        $scope.gridSuperReviewActivitiesSelect(null, null, $scope.Widgets.gridSuperReviewActivities.selecteditem);
    };


    $scope.tabSteelSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '2');
        $scope.Widgets.containerFADetails.content = 'PartFASteelStandard';
    };


    $scope.liveGetSubsSignaturesonSuccess = function(variable, data) { //SubsSignatures Called by On Success event in liveGetSubsDetails variable
        $scope.signaturePad.fromDataURL(data[0].signatureData);
    };









}]);




Application.$controller("gridSuperReviewActivitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialogNotesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridNotesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

    }
]);

Application.$controller("dialogNotesNewController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;


        $scope.textareaSSNoteNewKeyup = function($event, $isolateScope) {
            if ((Date.now() - $scope.Variables.staticVariableMachineStateTimer.dataValue) > 300) {
                $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();
                $scope.Widgets.labelTextCountNewNote.caption = 252 - $scope.Widgets.textareaSSNoteNew.datavalue.length;
            }
        };

    }
]);

Application.$controller("dialogRecentActivitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridSuperReviewSteelController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);