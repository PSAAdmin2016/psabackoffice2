Application.$controller("ReviewSuperPageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
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
        if ($scope.Widgets.tabs1.activeTab.name == "tabFAs") {
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
        if ($scope.Widgets.tabs1.activeTab.name == "tabSteel") {
            //Build CheckedArray
            var checkedArray = [];
            $scope.Widgets.gridSuperReviewSteel.datagridElement.find('td .app-checkbox[name="SelectCheckbox"]').each(function(index) {
                if ($(this).isolateScope().datavalue === true) {
                    checkedArray.push($scope.Widgets.gridSuperReviewSteel.gridData[index]);
                }
            });

            if (checkedArray.length > 0) {
                // run serviceUpdateSASSteelSubBidID for every selected row and refresh GetActivitiesPendingReviewSteel 1 TIME
                for (var i = 0; i < checkedArray.length; i++) {
                    $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("CurrentStatusID", checkedArray[i].fkActivityStatus);
                    $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("BidID", checkedArray[i].fabidId);
                    $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("SubmissionID", checkedArray[i].submissionId);

                    // Conditionally set new status
                    switch (checkedArray[i].fkActivityStatus) {
                        case 1:
                        case 10:
                            $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("NewStatusID", 2);
                            break;
                        case 6:
                        case 8:
                            $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("NewStatusID", 7);
                            break;
                        case 4:
                            $scope.Variables.serviceUpdateSASSteelSubBidID.setInput("NewStatusID", 9);
                    }

                    // Only update serviceGetFAsSteel on last update.
                    if (i == checkedArray.length - 1) {
                        $scope.Variables.serviceUpdateSASSteelSubBidID.invoke({},
                            function(data) {
                                $scope.Variables.serviceGetFAsSteel.invoke();
                            });
                    } else {
                        $scope.Variables.serviceUpdateSASSteelSubBidID.invoke();
                    }
                }

            } else {
                // Get ActivityIDs to update
                for (var i2 = 0; i2 < $scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.dataSet.content.length; i2++) {
                    if (!$scope.Variables.serviceUpdateSASSteelList.dataBinding.ActivityIDs) {
                        $scope.Variables.serviceUpdateSASSteelList.setInput("ActivityIDs", []);
                    }
                    $scope.Variables.serviceUpdateSASSteelList.dataBinding.ActivityIDs.push($scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.dataSet.content[i2].activityId);
                }

                // Conditionally set new status
                switch ($scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.dataSet.content[0].fkActivityStatus) {
                    case 1:
                    case 10:
                        $scope.Variables.serviceUpdateSASSteelList.setInput("ActivityStatusID", "2");
                        break;
                    case 6:
                    case 8:
                        $scope.Variables.serviceUpdateSASSteelList.setInput("ActivityStatusID", "7");
                        break;
                    case 4:
                        $scope.Variables.serviceUpdateSASSteelList.setInput("ActivityStatusID", "9");
                }

                // Update statuses, and onSuccess, update serviceGetFAsSteel
                $scope.Variables.serviceUpdateSASSteelList.invoke({},
                    function(data) {
                        $scope.Variables.serviceGetFAsSteel.invoke();
                    });
            }
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
        if ($scope.Widgets.tabs1.activeTab.name == "tabFAs") {
            switch ($scope.Widgets.gridSuperReviewActivities.selecteditem.activityType) {
                // Pipe Activities
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
                case 11:
                case 21:
                case 23:
                case 24:
                case 25:
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

        if ($scope.Widgets.tabs1.activeTab.name == "tabSteel") {
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
        if ($scope.Widgets.tabs1.activeTab.name != "tabFAs") { //Skip logic if Tab Not selected.
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
        if ($scope.Widgets.tabs1.activeTab.name == "tabFAs") {
            switch (data[0].activityType) {
                // Pipe Activities
                case 22:
                    $scope.Widgets.containerFADetails.content = 'PartFAPipeWeld';
                    break;
                case 41:
                case 42:
                case 43:
                    $scope.Widgets.containerFADetails.content = 'PartFAPipeTesting';
                    break;
                case 11:
                case 21:
                case 23:
                case 24:
                case 25:
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
        }
    };


    $scope.gridSuperReviewSteelSelect = function($event, $isolateScope, $rowData) {

        if ($rowData.submissionId === undefined) { //Skip logic if Nothing selected.
            return;
        }
        if ($scope.Widgets.tabs1.activeTab.name != "tabSteel") { //Skip logic if Tab Not selected.
            return;
        }

        // Update serviceGetSubsDetails with newly selected Row
        $scope.Variables.serviceGetSubsDetails.setInput('SubmissionID', $rowData.submissionId);
        $scope.Variables.serviceGetSubsDetails.invoke();

        //Cancel Edit mode if user selects different row
        if ($scope.Widgets.containerFADetails.Variables && $scope.Widgets.containerFADetails.Variables.staticEditMode && $scope.Widgets.containerFADetails.Variables.staticEditMode.dataSet.dataValue) {
            $scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.setValue("dataValue", false);
            $scope.Widgets.containerFADetails.Widgets.gridSteelFA.cancelRow();
        }
    };


    $scope.gridSuperReviewActivitiesDatarender = function($isolateScope, $data) {
        $timeout(function() {
            $scope.Widgets.gridSuperReviewActivities.onRowFilterChange();
        });
    };


    $scope.tabFAsSelect = function($event, $isolateScope) {
        $scope.gridSuperReviewActivitiesSelect(null, null, $scope.Widgets.gridSuperReviewActivities.selecteditem);
        $scope.Variables.liveGetActivityDetails.clearData();
        $scope.signaturePad.clear();
    };


    $scope.tabSteelSelect = function($event, $isolateScope) {
        $scope.Widgets.containerFADetails.content = 'PartFASteelStandard';
        $scope.gridSuperReviewSteelSelect(null, null, $scope.Widgets.gridSuperReviewSteel.selecteditem);
        $scope.Variables.serviceGetSubsDetails.clearData();
        $scope.signaturePad.clear();
    };


    $scope.serviceGetSubsDetailsonSuccess = function(variable, data) {
        if (data.numberOfElements > 0 && data.content[0].signatureData) { //If there is signature data Set the signature container
            $scope.signaturePad.fromDataURL(data.content[0].signatureData);
        }
    };


    $scope.serviceCreateSASNoteonSuccess = function(variable, data) {
        $scope.Variables.serviceGetSASNotes.invoke({
            "inputFields": {
                "ActivityID": $scope.Widgets.gridSuperReviewActivities.selecteditem.activityId
            }
        });
    };


    $scope.serviceGetFAsSteelonSuccess = function(variable, data) {
        if (data.content.length < 1 && $scope.Widgets.tabs1.activeTab.name == "tabSteel") {
            $scope.Widgets.containerFADetails.Variables.serviceGetSteelFAData.clearData();
            $scope.Variables.serviceGetSubsDetails.clearData();
            $scope.signaturePad.clear();
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


        $scope.buttonNoteSaveClick = function($event, $isolateScope) {
            $scope.Widgets.FormCreateSASNote.submit();
        };


        $scope.FormCreateSASNoteBeforesubmit = function($event, $isolateScope, $data) {
            if ($scope.Widgets.tabs1.activeTab.name == "tabFAs") {
                $data.ActivityID = $scope.Widgets.gridSuperReviewActivities.selecteditem.activityId;
            } else if ($scope.Widgets.tabs1.activeTab.name == "tabSteel") {
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