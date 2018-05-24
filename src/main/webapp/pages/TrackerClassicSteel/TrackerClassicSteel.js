var firstLoad = false;
Application.$controller("TrackerClassicSteelPageController", ["$scope", "DialogService", function($scope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        //$scope.Variables.staticTrackerClassicPageSettings.setData($scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName));
        firstLoad = true;
    };


    $scope.gridClassicTrackerSteelColumnselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerSteelColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 0;
            }
        });
    };


    $scope.gridClassicTrackerSteelColumndeselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerSteelColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 1;
            }
        });
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
            var hiddenCount = 0;
            _.forEach($scope.selectedColumns, function(value, key) {
                value.colDef.show = false;
                hiddenCount = 1;
                $scope.Variables.staticClassicTrackerSteelColumnShowHideCache.addItem(key);
            });
            if (hiddenCount > 0) {
                $scope.Variables.staticShowSteelClassicShowAllButton.dataSet.show = true;
            }
            $scope.redraw();
        };

        $scope.customButton1Action = function($event) { //Show All
            $scope.Variables.staticClassicTrackerSteelColumnShowHideCache.dataSet = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });
            $scope.Variables.staticShowSteelClassicShowAllButton.dataSet.show = false;
            $scope.redraw();
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