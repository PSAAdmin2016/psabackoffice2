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
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '1') {
            switch ($scope.Widgets.gridSuperReviewActivities.selecteditem.fk_ActivityStatus) {
                case 1:
                case 10:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "2");
                    break;
                case 6:
                case 8:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "7");
                    break;
                case 4:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "9");
            }
            $scope.Variables.serviceUpdateSS.invoke();
        } else if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
            switch ($scope.Widgets.gridSuperReviewSteel.selecteditem.fk_ActivityStatus) {
                case 1:
                case 10:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "2");
                    break;
                case 6:
                case 8:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "7");
                    break;
                case 4:
                    $scope.Variables.serviceUpdateSS.setInput("ActivityStatus", "9");
            }
            //Need logic for looping through all FA's that make up the one row selected in the gridSuperReviewSteel.  
            //OR pass a List to the querry if that works right.
            //OR Build an array of objects to pass to an UpdateSS LiveVariable -> setInput() -> invoke()
            //$scope.Variables.serviceUpdateSS.invoke();
        }

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
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '1') {

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


    $scope.gridSuperReviewActivitiesSelect = function($event, $isolateScope, $rowData) {
        if ($rowData.activityId === undefined) { //Skip logic if Nothing selected.
            return;
        }
        if ($scope.Variables.staticTabSelect.dataSet.dataValue != '1') { //Skip logic if Tab Not selected.
            return;
        }

        $scope.Variables.staticEditMode.dataSet.dataValue = false;

        // Update liveGetActivityDetails with newly selected Row
        $scope.Variables.liveGetActivityDetails.listRecords({
            filterFields: {
                "activityId": {
                    "value": $rowData.activityId
                }
            }
        });

    };


    $scope.liveGetActivityDetailsonSuccess = function(variable, data) {
        switch (data[0].activityType) {
            // Pipe Activities
            case 11:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeErection';
                break;
            case 22:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeWeld';
                break;
            case 21:
            case 24:
            case 25:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeConnection';
                break;
            case 41:
            case 42:
            case 43:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeTesting';
                break;
            case 23:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 90:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeStandard';
                break;
            case 91:
                $scope.Widgets.containerFADetails.content = 'PartFAPipeMisc';
                break;
                // Steel Activities (Non Piece work)
            case 66:
                $scope.Widgets.containerFADetails.content = 'PartFASteelSellPackage';
                break;
            case 67:
                $scope.Widgets.containerFADetails.content = 'PartFASteelDemo';
                break;
            case 96:
                $scope.Widgets.containerFADetails.content = 'PartFASteelMisc';
                break;
                // Civil Activities
            case 70:
            case 71:
                $scope.Widgets.containerFADetails.content = 'PartFACivilStandard';
                break;
            case 72:
                $scope.Widgets.containerFADetails.content = 'PartFACivilSellPackage';
                break;
                // Equip Activities
            case 80:
                $scope.Widgets.containerFADetails.content = 'PartFAEquipStandard';
                break;
        }
    };


    $scope.gridSuperReviewSteelSelect = function($event, $rowData) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false;
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
            if ($scope.Widgets.containerFADetails.Variables.staticEditMode.dataSet.dataValue) {
                $scope.Widgets.containerFADetails.Variables.staticEditMode.setValue("dataValue", false);
                $scope.Widgets.containerFADetails.Widgets.gridSteelFA.cancelRow();
            }
            $scope.Variables.liveGetSubsDetails.setFilter('submissionId', $rowData.submissionId);
            $scope.Variables.liveGetSubsDetails.listRecords();
        }
    };


    $scope.gridSuperReviewActivitiesDatarender = function($isolateScope, $data) {
        $timeout(function() {
            $scope.Widgets.gridSuperReviewActivities.onRowFilterChange();
        });
    };


    $scope.tabFAsSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '1');
        //$scope.Variables.liveGetSubsDetails.setFilter('submissionId', $scope.Widgets.gridSuperReviewActivities.selecteditem.submissionId);
        //$scope.Variables.liveGetSubsDetails.listRecords();
        //$scope.gridSuperReviewActivitiesSelect(null, null, $scope.Widgets.gridSuperReviewActivities.selecteditem);
    };


    $scope.tabSteelSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '2');
        $scope.Widgets.containerFADetails.content = 'PartFASteelStandard';
    };


    $scope.liveGetSubsSignaturesonSuccess = function(variable, data) { //SubsSignatures Called by On Success event in liveGetSubsDetails variable
        //$scope.signaturePad.fromDataURL(data[0].signatureData);
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