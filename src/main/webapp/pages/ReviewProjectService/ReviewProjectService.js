var firstLoad = false;
Application.$controller("ReviewProjectServicePageController", ["$scope", "$rootScope", "DialogService", "Utils", "$timeout", function($scope, $rootScope, DialogService, Utils, $timeout) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */
        $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();

    };

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following scrip
         * '$scope.Widgets.username.datavalue'
         */
        firstLoad = true;
    };


    function invokePartialFn(fnName) {
        var deregisterFn = $rootScope.$watch(fnName, function(fn) {
            if (_.isFunction(fn)) {
                deregisterFn();
                Utils.triggerFn(fn);
            }
        });
    }


    $scope.savePageSettings = function() { //### Save persistent Settings ###
        // Exit if Nothing selected
        if (!$scope.Widgets.gridApprovalReview.selectedItems[0]) {
            return;
        }
        //Get current items.  Needed for pageSettings.id
        var pageSettings = $scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName);
        var pageSettingsJSON = {};

        //Update/Build pageSettingsJSON
        pageSettingsJSON.selectedActivityIndex = $scope.Widgets.gridApprovalReview.gridData.findIndex(x => x.ActivityID === $scope.Widgets.gridApprovalReview.selectedItems[0].ActivityID);
        pageSettingsJSON.selectedActivityID = $scope.Widgets.gridApprovalReview.gridData.find(x => x.ActivityID === $scope.Widgets.gridApprovalReview.selectedItems[0].ActivityID).ActivityID;
        pageSettingsJSON.selectedColumnFilters = $scope.Widgets.gridApprovalReview.rowFilter;

        //Submit items to DB
        if (pageSettings && pageSettings.id) {
            $scope.Variables.SettingsPageUser.updateRecord({
                    row: {
                        "id": pageSettings.id,
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": $scope.activePageName,
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                },
                function(data) {
                    //Oddly enought doing an updateRecord() on a live variable.. doesn't actually update the local variable too.. Even though the updateRecord() DOES in fact return the new value, a a second call is required to update the currently stored local value. 
                    //So because of that, I need to build logic in the savePageSettings() to handle updating the local variable too. This was confirmed functionality by WaveMaker 4-2-18
                    //In the mean time I will use the second call method until I resolve how I want to handle this.
                    $scope.Variables.SettingsPageUser.listRecords();
                }
            );
        } else {
            $scope.Variables.SettingsPageUser.createRecord({
                    row: {
                        "userId": $scope.Variables.loggedInUser.dataSet.id,
                        "label": $scope.activePageName,
                        "valueString": JSON.stringify(pageSettingsJSON)
                    }
                },
                function(data) {
                    $scope.Variables.SettingsPageUser.listRecords();
                }
            );
        }
    };


    $scope.timerSavePageSettingsonTimerFire = function(variable, data) { // Save user settings every 5 min
        $scope.savePageSettings();
    };


    $scope.buttonRefreshClick = function($event, $isolateScope) {
        $scope.Variables.serviceGetActivitiesPendingApproval.invoke();
    };


    $scope.gridApprovalReviewSelect = function($event, $data) {
        //Load correct partial based on selected activity
        switch ($data.Craft) {
            case 'PIPE':
                $scope.Widgets.containerActivityMatches.content = 'PartPSRPipe';
                $timeout(function() {
                    invokePartialFn('gridApprovalReviewSelectPipe');
                });
                $scope.Widgets.containerActivityMatches.pageParams.ActivityID = $data.ActivityID;
                $scope.Widgets.containerActivityMatches.pageParams.BidID = $data.BidID;
                break;
            case 'STEEL':
                $scope.Widgets.containerActivityMatches.content = 'PartPSRSteel';
                $timeout(function() {
                    invokePartialFn('gridApprovalReviewSelectSteel');
                });
                $scope.Widgets.containerActivityMatches.pageParams.ActivityID = $data.ActivityID;
                $scope.Widgets.containerActivityMatches.pageParams.BidID = $data.BidID;
                break;
            case 'CIVIL':
                $scope.Widgets.containerActivityMatches.content = 'PartPSRCivil';
                $timeout(function() {
                    invokePartialFn('gridApprovalReviewSelectCivil');
                });
                $scope.Widgets.containerActivityMatches.pageParams.ActivityID = $data.ActivityID;
                $scope.Widgets.containerActivityMatches.pageParams.BidID = $data.BidID;
                break;
            case 'EQUIP':
                $scope.Widgets.containerActivityMatches.content = 'PartPSREquip';
                $timeout(function() {
                    invokePartialFn('gridApprovalReviewSelectEquip');
                });
                $scope.Widgets.containerActivityMatches.pageParams.ActivityID = $data.ActivityID;
                $scope.Widgets.containerActivityMatches.pageParams.BidID = $data.BidID;
                break;
        }

        //Save the index and activityID for calculating selected row on grid render AFTER updates/refresh, ect...
        $scope.Variables.staticLastSelectedRow.setValue('lastActivityIndex', $scope.Widgets.gridApprovalReview.gridData.findIndex(x => x.ActivityID === $scope.Widgets.gridApprovalReview.selectedItems[0].ActivityID));
        $scope.Variables.staticLastSelectedRow.setValue('lastActivityID', $data.ActivityID);

    };


    $scope.gridApprovalReviewDatarender = function($isolateScope, $data) {

        if (firstLoad) {
            var pageSettings = $scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName);
            var pageSettingsJSON = {};
            firstLoad = false;
            if (pageSettings) {
                pageSettingsJSON = JSON.parse(pageSettings.valueString);

                //## Set Column Filters
                if (pageSettingsJSON.selectedColumnFilters) {
                    $isolateScope.rowFilter = pageSettingsJSON.selectedColumnFilters;
                }

                //### Select Row ### If ActivityID still in Table select it.. If not select Index - 1 .  Min 0.
                if (pageSettingsJSON.selectedActivityID) {
                    var i = $isolateScope.gridData.findIndex(x => x.ActivityID === pageSettingsJSON.selectedActivityID);
                    if (i >= 0) {
                        $isolateScope.selectItem(i);
                    } else {
                        $isolateScope.selectItem(Math.min((pageSettingsJSON.selectedActivityIndex), $isolateScope.gridData.length - 1));
                    }
                } else {
                    $isolateScope.selectItem(0);
                }

                $timeout(function() {
                    $('[name="gridApprovalReview"] tr.app-datagrid-row.active').focus();
                });
            }
        } else {
            var lastActivityIndex = $scope.Variables.staticLastSelectedRow.getValue('lastActivityIndex');
            var lastActivityID = $scope.Variables.staticLastSelectedRow.getValue('lastActivityID');

            if (lastActivityID > 0) {
                var i2 = $isolateScope.gridData.findIndex(x => x.ActivityID === lastActivityID);
                if (i2 >= 0) {
                    $isolateScope.selectItem(i2);
                } else {
                    $isolateScope.selectItem(Math.min((lastActivityIndex), $isolateScope.gridData.length - 1));
                }
            } else {
                $isolateScope.selectItem(0);
            }
        }

        $timeout(function() {
            $scope.Widgets.gridApprovalReview.onRowFilterChange();
        });
    };


    $scope.gridApprovalReviewDeselect = function($event, $rowData) {
        if ($rootScope.gridApprovalReviewDeselectPipe()) {
            $rootScope.gridApprovalReviewDeselectPipe();
        }
        if ($rootScope.gridApprovalReviewDeselectSteel()) {
            $rootScope.gridApprovalReviewDeselectSteel();
        }
        if ($rootScope.gridApprovalReviewDeselectCivil()) {
            $rootScope.gridApprovalReviewDeselectCivil();
        }
        if ($rootScope.gridApprovalReviewDeselectEquip()) {
            $rootScope.gridApprovalReviewDeselectEquip();
        }
    };

}]);




Application.$controller("gridApprovalReviewController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridNotesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogNotesNewPSReviewController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

    }
]);


Application.$controller("dialogNotesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("alertRecordLockedController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogRecentActivitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonReturnToListClick = function($event, $isolateScope, item, currentItemWidgets) {
            $scope.Variables.serviceUpdateSAS.setInput("ActivityID", item.ActivityID);
            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 11);
            $scope.Variables.serviceUpdateSAS.invoke({},
                function(data) {
                    $scope.Variables.serviceGetPSRecentActivities.invoke();
                }
            ); //Updates GetActivitiesPendingApproval
        };

    }
]);