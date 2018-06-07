var firstLoad = false; //Set globally so all functions can access it on this page.
Application.$controller("TrackerClassicSteelPageController", ["$scope", "DialogService", function($scope, DialogService) {
    "use strict";

    $scope.onPageReady = function() {
        firstLoad = true;
        /*Fetch Page Settings JSON data from Application Settings Variable for easier access on this page.*/
        $scope.Variables.staticTrackerClassicPageSettings.setData($scope.Variables.SettingsUser.getData().data.find(x => x.label === $scope.activePageName));
    };


    $scope.gridClassicTrackerSteelBeforedatarender = function($isolateScope, $data, $columns) {
        if (firstLoad) {
            firstLoad = false;

            if ($scope.Variables.staticTrackerClassicPageSettings.dataSet.valueString) { //If page settings already exist
                var pageSettingsJSON = JSON.parse($scope.Variables.staticTrackerClassicPageSettings.dataSet.valueString);

                _.forEach(pageSettingsJSON.hiddenColumns, function(key, value) { //iterate hidden columns array and Set Show property
                    $isolateScope.columns[key].setProperty('show', false);
                });

                if (pageSettingsJSON.hiddenColumns.length > 0) { //Show "Show All Button" if hiddenColumns exist
                    $scope.Variables.staticDisplayShowAllButton.setValue("dataValue", true);
                } else {
                    $scope.Variables.staticDisplayShowAllButton.setValue("dataValue", false);
                }
            }
        }
    };


    $scope.dialogOverrideOpen = function(inItem) {
        $scope.inItem = inItem;
        DialogService.open('dialogQuantityOverride', $scope);
    };


    $scope.dialogActivityHistoryOpen = function(inItem) {
        $scope.inItem = inItem;
        DialogService.open('dialogActivityHistory', $scope);

    };


    $scope.serviceUpdateClassicTrackeronResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerSteel.filter();
        }
    };


    $scope.serviceUpdateClassicTrackerFullonSuccess = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerSteel.filter();
        }
    };
}]);




Application.$controller("livefilterClassicTrackerSteelController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;


    }
]);


Application.$controller("gridClassicTrackerSteelController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.inchToFeet = function(inches) {
            var feet = Math.floor(inches / 12);
            var remInches = inches % 12;
            return feet + "' " + remInches.toFixed(2) + '" ';
        };

        $scope.customButtonAction = function($event) { //Hide selected Columns
            //Get currently JSON data from local static
            var pageSettings = $scope.Variables.staticTrackerClassicPageSettings.dataSet;
            var pageSettingsJSON = {};
            if (pageSettings && pageSettings.valueString) {
                pageSettingsJSON = JSON.parse(pageSettings.valueString);
            }

            //Update hiddenColumns array in JSON object AND hide columns
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
                $scope.Variables.staticDisplayShowAllButton.setValue("dataValue", true);
            }
            $scope.redraw();

            //Update local static Settings Variable
            $scope.Variables.staticTrackerClassicPageSettings.setValue("userId", $scope.Variables.loggedInUser.dataSet.id);
            $scope.Variables.staticTrackerClassicPageSettings.setValue("label", $scope.$parent.activePageName);
            $scope.Variables.staticTrackerClassicPageSettings.setValue("valueString", JSON.stringify(pageSettingsJSON));

            //Update or Create Persistent Settings Variable
            if (pageSettings && pageSettings.id) {
                $scope.Variables.SettingsUser.updateRecord({
                    row: {
                        "id": pageSettings.id,
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": $scope.$parent.activePageName,
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                });
            } else {
                $scope.Variables.SettingsUser.createRecord({
                    row: {
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": $scope.$parent.activePageName,
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                }, function(data) {
                    $scope.Variables.SettingsUser.listRecords();
                });
            }
        };

        $scope.customButton1Action = function($event) { //Show All 
            //Get currently JSON data from local static
            var pageSettings = $scope.Variables.staticTrackerClassicPageSettings.dataSet;
            var pageSettingsJSON = {};

            //Update hiddenColumns array AND hide columns
            pageSettingsJSON.hiddenColumns = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });
            $scope.Variables.staticDisplayShowAllButton.setValue("dataValue", false);
            $scope.redraw();

            //Update local static Settings Variable
            $scope.Variables.staticTrackerClassicPageSettings.setValue("valueString", JSON.stringify(pageSettingsJSON));

            //Update Persistent Settings Variable
            $scope.Variables.SettingsUser.updateRecord({
                row: {
                    "id": pageSettings.id,
                    "userId": $scope.Variables.loggedInUser.dataSet.id,
                    "label": $scope.$parent.activePageName,
                    "valueString": JSON.stringify(pageSettingsJSON)
                }
            }, function(data) { //On Success
                $scope.Variables.SettingsUser.listRecords();
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
    }
]);


Application.$controller("dialogQuantityOverrideController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.dialogQuantityOverrideOpened = function($event, $isolateScope) {
            //Runing here instead of override button click because Steel WorkHistoryExpand is in different scope.. this is simpler
            $scope.Variables.liveSAS.listRecords({ //Called to populate form.  
                filterFields: {
                    "activityId": {
                        "value": $scope.inItem.ActivityID
                    }
                }
            });
        };

        $scope.liveformSASUpdateBeforeservicecall = function($event, $operation, $data) {
            switch ($scope.inItem.ActivityTypeID) {
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 68:
                    $data.fkActivityStatus = 12;
                    break;
                case 67:
                    $data.steelDemo.demoPercentCompleted = $data.steelFa.fapercentCompleted;
                    $data.fkActivityStatus = 12;
                    $data.steelFa = null;
                    break;
                case 96:
                    $data.steelMisc.miscPercentCompleted = $data.steelFa.fapercentCompleted;
                    $data.fkActivityStatus = 12;
                    $data.steelFa = null;
                    break;
            }
        };

        $scope.liveformSASUpdateSuccess = function($event, $operation, $data) {
            $scope.Variables.serviceGetBidWorkHistory.invoke();
            $scope.Variables.serviceUpdateClassicTracker.invoke(); //Calls livefilterClassicTrackerSteel.filter();
        };

    }
]);


Application.$controller("dialogManualEntryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogActivityHistoryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;


        $scope.dialogActivityHistoryOpened = function($event, $isolateScope) {
            debugger;
            $scope.Widgets.dialogActivityHistory.pageParams
        };

    }
]);



Application.$controller("liveformSASUpdateController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveformSteelFAUpdateController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);