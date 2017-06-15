Application.$controller("ActivityHistoryPageController", ["$scope", function($scope) {
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


    };


    $scope.tabheader1Select = function($event, $isolateScope) {
        $scope.Widgets.gridErectionChangeLog.show = false;
        $scope.Widgets.gridBoltUpChangeLog.show = false;
        $scope.Widgets.gridWeldChangeLog.show = false;
        $scope.Widgets.gridCutChangeLog.show = false;
        $scope.Widgets.gridTrimChangeLog.show = false;
        $scope.Widgets.gridSupportChangeLog.show = false;
        $scope.Widgets.gridDemoChangeLog.show = false;
        $scope.Widgets.gridTestingChangeLog.show = false;
        $scope.Widgets.gridMiscChangeLog.show = false;
        $scope.Widgets.gridCivilFAChangeLog.show = false;
        $scope.Widgets.gridCivilMiscChangeLog.show = false;
        $scope.Widgets.gridEquipFAChangeLog.show = false;


        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Erection') {
            $scope.Widgets.gridErectionChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'BoltUp') {
            $scope.Widgets.gridBoltUpChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Weld') {
            $scope.Widgets.gridWeldChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Cut/Prep') {
            $scope.Widgets.gridCutChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Trim Basic' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Valve' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Plug' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Wall Penetration' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Drain/Vent' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Other') {
            $scope.Widgets.gridTrimChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Supports') {
            $scope.Widgets.gridSupportChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Removal' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - UnBolt' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Pipe Cut' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Demo - Misc') {
            $scope.Widgets.gridDemoChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Ready for Testing' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Hydro' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Client Turnover') {
            $scope.Widgets.gridTestingChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Misc Basic' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Pipe Misc') {
            $scope.Widgets.gridMiscChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil FA' || $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Pour') {
            $scope.Widgets.gridCivilFAChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityType == 'Civil Misc') {
            $scope.Widgets.gridCivilMiscChangeLog.show = true;
        }
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.activityType == 'Equip FA') {
            $scope.Widgets.gridEquipFAChangeLog.show = true;
        }
    };



    $scope.tabpane2Select = function($event, $isolateScope) {
        if ($scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.activityType == 'Equip FA') {
            $scope.Variables.GetActivityStatusHistory.setInput("ActivityID", $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityID);
            $scope.Variables.GetActivityStatusHistory.invoke();
        } else {
            $scope.Variables.GetActivityStatusHistory.setInput("ActivityID", $scope.$parent.$parent.$parent.$parent.Widgets.livelistBidWorkHistory.selecteditem.ActivityID);
            $scope.Variables.GetActivityStatusHistory.invoke();
        }

    };

}]);


Application.$controller("gridErectionChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridBoltUpChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridWeldChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridTrimChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridSupportChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridDemoChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridMiscChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridStatusChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridCutChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridTestingChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridCivilFAChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridCivilMiscChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridEquipFAChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);