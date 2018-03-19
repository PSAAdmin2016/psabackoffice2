var firstLoad = false;
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
        //Update local PageSetting variable
        $scope.Variables.staticTrackerClassicPageSettings.setData($scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName));
        firstLoad = true;
    };


    $scope.gridClassicTrackerPipeDatarender = function($isolateScope, $data) {
        if (firstLoad) {
            firstLoad = false;
            var pageSettings = $scope.Variables.staticTrackerClassicPageSettings.dataSet.valueString;
            var pageSettingsJSON = {};

            if (pageSettings) {
                pageSettingsJSON = JSON.parse(pageSettings);

                _.forEach(pageSettingsJSON.hiddenColumns, function(key, value) {
                    $isolateScope.columns[key].setProperty('show', false);
                });

                if (pageSettingsJSON.hiddenColumns.length > 0) {
                    $scope.Variables.staticShowHideShowAllButton.setValue("show", 1);
                } else {
                    $scope.Variables.staticShowHideShowAllButton.setValue("show", 0);
                }
            }
        }
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
            //Get currently hiddenColumns arrray from local static
            var pageSettings = $scope.Variables.staticTrackerClassicPageSettings.setData($scope.Variables.SettingsPageUser.dataSet.data.find(x => x.label === 'TrackerClassicPipe'));
            var pageSettingsJSON = {};
            if (pageSettings && pageSettings.valueString) {
                pageSettingsJSON = JSON.parse(pageSettings.valueString);
            }

            //Update hiddenColumns array AND hide columns
            _.forEach($scope.selectedColumns, function(value, key) {
                if (pageSettingsJSON.hiddenColumns && pageSettingsJSON.hiddenColumns[0]) {
                    if (pageSettingsJSON.hiddenColumns.indexOf(key) == -1) {
                        pageSettingsJSON.hiddenColumns.push(key);
                        value.colDef.show = false;
                    }
                } else {
                    pageSettingsJSON.hiddenColumns = [key];
                    value.colDef.show = false;
                }
            });
            if (pageSettingsJSON.hiddenColumns.length > 0) {
                $scope.Variables.staticShowHideShowAllButton.setValue("show", 1);
            }
            $scope.redraw();

            //Update local static Settings Variable
            $scope.Variables.staticTrackerClassicPageSettings.setValue("userId", $scope.Variables.loggedInUser.dataSet.id);
            $scope.Variables.staticTrackerClassicPageSettings.setValue("label", 'TrackerClassicPipe');
            $scope.Variables.staticTrackerClassicPageSettings.setValue("valueString", JSON.stringify(pageSettingsJSON));

            //Submit new hiddenColumns for persistent storage

            if (pageSettings && pageSettings.id) {
                $scope.Variables.SettingsPageUser.updateRecord({
                    row: {
                        "id": pageSettings.id,
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": 'TrackerClassicPipe',
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                });
            } else {
                $scope.Variables.SettingsPageUser.createRecord({
                    row: {
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": 'TrackerClassicPipe',
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                });
            }
        };


        $scope.customButton1Action = function($event) { //Show All 
            //Get currently hiddenColumns array from local static
            var pageSettings = $scope.Variables.staticTrackerClassicPageSettings.setData($scope.Variables.SettingsPageUser.dataSet.data.find(x => x.label === 'TrackerClassicPipe'));
            var pageSettingsJSON = {};

            //Update hiddenColumns array AND hide columns
            pageSettingsJSON.hiddenColumns = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });
            $scope.Variables.staticShowHideShowAllButton.setValue("show", 0);
            $scope.redraw();

            //Update local Settings Variable
            $scope.Variables.staticTrackerClassicPageSettings.setValue("valueString", JSON.stringify(pageSettingsJSON));

            //Submit hiddenColumns for persistent storage
            $scope.Variables.SettingsPageUser.updateRecord({
                row: {
                    "id": pageSettings.id,
                    "userId": $scope.Variables.loggedInUser.dataSet.id,
                    "label": 'TrackerClassicPipe',
                    "valueString": JSON.stringify(pageSettingsJSON)
                }
            }, function(data) { //On Success
                $scope.Variables.SettingsPageUser.listRecords();
            });

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