Application.$controller("TrackerClassicPipePageController", ["$scope", function($scope) {
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
        if ($scope.Variables.staticClassicTrackerPipeColumnShowHideCache.dataSet.length > 0) {
            var gridScope = $scope.Widgets.gridClassicTrackerPipe; //Get the grid scope
            _.forEach($scope.Variables.staticClassicTrackerPipeColumnShowHideCache.dataSet, function(key) {
                gridScope.columns[key].show = false; //Set show false for the columns present in variable
            });
            gridScope.redraw();
        }

    };


    $scope.gridClassicTrackerPipeRowdblclick = function($event, $data) {
        WM.element($event.target).parent().find('.edit-row-button').click();
    };


    $scope.timerDelayGetActivityHistoryonTimerFire = function(variable, data) { // This timer fired in the popoverActivityHistoryShow Event
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Erection') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryErection.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'BoltUp') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryBoltup.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Weld' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Cut/Prep') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryWeld.update();
        }

        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Trim Basic' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Valve' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Plug' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Wall Penetration' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Drain/Vent' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Other') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryTrim.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Supports') {
            $scope.Variables.Job1111ExecuteGetActivityHistorySupport.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Removal' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - UnBolt' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Cut' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Misc') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryDemo.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Ready For Testing' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Hydro' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Client Turnover') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryTesting.update();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Misc Basic' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Pipe Misc') {
            $scope.Variables.Job1111ExecuteGetActivityHistoryMisc.update();
        }
    };


    $scope.gridClassicTrackerPipeColumnselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerPipeColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 0;
            }
        });
    };


    $scope.gridClassicTrackerPipeColumndeselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerPipeColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 1;
            }
        });
    };


    $scope.serviceUpdatePartClassicTrackeronResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerPipe.filter();
        }

    };


    $scope.serviceUpdateFullClassicTrackeronSuccess = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerPipe.filter();
        }
    };


}]);


Application.$controller("livefilterClassicTrackerPipeController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridClassicTrackerPipeController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customButtonAction = function($event) { //Hide selected Columns
            var hiddenCount = 0;
            _.forEach($scope.selectedColumns, function(value, key) {
                value.colDef.show = false;
                hiddenCount = 1;
                $scope.Variables.staticClassicTrackerPipeColumnShowHideCache.addItem(key);
            });

            if (hiddenCount > 0) {
                $scope.Variables.staticShowHideShowAllButton.dataSet.show = 1;
            }
            $scope.redraw();
        };

        $scope.customButton1Action = function($event) { //Show All
            $scope.Variables.staticClassicTrackerPipeColumnShowHideCache.dataSet = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });

            $scope.Variables.staticShowHideShowAllButton.dataSet.show = 0;
            $scope.redraw();
        };


    }
]);


Application.$controller("dialogBidWorkHistoryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.popoverActivityHistoryShow = function($event, $isolateScope) {
            $scope.Variables.timerDelayGetActivityHistory.fire();
            $scope.Variables.staticShowReturn.dataSet.dataValue = false;
        };


        $scope.popoverActivityHistoryHide = function($event, $isolateScope) {
            $scope.Variables.staticShowReturn.dataSet.dataValue = true;
        };

    }
]);


Application.$controller("dialogActivityHistoryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridStatusLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridErectionChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridBoltUpChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridWeldChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridTrimChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridSupportsChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridDemoChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridMiscChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogManualEntryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonManualEntrySaveClick = function($event, $isolateScope) {
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'PE') {
                $scope.Variables.Job1111ExecuteCreateManualErection.update(); //These updates refresh bid work History
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'BU') {
                $scope.Variables.Job1111ExecuteCreateManualBoltUp.update();
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'W' || ($scope.Widgets.gridClassicTrackerPipe.selecteditem.ect == 'C' && $scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'CUT')) {
                $scope.Variables.Job1111ExecuteCreateManualWeld.update();
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.ect == 'T' && ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType != 'S' || $scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType != 'MISC')) {
                $scope.Variables.Job1111ExecuteCreateManualTrim.update();
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'S') {
                $scope.Variables.Job1111ExecuteCreateManualSupports.update();
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.ect == 'D') {
                $scope.Variables.Job1111ExecuteCreateManualDemo.update();
            }
            if ($scope.Widgets.gridClassicTrackerPipe.selecteditem.pipingActivityType == 'Testing') {
                $scope.Variables.Job1111ExecuteCreateManualTesting.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Misc Basic' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Misc') {
                $scope.Variables.Job1111ExecuteCreateManualMisc.update();
            }
        };
    }
]);


Application.$controller("dialogQuantityOverrideController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formNewQuantitySubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUpdateSSOverride.update(); // changes status to Override Quantity
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Erection') {
                $scope.Variables.Job1111ExecuteUpdateErectionQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'BoltUp') {
                $scope.Variables.Job1111ExecuteUpdateBoltupQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Weld') {
                $scope.Variables.Job1111ExecuteUpdateWeldQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Cut/Prep') {
                $scope.Variables.Job1111ExecuteUpdateWeldQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Trim Basic' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Valve' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Plug' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Wall Penetration' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Drain/Vent' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Other') {
                $scope.Variables.Job1111ExecuteUpdateTrimQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Supports') {
                $scope.Variables.Job1111ExecuteUpdateSupportsQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Removal' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - UnBolt' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Cut' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Misc') {
                $scope.Variables.Job1111ExecuteUpdateDemoQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Testing') {
                $scope.Variables.Job1111ExecuteUpdateTestingQuantity.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Misc Basic' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Pipe Misc') {
                $scope.Variables.Job1111ExecuteUpdateMiscQuantity.update();
            }
        };
    }
]);