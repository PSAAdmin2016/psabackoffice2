Application.$controller("TrackerClassicCivilPageController", ["$scope", function($scope) {
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
        if ($scope.Variables.staticClassicTrackerCivilColumnShowHideCache.dataSet.length > 0) {
            _.forEach($scope.Variables.staticClassicTrackerCivilColumnShowHideCache.dataSet, function(key) {
                $scope.Widgets.gridClassicTrackerCivil.columns[key].show = false; //Set show false for the columns present in variable
            });
            $scope.Widgets.gridClassicTrackerCivil.redraw();
        }

    };


    $scope.gridClassicTrackerCivilColumnselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerCivilColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 0;
            }
        });
    };


    $scope.gridClassicTrackerCivilColumndeselect = function($event, $data) {
        _.forEach($scope.Variables.staticClassicTrackerCivilColumnShowHideCache.dataSet, function(value, index) {
            if (value.label == $data.colDef.field) {
                value.show = 1;
            }
        });
    };


    $scope.timerDelayGetActivityHistoryonTimerFire = function(variable, data) {
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil FA' || $scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Pour') {
            $scope.Variables.serviceGetACHCivilFA.invoke();
        }
        if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Misc') {
            $scope.Variables.serviceGetACHCivilMisc.invoke();
        }
    };


    $scope.serviceUpdateClassicTrackeronResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerCivil.filter();
        }
    };


    $scope.serviceUpdateClassicTrackerFullonSuccess = function(variable, data) {
        if (data[0].ReturnStatus) {
            $scope.Widgets.livefilterClassicTrackerCivil.filter();
        }
    };


    $scope.livefilterClassicTrackerCivilBeforeservicecall = function($data) {
        console.log('data Keys: ' + _.keys($data.bidId));
        console.log('data Values: ' + _.values($data.bidId));
        if ($data.bidId.value === undefined) {
            console.log('Undefined.');
            return false;
        }
    };

}]);




Application.$controller("livefilterClassicTrackerCivilController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridClassicTrackerCivilController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.customButtonAction = function($event) {
            var hiddenCount = 0;
            _.forEach($scope.selectedColumns, function(value, key) {
                value.colDef.show = false;
                hiddenCount = 1;
                $scope.Variables.staticClassicTrackerCivilColumnShowHideCache.addItem(key);
            });

            if (hiddenCount > 0) {
                $scope.Variables.staticShowCivilClassicShowAllButton.dataSet.show = true;
            }
            $scope.redraw();
        };


        $scope.customButton1Action = function($event) {
            $scope.Variables.staticClassicTrackerCivilColumnShowHideCache.dataSet = [];
            _.forEach($scope.columns, function(value) { //Show all in data grid
                value.show = true;
            });

            $scope.Variables.staticShowCivilClassicShowAllButton.dataSet.show = false;
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
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil FA') {
                $scope.Variables.serviceUpdateFA.setInput('Quantity', 0);
                $scope.Variables.serviceUpdateFA.setInput('Percent', $scope.Widgets.formNewQuantity.formWidgets.selectPercentComplete.datavalue);
                $scope.Variables.serviceUpdateFA.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Pour') {
                $scope.Variables.serviceUpdateFA.setInput('Quantity', $scope.Widgets.formNewQuantity.formWidgets.textOverrideQuantity.datavalue);
                $scope.Variables.serviceUpdateFA.setInput('Percent', 0);
                $scope.Variables.serviceUpdateFA.update();
            }
            if ($scope.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Misc') {
                $scope.Variables.serviceUpdateMisc.update();
            }
        };
    }
]);