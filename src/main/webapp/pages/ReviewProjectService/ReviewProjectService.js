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
    };

    function invokePartialFn(fnName) {
        var deregisterFn = $rootScope.$watch(fnName, function(fn) {
            if (_.isFunction(fn)) {
                deregisterFn();
                Utils.triggerFn(fn);
            }
        });
    }



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
        $scope.Variables.ServiceGetActivitiesPendingApproval.invoke();
    };


    $scope.gridApprovalReviewDatarender = function($isolateScope, $data) {
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