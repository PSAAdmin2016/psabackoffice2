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
        //Get currently items.  Needed for pageSettings.id
        var pageSettings = $scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName);
        var pageSettingsJSON = {};

        //Update/Build pageSettingsJSON
        pageSettingsJSON.selectedActivityIndex = $scope.Widgets.gridApprovalReview.gridData.findIndex(x => x.ActivityID === $scope.Widgets.gridApprovalReview.selectedItems[0].ActivityID);
        pageSettingsJSON.selectedActivityID = $scope.Widgets.gridApprovalReview.gridData.find(x => x.ActivityID === $scope.Widgets.gridApprovalReview.selectedItems[0].ActivityID).ActivityID;
        pageSettingsJSON.selectedColumnFilters = $scope.Widgets.gridApprovalReview.rowFilter;
        debugger;
        //Submit items to DB
        if (pageSettings && pageSettings.id) {
            $scope.Variables.SettingsPageUser.updateRecord({
                row: {
                    "id": pageSettings.id,
                    "userId": $scope.Variables.loggedInUser.dataSet.id,
                    "label": $scope.activePageName,
                    "valueString": JSON.stringify(pageSettingsJSON)
                }
            });
        } else {
            $scope.Variables.SettingsPageUser.createRecord({
                row: {
                    "userId": $scope.Variables.loggedInUser.dataSet.id,
                    "label": $scope.activePageName,
                    "valueString": JSON.stringify(pageSettingsJSON)
                }
            });
        }
    };


    $scope.timerSavePageSettingsonTimerFire = function(variable, data) {
        $scope.savePageSettings();
    };


    $scope.gridApprovalReviewSelect = function($event, $data) {
        if ($scope.Widgets.gridApprovalReview.selecteditem.Craft == 'PIPE') { //Load correct partial based on selected activity
            $scope.Widgets.containerActivityMatches.content = 'PartPSRPipe';
            $timeout(function() {
                invokePartialFn('gridApprovalReviewSelectPipe');
            });
        }
        if ($scope.Widgets.gridApprovalReview.selecteditem.Craft == 'STEEL') {
            $scope.Widgets.containerActivityMatches.content = 'PartPSRSteel';
            $timeout(function() {
                invokePartialFn('gridApprovalReviewSelectSteel');
            });
        }
        if ($scope.Widgets.gridApprovalReview.selecteditem.Craft == 'CIVIL') {
            $scope.Widgets.containerActivityMatches.content = 'PartPSRCivil';
            $timeout(function() {
                invokePartialFn('gridApprovalReviewSelectCivil');
            });
        }
        if ($scope.Widgets.gridApprovalReview.selecteditem.Craft == 'EQUIP') {
            $scope.Widgets.containerActivityMatches.content = 'PartPSREquip';
            $timeout(function() {
                invokePartialFn('gridApprovalReviewSelectEquip');
            });
        }
    };


    $scope.buttonRefreshClick = function($event, $isolateScope) {
        $scope.Variables.serviceGetActivitiesPendingApproval.invoke();
    };


    $scope.gridApprovalReviewDatarender = function($isolateScope, $data) {
        var pageSettings = $scope.Variables.SettingsPageUser.getData().data.find(x => x.label === $scope.activePageName);
        var pageSettingsJSON = {};
        if (firstLoad) {
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
                    if (i) {
                        $isolateScope.selectItem(i);
                        $('[name="gridApprovalReview"] tr.app-datagrid-row.active').focus();
                    } else {
                        $isolateScope.selectItem(Math.min((pageSettingsJSON.selectedActivityIndex - 1), 0));
                        $('[name="gridApprovalReview"] tr.app-datagrid-row.active').focus();
                    }
                } else {
                    $isolateScope.selectItem(0);
                    $('[name="gridApprovalReview"] tr.app-datagrid-row.active').focus();
                }
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
        /*
        if ($rootScope.gridApprovalReviewDeselectEquip()) {
            $rootScope.gridApprovalReviewDeselectEquip();
        }
*/
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

        $scope.textareaSSNoteNewKeyup = function($event, $isolateScope) {
            if ((Date.now() - $scope.Variables.staticVariableMachineStateTimer.dataValue) > 300) {
                $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();
                $scope.Widgets.labelTextCountNewNote.caption = 252 - $scope.Widgets.textareaSSNoteNew.datavalue.length;
            }
        };
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
    }
]);