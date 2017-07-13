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
            $data.tblUserCreds.password = '';
        } else if (!$scope.Variables.staticResetPassword.dataSet.dataValue) {
            $data.tblUserCreds = null;
        }

        //Logic to set RoleID

        //Logic to set 
    };


    $scope.gridUserSelect = function($event, $isolateScope, $rowData) {

        var refFilter = $scope.Variables.liveREFRolesFILTERED;
        refFilter.setFilter("roleName", $rowData.refDisciplines.discipline);
        refFilter.listRecords();

        if ($scope.Widgets.refRoles_formWidget === undefined) {
            $scope.Widgets.liveformUsers.formWidgets.refRoles.datavalue = $scope.Widgets.gridUser.selecteditem.refRoles.id;
        } else {
            $scope.Widgets.refRoles_formWidget.datavalue = $scope.Widgets.gridUser.selecteditem.refRoles.id;
        }





        /*
        debugger;
        $scope.Variables.liveREFRolesFILTERED.listRecords({
            filterFields: {
                "roleName": {
                    "value": $rowData.refDisciplines.discipline
                }
            }
        });
        */
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

        $scope.editAction = function($event) {
            //$scope.Widgets.liveformUsers.formWidgets.refRoles.datavalue = $scope.Widgets.gridUser.selecteditem.refRoles.id;
            $scope.Widgets.refRoles_formWidget.datavalue = $scope.Widgets.gridUser.selecteditem.refRoles;
        };


        $scope.refDisciplinesChange = function($event, $isolateScope, newVal, oldVal) {
            var refFilter = $scope.Variables.liveREFRolesFILTERED;
            refFilter.setFilter("roleName", newVal.discipline);
            refFilter.listRecords();
        };

    }
]);

Application.$controller("gridAssignedJobNumbersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);