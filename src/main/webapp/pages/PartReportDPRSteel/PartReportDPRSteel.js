Application.$controller("PartReportDPRSteelPageController", ["$scope", function($scope) {
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


    $scope.buttonGetReport3Click = function($event, $isolateScope) {
        if ($scope.Widgets.switchReportType3.datavalue == '1') {
            $scope.Variables.serviceGetDPR3Condensed.invoke();
        } else {
            $scope.Variables.serviceGetDPR3Detailed.invoke();
        }
    };


    $scope.buttonGetReport2Click = function($event, $isolateScope) {
        if ($scope.Widgets.switchReportType2.datavalue == '1') {
            $scope.Variables.serviceGetDPR2Condensed.invoke();
        } else {
            $scope.Variables.serviceGetDPR2Detailed.invoke();
        }
    };


    $scope.buttonGetReport1Click = function($event, $isolateScope) {
        if ($scope.Widgets.switchReportType1.datavalue == '1') {
            $scope.Variables.serviceGetDPR1Condensed.invoke();
        } else {
            $scope.Variables.serviceGetDPR1Detailed.invoke();
        }
    };


}]);


Application.$controller("grid5Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid6Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid3Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid4Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);