Application.$controller("ActivityHistorySteelPageController", ["$scope", function($scope) {
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


    $scope.tabpane2Select = function($event, $isolateScope) {
        $scope.$parent.$parent.$parent.Variables.serviceGetActivityStatusHistory.invoke();
    };


    $scope.tabpane1Select = function($event, $isolateScope) {
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Shake-out') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHShake.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Erection') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHErect.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Bolt-out') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHBoltout.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Impact') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHImp.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Weld') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHWeld.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Sell/Punch') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHSell.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Demo') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHDemo.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
        if ($scope.$parent.$parent.$parent.inItem.ActivityTypeName == 'Misc') {
            $scope.$parent.$parent.$parent.Variables.serviceGetACHMisc.invoke(); //onSuccess Updates GetBidWorkHistory & closes Dialog.
        }
    };

}]);


Application.$controller("gridShakeController", ["$scope",
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

Application.$controller("gridErectController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridBoltoutController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridImpController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridWeldController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridSellController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridDemoController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridMiscController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);