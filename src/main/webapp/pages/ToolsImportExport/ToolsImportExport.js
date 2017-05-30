Application.$controller("ToolsImportExportPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $scope.tabpane1Select = function($event, $isolateScope) {
        $scope.Variables.liveGetTableChoices.setFilter("destinationLabel", 'Tracker');
        $scope.Variables.liveGetTableChoices.listRecords();
    };


    $scope.tabpane2Select = function($event, $isolateScope) {
        $scope.Variables.liveGetTableChoices.setFilter("destinationLabel", 'Spool List Pipe');
        $scope.Variables.liveGetTableChoices.listRecords();
    };


    $scope.tabpane3Select = function($event, $isolateScope) {
        $scope.Variables.liveGetTableChoices.setFilter("destinationLabel", 'QC-');
        $scope.Variables.liveGetTableChoices.listRecords();
    };


    $scope.serviceFileImportonResult = function(variable, data) {

        if (data == "1") {
            $scope.Variables.serviceCheckColumnNames.invoke();
        }
    };


    $scope.serviceCheckColumnNamesonSuccess = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.serviceCheckValidData.invoke();
        }
    };


    $scope.serviceCheckValidDataonResult = function(variable, data) {
        if (data[0].returnStatus) {
            $scope.Variables.serviceGetImportTotals.invoke();
        }
    };


    $scope.serviceLandingToTrackerPipeonResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
            if ($scope.Widgets.switchImportQuantities.datavalue == "1") {
                $scope.Variables.serviceImportQuantitiesPipe.invoke();
            }
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.serviceLandingToPipeSpoolsonResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.serviceLandingToTrackerSteelonResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
            if ($scope.Widgets.switchImportQuantities.datavalue == "1") {
                $scope.Variables.serviceImportQuantitiesSteel.invoke();
            }
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.serviceLandingToTrackerCivilonResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
            if ($scope.Widgets.switchImportQuantities.datavalue == "1") {
                $scope.Variables.serviceImportQuantitiesCivil.invoke();
            }
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.serviceLandingToTrackerEquiponResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
            if ($scope.Widgets.switchImportQuantities.datavalue == "1") {
                $scope.Variables.serviceImportQuantitiesEquip.invoke();
            }
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.serviceLandingToWeldSpecProceduresonResult = function(variable, data) {
        if (data.returnStatus) {
            $scope.Variables.notificationCommitSuccess.invoke();
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = true;
        } else {
            $scope.Variables.staticCommitSuccess.dataSet.dataValue = false;
            $scope.Widgets.textareaErrorMessageCommit.datavalue = data.returnError;
        }
    };


    $scope.FileServiceListFilesonError = function(variable, data) {
        $scope.Variables.FileServiceListFilesTrackers.dataSet = [];
    };


    $scope.FileServiceListFilesSpoolsonError = function(variable, data) {
        $scope.Variables.FileServiceListFilesSpools.dataSet = [];
    };


    $scope.FileServiceListFilesQConError = function(variable, data) {
        $scope.Variables.FileServiceListFilesQC.dataSet = [];
    };





}]);




Application.$controller("dialogImportController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.dialogImportOpened = function($event, $isolateScope) {
            $scope.Variables.serviceFileImport.dataSet = [];
            $scope.Variables.serviceCheckColumnNames.dataSet = [];
            $scope.Variables.serviceCheckValidData.dataSet = [];
            $scope.Variables.serviceGetImportTotals.dataSet = [];
        };


        $scope.wizardstep3Next = function($isolateScope, currentStep, stepIndex) {
            if ($scope.Widgets.switch1.datavalue == "new") {
                $scope.Variables.serviceFileImport.setInput("fileName", $scope.Widgets.fileuploadImport.uploadedFiles[0].fileName);
            } else {
                $scope.Variables.serviceFileImport.setInput("fileName", $scope.Widgets.gridFileListImport.selecteditem.name);
            }
            $scope.Variables.serviceFileImport.invoke();
        };


        $scope.wizardstep4Prev = function($isolateScope, currentStep, stepIndex) {
            $scope.Variables.serviceFileImport.dataSet = [];
            if ($scope.Variables.serviceCheckColumnNames.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckColumnNames.dataSet = [];
            }
            if ($scope.Variables.serviceCheckValidData.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckValidData.dataSet[0].returnStatus = undefined;
            }
            $scope.Variables.serviceGetImportTotals.dataSet[0] = undefined;
        };


        $scope.wizard1Cancel = function($isolateScope, steps) {
            $scope.Variables.serviceFileImport.dataSet = [];
            if ($scope.Variables.serviceCheckColumnNames.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckColumnNames.dataSet[0].returnStatus = undefined;
            }
            if ($scope.Variables.serviceCheckValidData.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckValidData.dataSet[0].returnStatus = undefined;
            }
            $scope.Variables.serviceGetImportTotals.dataSet[0] = undefined;
        };


        $scope.dialogImportClose = function($event, $isolateScope) {
            $scope.Variables.serviceFileImport.dataSet = [];
            if ($scope.Variables.serviceCheckColumnNames.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckColumnNames.dataSet[0].returnStatus = undefined;
            }
            if ($scope.Variables.serviceCheckValidData.dataSet[0] !== undefined) {
                $scope.Variables.serviceCheckValidData.dataSet[0].returnStatus = undefined;
            }
            $scope.Variables.serviceGetImportTotals.dataSet[0] = undefined;
        };


        $scope.wizardstep5Next = function($isolateScope, currentStep, stepIndex) {
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '1') {
                $scope.Variables.serviceLandingToTrackerPipe.invoke();
            }
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '2') {
                $scope.Variables.serviceLandingToTrackerSteel.invoke();
            }
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '3') {
                $scope.Variables.serviceLandingToTrackerCivil.invoke();
            }
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '4') {
                $scope.Variables.serviceLandingToTrackerEquip.invoke();
            }
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '5') {
                $scope.Variables.serviceLandingToPipeSpools.invoke();
            }
            if ($scope.Widgets.selectTableNameImport.datavalue.id == '6') {
                $scope.Variables.serviceLandingToWeldSpecProcedures.invoke();
            }
        };

        $scope.wizardstep6Prev = function($isolateScope, currentStep, stepIndex) {
            return false;
        };

    }
]);

Application.$controller("gridStoredFilesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridUploadedFilesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridFileListTrackersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridFileListImportController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridFileListSpoolsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridFileListQCController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);