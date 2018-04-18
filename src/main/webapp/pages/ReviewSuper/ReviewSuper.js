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
        //### Pipe FAs ###
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '1') {
            switch ($scope.Widgets.gridSuperReviewActivities.selecteditem.fkActivityStatus) {
                case 1:
                case 10:
                    $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "2");
                    break;
                case 6:
                case 8:
                    $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "7");
                    break;
                case 4:
                    $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "9");
            }

            $scope.Variables.serviceUpdateSAS.invoke({},
                function(data) {
                    $scope.Variables.serviceGetFAs.invoke();
                }
            );
        }

        //### Steel FAs ###
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
            console.log("Logic for Accept Steel Piece Work not built yet.");
            $scope.Widgets.gridSuperReviewSteel
            debugger;
            //Need logic for looping through all FA's that make up the one row selected in the gridSuperReviewSteel.  
            //OR pass a List to the querry if that works right.
            //OR Build an array of objects to pass to an UpdateSS LiveVariable -> setInput() -> invoke()
            //$scope.Variables.serviceUpdateSS.invoke();
        }

    };


    $scope.btnRejectClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "3");
        $scope.Variables.serviceUpdateSAS.invoke({},
            function(data) {
                $scope.Variables.serviceGetFAs.invoke();
            }
        );
    };


    $scope.btnModifyClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = true;
    };


    $scope.btnCancelClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false;
    };


    $scope.btnSaveClick = function($event, $isolateScope) {
        $scope.Variables.staticEditMode.dataSet.dataValue = false; //disable all fields

        $scope.Widgets.containerFADetails.Variables.serviceUpdateActivity.invoke();

        //Update changes to Field Activity status (SAS)
        if ($scope.Widgets.gridSuperReviewActivities.selecteditem.fkActivityStatus == 6 || $scope.Widgets.gridSuperReviewActivities.selecteditem.fkActivityStatus == 8) {
            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "8"); // Progress Rejected Mod
        } else {
            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", "4"); //Supervisor Modified
        }

        $scope.Variables.serviceUpdateSAS.invoke({},
            function(data) {
                $scope.Variables.serviceGetFAs.invoke();
            }
        );
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '1') {
            switch ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType) {
                // Pipe Activities
                case 11:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': '',
                        'PageLoadDrawing': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeErection.erectionDrawingNumber,
                        'PageLoadSheet': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeErection.erectionSheetNumber,
                        'PageLoadActivityType': 'E',
                        'PageLoadActivitySubType': 'PE',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                case 22:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': '',
                        'PageLoadDrawing': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeWeld.weldDrawingNumber,
                        'PageLoadSheet': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeWeld.weldSheetNumber,
                        'PageLoadActivityType': 'C',
                        'PageLoadActivitySubType': 'W',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                case 21:
                case 24:
                case 25:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeConnection.connectionBidId,
                        'PageLoadDrawing': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeConnection.connectionDrawingNumber,
                        'PageLoadSheet': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeConnection.connectionSheetNumber,
                        'PageLoadActivityType': 'C',
                        'PageLoadActivitySubType': '',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                case 41:
                case 42:
                case 43:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': '',
                        'PageLoadDrawing': '',
                        'PageLoadSheet': '',
                        'PageLoadActivityType': '',
                        'PageLoadActivitySubType': '',
                        'PageLoadTestPackage': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeTesting.testingTestPackageNumber,
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                case 23:
                case 31:
                case 32:
                case 33:
                case 38:
                case 39:
                case 51:
                case 52:
                case 53:
                case 90:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeFa.fabidId,
                        'PageLoadDrawing': '',
                        'PageLoadSheet': '',
                        'PageLoadActivityType': '',
                        'PageLoadActivitySubType': '',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                case 91:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': '',
                        'PageLoadDrawing': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeMisc.miscDrawingNumber,
                        'PageLoadSheet': $scope.Variables.liveGetActivityDetails.dataSet.data[0].pipeMisc.miscSheetNumber,
                        'PageLoadActivityType': 'MISC',
                        'PageLoadActivitySubType': '',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicPipe.invoke();
                    break;
                    // Steel Activities (Non Piece work)
                case 66:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': '',
                        'PageLoadArea': '',
                        'PageLoadPieceMark': '',
                        'PageLoadTestPackage': $scope.Variables.liveGetActivityDetails.dataSet.data[0].steelSellPackage.sellTestPackageNumber,
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicSteel.invoke();
                    break;
                case 67:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].steelDemo.demoBidId,
                        'PageLoadArea': '',
                        'PageLoadPieceMark': '',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicSteel.invoke();
                    break;
                case 96:
                    $scope.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].steelMisc.miscBidId,
                        'PageLoadArea': '',
                        'PageLoadPieceMark': '',
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicSteel.invoke();
                    break;
                    // Civil Activities
                case 70:
                case 71:
                    $scope.Variables.navigationToClassicCivil.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].civilFa.fabidId,
                        'PageLoadTestPackage': '',
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicCivil.invoke();
                    break;
                case 72:
                    $scope.Variables.navigationToClassicCivil.setData({
                        'PageLoadBidID': '',
                        'PageLoadTestPackage': $scope.Variables.liveGetActivityDetails.dataSet.data[0].civilSellPackage.sellTestPackageNumber,
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicCivil.invoke();
                    break;
                    // Equip Activities
                case 80:
                    $scope.Variables.navigationToClassicEquip.setData({
                        'PageLoadBidID': $scope.Variables.liveGetActivityDetails.dataSet.data[0].equipFa.fabidId,
                        'PageLoadFiltered': true
                    });
                    $scope.Variables.navigationToClassicEquip.invoke();
                    break;
            }
        }

        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
            $scope.Variables.navigationToClassicPipe.setData({
                'PageLoadBidID': '',
                'PageLoadArea': $scope.Widgets.gridSuperReviewSteel.selecteditem.sortGroup1,
                'PageLoadPieceMark': $scope.Widgets.gridSuperReviewSteel.selecteditem.pieceMark,
                'PageLoadTestPackage': '',
                'PageLoadFiltered': true
            });
            $scope.Variables.navigationToClassicSteel.invoke();
        }
    };


    $scope.gridSuperReviewActivitiesSelect = function($event, $isolateScope, $rowData) {
        if ($rowData.activityId === undefined) { //Skip logic if Nothing selected.
            return;
        }
        if ($scope.Variables.staticTabSelect.dataSet.dataValue != '1') { //Skip logic if Tab Not selected.
            return;
        }

        $scope.Variables.serviceGetSubsDetails.setInput('SubmissionID', $rowData.submissionId);
        $scope.Variables.serviceGetSubsDetails.invoke();

        $scope.Variables.staticEditMode.dataSet.dataValue = false;

        // Update liveGetActivityDetails with newly selected Row
        $scope.Variables.liveGetActivityDetails.listRecords({
            filterFields: {
                "activityId": {
                    "value": $rowData.activityId
                }
            }
        });

        // Update serviceGetNotes with newly selected Row
        $scope.Variables.serviceGetSASNotes.invoke({
            "inputFields": {
                "ActivityID": $rowData.activityId
            }
        });
    };


    $scope.liveGetActivityDetailsonSuccess = function(variable, data) { //Load the correct Partial page into container based on type of item selected from Grid.
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
            case 51:
            case 52:
            case 53:
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


    $scope.gridSuperReviewSteelSelect = function($event, $isolateScope, $rowData) {

        if ($rowData.submissionId === undefined) { //Skip logic if Nothing selected.
            return;
        }
        if ($scope.Variables.staticTabSelect.dataSet.dataValue != '2') { //Skip logic if Tab Not selected.
            return;
        }

        // Update serviceGetSubsDetails with newly selected Row
        $scope.Variables.serviceGetSubsDetails.setInput('SubmissionID', $rowData.submissionId);
        $scope.Variables.serviceGetSubsDetails.invoke();

        //Cancel Edit mode if user selects different row
        if ($scope.Widgets.containerFADetails.Variables && $scope.Widgets.containerFADetails.Variables.staticEditMode && $scope.Widgets.containerFADetails.Variables.staticEditMode.dataSet.dataValue) {
            $scope.Widgets.containerFADetails.Variables.staticEditMode.setValue("dataValue", false);
            $scope.Widgets.containerFADetails.Widgets.gridSteelFA.cancelRow();
        }

        // Update serviceGetNotes with newly selected Row
        // Since this will use the results of Widgets.containterFADetails.Variables.getSteelActivitiesData.  It needs to be run via its OnSuccess event for steel
        //$scope.Variables.serviceGetSASNotes.invoke();
    };


    $scope.gridSuperReviewActivitiesDatarender = function($isolateScope, $data) {
        $timeout(function() {
            $scope.Widgets.gridSuperReviewActivities.onRowFilterChange();
        });
    };


    $scope.tabFAsSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '1');
        $scope.gridSuperReviewActivitiesSelect(null, null, $scope.Widgets.gridSuperReviewActivities.selecteditem);
    };


    $scope.tabSteelSelect = function($event, $isolateScope) {
        $scope.Variables.staticTabSelect.setValue('dataValue', '2');
        $scope.Widgets.containerFADetails.content = 'PartFASteelStandard';
        $scope.gridSuperReviewSteelSelect(null, null, $scope.Widgets.gridSuperReviewSteel.selecteditem);
    };


    $scope.serviceGetFAsSteelonSuccess = function(variable, data) {
        if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
            $scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.invoke();
        }
    };


    $scope.serviceGetSubsDetailsonSuccess = function(variable, data) {
        if (data.numberOfElements > 0 && data.content[0].signatureData) { //If there is signature data Set the signature container
            $scope.signaturePad.fromDataURL(data.content[0].signatureData);
        }
    };

}]);




Application.$controller("gridSuperReviewActivitiesController", ["$scope",
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


        $scope.buttonNoteSaveClick = function($event, $isolateScope) {
            $scope.Widgets.FormCreateSASNote.submit();
        };


        $scope.FormCreateSASNoteBeforesubmit = function($event, $isolateScope, $data) {
            if ($scope.Variables.staticTabSelect.dataSet.dataValue == '1') {
                $data.ActivityID = $scope.Widgets.gridSuperReviewActivities.selecteditem.activityId;
            } else if ($scope.Variables.staticTabSelect.dataSet.dataValue == '2') {
                // Need to figure out the logic for what "activityID" to assign the notes too in this case...
                $data.ActivityID = null;
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