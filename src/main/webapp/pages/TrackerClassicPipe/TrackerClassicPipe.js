var firstLoad = false;
Application.$controller("TrackerClassicPipePageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
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


    $scope.serviceUpdateClassicTrackeronResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerPipe.filter();
        }
    };


    $scope.serviceUpdateClassicTrackerFullonSuccess = function(variable, data) {
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
            $scope.Variables.staticShowReturn.dataSet.dataValue = false;
        };

        $scope.popoverActivityHistoryHide = function($event, $isolateScope) {
            $scope.Variables.staticShowReturn.dataSet.dataValue = true;
        };

        $scope.buttonReturnClick = function($event, $isolateScope, item, currentItemWidgets) {
            $scope.Variables.liveSAS.updateRecord({
                row: {
                    "activityId": item.ActivityID,
                    "submissionId": item.SubmissionID,
                    "activityType": item.ActivityTypeID,
                    "fkBidIdassigned": $scope.Widgets.gridClassicTrackerPipe.selecteditem.bidId,
                    "fkActivityStatus": 11,
                    "fkLastModifiedBy": $scope.Variables.loggedInUser.dataSet.id
                }
            }, function(data) {
                $scope.Variables.serviceGetBidWorkHistory.invoke();
                $scope.Variables.serviceUpdateClassicTracker.invoke(); //Calls livefilterClassicTrackerEquip.filter();
            });
        };

        $scope.buttonOverrideClick = function($event, $isolateScope, item, currentItemWidgets) {
            $scope.Variables.liveSAS.listRecords({ //Called to populate form
                filterFields: {
                    "activityId": {
                        "value": $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityID
                    }
                }
            });
        };

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

        $scope.liveformSASBeforeservicecall = function($event, $operation, $data) {
            $data.fkActivityStatus = 12;
        };

        $scope.liveformSASSuccess = function($event, $operation, $data) {
            $scope.Variables.serviceGetBidWorkHistory.invoke();
            $scope.Variables.serviceUpdateClassicTracker.invoke(); //Calls livefilterClassicTrackerPipe.filter();
        };
    }
]);

Application.$controller("liveformSASFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveformPipeFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveformSASWeldController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("liveformPipeWeldController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);