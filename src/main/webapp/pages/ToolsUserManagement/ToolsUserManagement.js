Application.$controller("ToolsUserManagementPageController", ["$scope", function($scope) {
    "use strict";

    $scope.onPageReady = function() {

    };


    $scope.getRoleIDArray = function(data) {
        var varReturn = [];
        if (data) {
            _.forEach(data, function(value, index) {
                varReturn.push(value.roleId);
            });
        }
        return varReturn;
    };


    $scope.GeneratePassword = function() {
        try {
            var varPassword = $scope.Widgets.liveformUsers.formWidgets.firstName.datavalue.replace(/\s/g, '') + $scope.Widgets.liveformUsers.formWidgets.lastName.datavalue.charAt(0) + Math.floor(1000 + Math.random() * 9000);
            $scope.Variables.staticGenPass.setValue("dataValue", varPassword);
        } catch (err) {
            console.log("GenPass Info: No Last Name typed yet.");
        }
    };


    $scope.gridUserSelect = function($event, $isolateScope, $rowData) {
        if ($scope.Variables.staticEditMode.dataSet.dataValue) {
            $scope.Variables.staticEditMode.setValue("dataValue", false);
            $scope.Variables.notificationChangesNotSaved.invoke();
            $scope.Widgets.liveformUsers.cancel();
        }
    };


    $scope.liveformUsersBeforeservicecall = function($event, $operation, $data) {
        //Misc Logic
        $data.lastModifiedBy = $scope.Variables.loggedInUser.dataSet.id;

        //Logic to set Password
        if ($scope.Variables.staticEditMode.getValue("newUser")) {
            $data.tblUserCreds = {};
            $data.tblUserCreds.userName = $data.email;
            $data.tblUserCreds.password = $data.form_fieldPassword;
        } else if ($data.form_fieldPassword != 'encrypted...') {
            //$data.tblUserCreds.password = $data.form_fieldPassword;
        } else {
            $data.tblUserCreds = null;
        }

        //Logic to handle New user Default Job number
        if ($scope.Variables.staticEditMode.getValue("newUser")) {
            $data.tblUserJobNumberses = [];
            $data.tblUserJobNumberses[0] = {};
            $data.tblUserJobNumberses[0].fkJobNumber = $data.tblJobNumbers.jobNumber;
        }

        //Logic to set RoleID.... This may need be on success.... MAYBE...

    };


    $scope.liveformUsersSuccess = function($event, $operation, $data) {
        $scope.Variables.staticEditMode.setValue("dataValue", false);
        $scope.Variables.staticEditMode.setValue("newUser", false);
        $scope.Widgets.filterUser.filter();
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

        $scope.gridAssignedJobNumbersBeforerowinsert = function($event, $isolateScope, $rowData) {
            $rowData.fkUserId = $scope.Widgets.gridUser.selecteditem.id;
        };

        $scope.editAction = function($event) {
            $scope.Variables.staticEditMode.setValue("dataValue", true);
            $scope.Variables.staticGenPass.setValue("dataValue", 'encrypted...');
        };

        $scope.newAction = function($event) {
            $scope.Variables.staticEditMode.setValue("dataValue", true);
            $scope.Variables.staticEditMode.setValue("newUser", true);
            $scope.Variables.staticGenPass.setValue("dataValue", null);
        };

        $scope.cancelAction = function($event) {
            $scope.Variables.staticEditMode.setValue("dataValue", false);
            $scope.Variables.staticEditMode.setValue("newUser", false);
        };

        $scope.firstNameKeyup = function($event, $isolateScope) {
            if ($scope.Variables.staticEditMode.dataSet.newUser) {
                $scope.$parent.GeneratePassword();
            }
        };

        $scope.lastNameKeyup = function($event, $isolateScope) {
            if ($scope.Variables.staticEditMode.dataSet.newUser) {
                $scope.$parent.GeneratePassword();
            }
        };
    }
]);


Application.$controller("gridAssignedJobNumbersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("filterUserController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);