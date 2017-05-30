Application.$controller("TrackerClassicSteelPageController", ["$scope", "DialogService", function($scope, DialogService) {
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
        if ($scope.Variables.staticClassicTrackerSteelColumnShowHideCache.dataSet.length) {
            _.forEach($scope.Variables.staticClassicTrackerSteelColumnShowHideCache.dataSet, function(key) {
                $scope.Widgets.gridClassicTrackerSteel.columns[key].show = false; //Set show false for the columns present in variable
            });
            $scope.Widgets.gridClassicTrackerSteel.redraw();
        }

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
        DialogService.open('dialogQuantityOverride', $scope);
        $scope.inItem = inItem;
    };


    $scope.dialogActivityHistoryOpen = function(inItem) {
        DialogService.open('dialogActivityHistory', $scope);
        $scope.inItem = inItem;

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

        $scope.formNewQuantitySubmit = function($event, $isolateScope, $formData) {

            $scope.Variables.serviceUpdateSSOverride.update(); // changes status to Override Quantity  No test for success.
            if ($scope.inItem.ActivityTypeName == 'Shake-out') {
                $scope.Variables.serviceUpdateShake.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Erection') {
                $scope.Variables.serviceUpdateErect.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Bolt-out') {
                $scope.Variables.serviceUpdateBoltout.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Impact') {
                $scope.Variables.serviceUpdateImp.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Weld') {
                $scope.Variables.serviceUpdateWeld.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Sell/Punch') {
                $scope.Variables.serviceUpdateSell.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Demo') {
                $scope.Variables.serviceUpdateDemo.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
            if ($scope.inItem.ActivityTypeName == 'Misc') {
                $scope.Variables.serviceUpdateMisc.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
            }
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