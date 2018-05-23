Application.$controller("TrackerClassicCivilPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
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
                    "fkBidIdassigned": $scope.Widgets.gridClassicTrackerCivil.selecteditem.bidId,
                    "fkActivityStatus": 11,
                    "fkLastModifiedBy": $scope.Variables.loggedInUser.dataSet.id
                }
            }, function(data) {
                $scope.Variables.serviceGetBidWorkHistory.invoke();
                $scope.Variables.serviceUpdateClassicTracker.invoke(); //Calls livefilterClassicTrackerCivil.filter();
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
            $scope.Variables.serviceUpdateClassicTracker.invoke(); //Calls livefilterClassicTrackerEquip.filter();
        };
    }
]);

Application.$controller("liveformSASController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveformCivilFAController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);