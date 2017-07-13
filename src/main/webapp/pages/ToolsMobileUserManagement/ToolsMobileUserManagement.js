Application.$controller("ToolsMobileUserManagementPageController", ["$scope", function($scope) {
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


    $scope.serviceDeleteMobileUseronBeforeUpdate = function(variable, inputData) {
        if ($scope.Widgets.gridMobileUsers.selecteditem.Id == 'b4ffcdc89a90439b9912a63d0104ba97') {
            inputData.Id = '';
            console.log("User PSAADMIN can not be deleted!   Bad user!");
        }
    };

}]);




Application.$controller("dialogUpdateMobileUserController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialogDeleteConfirmController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);