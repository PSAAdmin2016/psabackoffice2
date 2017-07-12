Application.$controller("ToolsUserManagement2PageController", ["$scope", function($scope) {
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


    $scope.liveformUsersBeforeservicecall = function($event, $operation, $data) {
        //Logic to leave UserCreds alone if password wasn't reset
        if ($scope.Variables.staticResetPassword.dataSet.dataValue) {
            $data.tblUserCreds.userId = $data.id;
            $data.tblUserCreds.userName = $data.email;
            $data.tblUserCreds.password = null;
        } else if (!$scope.Variables.staticResetPassword.dataSet.dataValue) {
            $data.tblUserCreds = null;
        }

        //Logic to set RoleID

        //Logic to set 
    };

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