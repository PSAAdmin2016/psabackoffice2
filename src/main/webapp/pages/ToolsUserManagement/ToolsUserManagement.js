Application.$controller("ToolsUserManagementPageController", ["$scope", function($scope) {
    "use strict";

    $scope.onPageReady = function() {

    };


    $scope.getRoleIDArray = function(data) {
        debugger;
        var varReturn = [];
        if (data) {
            _.forEach(data, function(value, index) {
                varReturn.push(value.roleId);
            });
        }
        return varReturn;
    };


    $scope.liveformUsersBeforeservicecall = function($event, $operation, $data) {
        //Logic to leave UserCreds alone if password wasn't reset
        if ($scope.Variables.staticResetPassword.dataSet.dataValue) {
            $data.tblUserCreds.userId = $data.id;
            $data.tblUserCreds.userName = $data.email;
            $data.tblUserCreds.password = '';
        } else if (!$scope.Variables.staticResetPassword.dataSet.dataValue) {
            $data.tblUserCreds = null;
        }

        //Logic to set RoleID

        //Logic to set 
    };


    $scope.gridUserSelect = function($event, $isolateScope, $rowData) {};


}]);




Application.$controller("gridUserController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("liveformUsersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridAssignedJobNumbersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);