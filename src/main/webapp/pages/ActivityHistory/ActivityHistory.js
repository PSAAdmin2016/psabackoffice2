Application.$controller("ActivityHistoryPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        switch ($scope.pageParams.ActivityTypeID) {
            case 11:
            case 21:
            case 23:
            case 24:
            case 25:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 51:
            case 52:
            case 53:
            case 90:
                $scope.Variables.serviceGetACHPipeFA.invoke();
                break;
            case 22:
                $scope.Variables.serviceGetACHPipeWeld.invoke();
                break;
            case 41:
            case 42:
            case 43:
                $scope.Variables.serviceGetACHPipeTesting.invoke();
                break;
            case 91:
                $scope.Variables.serviceGetACHPipeMisc.invoke();
                break;
            case 70:
            case 71:
                $scope.Variables.serviceGetACHCivilFA.invoke();
                break;
            case 72:
                $scope.Variables.serviceGetACHCivilPunchSell.invoke();
                break
            case 80:
                $scope.Variables.serviceGetACHEquipFA.invoke();
                break;
        }
    };


    $scope.getShow = function(gridName) {
        switch (gridName) {
            //Pipe
            case 'gridPipeFAChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 11:
                    case 21:
                    case 23:
                    case 24:
                    case 25:
                    case 31:
                    case 32:
                    case 33:
                    case 38:
                    case 39:
                    case 51:
                    case 52:
                    case 53:
                    case 90:
                        return true;
                    default:
                        return false;
                }
            case 'gridPipeWeldChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 22:
                        return true;
                    default:
                        return false;
                }
            case 'gridPipePunchSellChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 41:
                    case 42:
                    case 43:
                        return true;
                    default:
                        return false;
                }
            case 'gridPipeMiscChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 91:
                        return true;
                    default:
                        return false;
                }
                //Civil
            case 'gridCivilFAChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 70:
                    case 71:
                        return true;
                    default:
                        return false;
                }
            case 'gridCivilPunchSellChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 72:
                        return true;
                    default:
                        return false;
                }
                //Equip
            case 'gridEquipFAChangeLog':
                switch ($scope.pageParams.ActivityTypeID) {
                    case 80:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    };
}]);




Application.$controller("gridPipeFAChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridPipeWeldChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);







Application.$controller("gridPipeMiscChangeLogController", ["$scope",
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



Application.$controller("gridPipePuchSellChangeLogController", ["$scope",
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

Application.$controller("gridCivilPuchSellChangeLogController", ["$scope",
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