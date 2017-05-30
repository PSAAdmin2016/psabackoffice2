Application.$controller("ReviewSuperPageController", ["$scope", "$timeout", function($scope, $timeout) {
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

        //Invoke all REF Variables, needed for all PartialPage Select and Search boxes  
        //Currently done on ReviewLanding page
        //$scope.Variables..listRecords();
        //$scope.Variables..listRecords();
        //$scope.Variables..listRecords();
    };



    $scope.buttonRefreshClick = function($event, $isolateScope) {
        $scope.Variables.serviceGetFieldActivities.invoke();

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
        $scope.Variables.serviceUpdateSS.dataBinding.ActivityStatus = '3';
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

        //Update changes to SubsDetails
        $scope.Variables.serviceUpdateSubDetails.invoke();

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


    $scope.gridSuperReviewActivitiesSelect = function($event, $rowData) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false;

        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 10) {
            console.log('Activity Type 10 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 11) {
            $scope.Variables.liveGetSubsErection.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.serviceGetErectionTotal.setInput('ActivityId', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId); //Updated called by liveGetSubsErection
            $scope.Variables.liveGetSubsErection.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAErection';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 20) {
            console.log('Activity Type 20 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 21) {
            $scope.Variables.liveGetSubsBoltUp.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsBoltUp.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFABoltUp';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 22 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 23) {
            $scope.Variables.liveGetSubsWeld.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsWeld.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAWeld';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 30) {
            console.log('Activity Type 30 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 31 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 33 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 34 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 35 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 39) {
            $scope.Variables.liveGetSubsTrim.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsTrim.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFATrim';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 32) {
            $scope.Variables.liveGetSubsSupports.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsSupports.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASupports';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 40 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 41 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 42 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 43) {
            $scope.Variables.liveGetSubsTesting.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsTesting.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFATesting';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 50 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 51 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 52 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 53 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 59) {
            $scope.Variables.liveGetSubsDemo.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsDemo.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFADemo';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 60) {
            console.log('Activity Type 60 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 61) {
            $scope.Variables.liveGetSteelShake.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelShake.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelShake';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 62) {
            $scope.Variables.liveGetSteelErect.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelErect.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelErect';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 63) {
            $scope.Variables.liveGetSteelBoltOut.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelBoltOut.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelBoltOut';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 64) {
            $scope.Variables.liveGetSteelImp.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelImp.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelImpact';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 65) {
            $scope.Variables.liveGetSteelSell.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelSell.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelSell';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 66) {
            $scope.Variables.liveGetSteelSellPackage.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelSellPackage.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelSellPackage';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 67) {
            $scope.Variables.liveGetSteelDemo.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelDemo.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelDemo';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 68) {
            $scope.Variables.liveGetSteelWeld.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelWeld.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelWeld';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 70 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 71) {
            $scope.Variables.liveGetCivilFA.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetCivilFA.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilStandard';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 72) {
            $scope.Variables.liveGetCivilSellPackage.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetCivilSellPackage.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilSellPackage';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 77) {
            console.log('Activity Type 77 not defined: ReviewSuperPipe: GridActivitySelect');
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 80) {
            $scope.Variables.liveGetEquipFA.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetEquipFA.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAEquipStandard';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 90 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 91) {
            $scope.Variables.liveGetSubsMisc.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAMisc';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 93) {
            $scope.Variables.liveGetSubsEWO.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSubsEWO.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFAEWO';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 96) {
            $scope.Variables.liveGetSteelMisc.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetSteelMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFASteelMisc';
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 97) {
            $scope.Variables.liveGetCivilMisc.setFilter('id', $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityRowId);
            $scope.Variables.liveGetCivilMisc.listRecords();
            $scope.Widgets.containerFADetails.content = 'PartFACivilMisc';
        }
    };


    $scope.gridSuperReviewActivitiesDatarender = function($isolateScope, $data) {
        $timeout(function() {
            $scope.Widgets.gridSuperReviewActivities.onRowFilterChange();
        });
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 11) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetSubsErection.dataSet.data[0].erectionDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsErection.dataSet.data[0].erectionSheetNumber,
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
                'PageLoadDrawing': $scope.Variables.liveGetSubsBoltUp.dataSet.data[0].boltUpDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsBoltUp.dataSet.data[0].boltUpSheetNumber,
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
                'PageLoadDrawing': $scope.Variables.liveGetSubsWeld.dataSet.data[0].weldDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsWeld.dataSet.data[0].weldSheetNumber,
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
                'PageLoadDrawing': $scope.Variables.liveGetSubsTrim.dataSet.data[0].trimDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsTrim.dataSet.data[0].trimSheetNumber,
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
                'PageLoadDrawing': $scope.Variables.liveGetSubsSupports.dataSet.data[0].supportDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsSupports.dataSet.data[0].supportSheetNumber,
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
                'PageLoadTestPackage': $scope.Variables.liveGetSubsTesting.dataSet.data[0].testingTestPackageNumber,
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.Variables.navigationToClassicPipe.invoke();
        }
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 51 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 52 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 53 || $scope.Widgets.gridSuperReviewActivities.selecteditem.ActivityType == 59) {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadDrawing': $scope.Variables.liveGetSubsDemo.dataSet.data[0].demoDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsDemo.dataSet.data[0].demoSheetNumber,
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
                'PageLoadDrawing': $scope.Variables.liveGetSubsMisc.dataSet.data[0].miscDrawingNumber,
                'PageLoadSheet': $scope.Variables.liveGetSubsMisc.dataSet.data[0].miscSheetNumber,
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

}]);

Application.$controller("gridSuperReviewActivitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
        $scope.formatDate = function(val) {
            return moment(val).utcOffset('+00:00').format('YYYY-MM-DD hh:mm:ss a');
        };
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