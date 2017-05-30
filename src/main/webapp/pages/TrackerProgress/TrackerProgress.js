Application.$controller("TrackerProgressPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */
    };

    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
         */



    };



}]);


Application.$controller("gridSteelController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.GetPercent = function(earned, total) {
            var percentComplete = earned / total;
            if (!isNaN(percentComplete)) {
                return (percentComplete * 100).toFixed(3) + '%';
            } else {
                return '0.000%';
            }
        };
    }

]);

Application.$controller("gridPipeController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.GetPercent = function(earned, total) {
            var percentComplete = earned / total;
            if (!isNaN(percentComplete)) {
                return (percentComplete * 100).toFixed(3) + '%';
            } else {
                return '0.000%';
            }
        };
    }
]);

Application.$controller("gridCivilController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.GetPercent = function(earned, total) {
            var percentComplete = earned / total;
            if (!isNaN(percentComplete)) {
                return (percentComplete * 100).toFixed(3) + '%';
            } else {
                return '0.000%';
            }
        };
    }
]);

Application.$controller("gridEquipController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);