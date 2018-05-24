Application.$controller("ActivityHistorySteelPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {};


    $scope.tabpane2Select = function($event, $isolateScope) {
        $scope.Variables.serviceGetActivityStatusHistory.invoke({
            "inputFields": {
                "ActivityID": $scope.inItem.ActivityID
            }
        });
    };


    $scope.tabpane1Select = function($event, $isolateScope) {
        switch ($scope.inItem.ActivityTypeID) {
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 68:
                $scope.Variables.serviceGetACHSteelFA.invoke({
                    "inputFields": {
                        "ActivityID": $scope.inItem.ActivityID
                    }
                }); // MAKEonSuccess Updates GetBidWorkHistory & closes Dialog.
                break;
            case 67:
                $scope.Variables.serviceGetACHSteelDemo.invoke({
                    "inputFields": {
                        "ActivityID": $scope.inItem.ActivityID
                    }
                }); // MAKEonSuccess Updates GetBidWorkHistory & closes Dialog.
                break;
            case 96:
                $scope.Variables.serviceGetACHSteelMisc.invoke({
                    "inputFields": {
                        "ActivityID": $scope.inItem.ActivityID
                    }
                }); // MAKEonSuccess Updates GetBidWorkHistory & closes Dialog.
                break;
        }
    };
}]);




Application.$controller("gridFAController", ["$scope",
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