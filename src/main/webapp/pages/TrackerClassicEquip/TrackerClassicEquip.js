Application.$controller("TrackerClassicEquipPageController", ["$scope", function($scope) {
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
        if ($scope.Variables.staticClassicTrackerEquipColumnShowHideCache.dataSet.length > 0) {
            _.forEach($scope.Variables.staticClassicTrackerEquipColumnShowHideCache.dataSet, function(key) {
                $scope.Widgets.gridClassicTrackerEquip.columns[key].show = false; //Set show false for the columns present in variable
            });
            $scope.Widgets.gridClassicTrackerEquip.redraw();
        }

    };


    $scope.gridClassicTrackerEquipColumnselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerEquipColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 0;
            }
        });
    };


    $scope.gridClassicTrackerEquipColumndeselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerEquipColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 1;
            }
        });
    };


    $scope.serviceUpdateClassicTrackeronResult = function(variable, data) {
        if (data.returnStatus) { // <- This should be able to be identical to the other ClassicTracker OnResult if statements
            $scope.Widgets.livefilterClassicTrackerEquip.filter();
        }
    };


    $scope.serviceUpdateClassicTrackerFullonSuccess = function(variable, data) {
        if (data.returnStatus) {
            $scope.Widgets.livefilterClassicTrackerEquip.filter();
        }
    };


}]);


Application.$controller("livefilterClassicTrackerEquipController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridClassicTrackerEquipController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customButtonAction = function($event) {
            var hiddenCount = 0;
            _.forEach($scope.selectedColumns, function(value, key) {
                value.colDef.show = false;
                hiddenCount = 1;
                $scope.Variables.staticClassicTrackerEquipColumnShowHideCache.addItem(key);
            });

            if (hiddenCount > 0) {
                $scope.Variables.staticShowEquipClassicShowAllButton.dataSet.show = true;
            }
            $scope.redraw();
        };


        $scope.customButton1Action = function($event) {
            $scope.Variables.staticClassicTrackerEquipColumnShowHideCache.dataSet = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });

            $scope.Variables.staticShowEquipClassicShowAllButton.dataSet.show = false;
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


Application.$controller("dialogManualEntryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

    }
]);


Application.$controller("dialogQuantityOverrideController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formNewQuantitySubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUpdateSSOverride.update(); // changes status to Override Quantity
            $scope.Variables.serviceUpdateFA.setInput('Percent', $scope.Widgets.formNewQuantity.formWidgets.selectPercentComplete.datavalue);
            $scope.Variables.serviceUpdateFA.update(); //This will call UpdateClassic on success

        };
    }
]);