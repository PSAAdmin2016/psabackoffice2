Application.$controller("ToolsUserManagementPageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $scope.replaceFields = function(userName, password, body) {
        if (body !== undefined && body !== null && body !== '') {
            var varReturn = body.replace('{{USERNAME}}', userName);
            varReturn = varReturn.replace('{{PASSWORD}}', password);
            return varReturn;
        }
    };


    $scope.gridPSAUsersSelect = function($event, $data) {
        //Force Set Check boxes... Needed because they will not update visually, if supplied value is the same as old value.
        $scope.Widgets.formPSAUsers.formWidgets.checkboxActiveUser.datavalue = $data.Active;
        $scope.Variables.staticSelectedValuesCheckbox.dataSet.dataValue = '';
        if (!$scope.Variables.ModifyDisabled.dataSet.dataValue) {
            $scope.buttonCancelClick();
        }

    };


    $scope.buttonModifyClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = Math.floor(1000 + Math.random() * 9000);
        $scope.Variables.ModifyDisabled.dataSet.dataValue = false;
        $scope.Variables.newUserForm.dataSet.dataValue = 0;
        $scope.Variables.staticMobileUserCreateType.dataSet.dataValue = "2";
    };


    $scope.buttonNewClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = Math.floor(1000 + Math.random() * 9000);
        $scope.Variables.ModifyDisabled.dataSet.dataValue = false;
        $scope.Variables.newUserForm.dataSet.dataValue = 1;
        $scope.Widgets.formPSAUsers.resetForm();
        $scope.Widgets.checkboxActiveUser.datavalue = 0;
        $scope.Variables.staticShowTextPass.dataSet.dataValue = true;
    };


    $scope.buttonCancelClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = 0;
        $scope.Variables.ModifyDisabled.dataSet.dataValue = true;
        $scope.Variables.newUserForm.dataSet.dataValue = 0;
        $scope.Variables.staticShowTextPass.dataSet.dataValue = false; //Re Hide password text
        $scope.Variables.staticShowAddJobNumber.dataSet.dataValue = false; // Hide Add Assigned Job Numbers
        $timeout($scope.Widgets.formPSAUsers.formWidgets.checkboxActiveUser.datavalue = $scope.Widgets.gridPSAUsers.selecteditem.Active); //Revert Checkbox to Grid Value (incase it changed)

    };


    $scope.formPSAUsersSubmit = function($event, $isolateScope, $formData) {
        $scope.Variables.staticShowTextPass.dataSet.dataValue = false; //Re Hide password text

        if ($scope.Variables.ModifyDisabled.dataSet.dataValue === false && $scope.Variables.newUserForm.dataSet.dataValue === 0) { //Modify Button Was Pressed
            console.log("Modify Button was pressed");
            $scope.Variables.ModifyDisabled.dataSet.dataValue = true;
            $scope.Variables.newUserForm.dataSet.dataValue = 0;

            //Was Reset Password Pressed?
            if ($scope.Variables.staticResetPasswordPressed.dataSet.dataValue === true) { //YES - Reset Pressed
                $scope.Variables.serviceUpdateUserCreds.invoke(); // serviceupdateUserCreds is bound in GUI to Grid userID and textEmail/textPassword. 
                $scope.Variables.staticResetPasswordPressed.dataSet.dataValue = false; //Clean up
            } //Else update user data and just UserName column of tblUserCreds
            $scope.Variables.PSAExecuteUpdateUserPSA.invoke();
            $scope.Variables.serviceUpdateUserCredsUsername.invoke();

        } else if ($scope.Variables.ModifyDisabled.dataSet.dataValue === false && $scope.Variables.newUserForm.dataSet.dataValue === 1) { // New Button Was Pressed
            console.log("New Button was pressed");
            $scope.Variables.ModifyDisabled.dataSet.dataValue = true;
            $scope.Variables.newUserForm.dataSet.dataValue = 0;
            $scope.Variables.liveInsertUserPSA.createRecord();
            $scope.Variables.serviceEmailInvite.invoke(); //Send Email 
        }
    };


    $scope.textFirstNameKeyup = function($event, $isolateScope) {
        $scope.Variables.staticGenPass.dataSet.dataValue = $scope.Widgets.textFirstName.datavalue.replace(/\s/g, '') + $scope.Widgets.textLastName.datavalue.charAt(0) + $scope.Variables.staticPIN.dataSet.dataValue;
    };


    $scope.textLastNameKeyup = function($event, $isolateScope) {
        $scope.Variables.staticGenPass.dataSet.dataValue = $scope.Widgets.textFirstName.datavalue.replace(/\s/g, '') + $scope.Widgets.textLastName.datavalue.charAt(0) + $scope.Variables.staticPIN.dataSet.dataValue;
    };


    $scope.buttonResetPasswordClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = Math.floor(1000 + Math.random() * 9000);
        $scope.Variables.staticGenPass.dataSet.dataValue = $scope.Widgets.textFirstName.datavalue.replace(/\s/g, '') + $scope.Widgets.textLastName.datavalue.charAt(0) + $scope.Variables.staticPIN.dataSet.dataValue;
        $scope.Variables.staticShowTextPass.dataSet.dataValue = true;
        $scope.Variables.staticResetPasswordPressed.dataSet.dataValue = true;
    };


    $scope.buttonAddUserJobNumberClick = function($event, $isolateScope) {
        $scope.Variables.staticShowAddJobNumber.dataSet.dataValue = true;
    };


    $scope.buttonRemoveUserJobNumberClick = function($event, $isolateScope) {
        $scope.Variables.timerRemoveDelay.fire(); // Runs PSAExecuteDeleteAssignedJobNumber.update() after 70ms
    };


    $scope.buttonUserJobNumbersUpdateClick = function($event, $isolateScope) {
        $scope.Variables.PSAExecuteInsertAssignedJobNumber.invoke();
        $scope.Variables.staticShowAddJobNumber.dataSet.dataValue = false;
    };


    $scope.selectPSARoleChange = function($event, $isolateScope, newVal, oldVal) {
        if ($scope.Widgets.selectPSARole.datavalue == 3 || $scope.Widgets.selectPSARole.datavalue == 9 || $scope.Widgets.selectPSARole.datavalue == 15 || $scope.Widgets.selectPSARole.datavalue == 21 || $scope.Widgets.selectPSARole.datavalue == 4 || $scope.Widgets.selectPSARole.datavalue == 10 || $scope.Widgets.selectPSARole.datavalue == 16 || $scope.Widgets.selectPSARole.datavalue == 22) {
            $scope.Widgets.checkboxMobileUser.datavalue = '0';
        }
    };


    $scope.liveInsertUserPSAonResult = function(variable, data) {
        //Insert User Credentials into tblUserCreds under newly created UserID.
        $scope.Variables.serviceInsertUserCreds.setInput({
            "UserID": data.id,
            "UserName": data.email,
            "Password": $scope.Widgets.formPSAUsers.formWidgets.textPassword.datavalue
        });
        $scope.Variables.serviceInsertUserCreds.invoke();

        //Insert Default JobNumber into tblUserJobNumbers under newly created userID
        $scope.Variables.serviceInsertFirstAssignedJobNumber.setInput({
            "UserId": data.id,
            "JobNumber": $scope.Widgets.formPSAUsers.formWidgets.selectDefaultJobNumber.datavalue
        });
        $scope.Variables.serviceInsertFirstAssignedJobNumber.invoke();
    };


    $scope.checkboxActiveUserChange = function($event, $isolateScope, newVal, oldVal) {
        //On Activating a previously active account, Null is a valid password.. that will keep the Old password the user had before deactivation.. If they remember it.
        if ($scope.Variables.ModifyDisabled.dataSet.dataValue === true && $scope.Variables.newUserForm.dataSet.dataValue === 0) //New User not pressed
        {
            $scope.Variables.staticGenPass.dataSet.dataValue = null;
        }

    };

}]);




Application.$controller("gridPSAUsersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveformUserController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);