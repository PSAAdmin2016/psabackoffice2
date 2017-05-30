Application.$controller("ToolsUserManagementPageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $scope.buildAssignedAppsIDArray = function(var1) {
        var varReturn = [];
        if (var1.data) {
            for (var i = 0; i < var1.data.length; i++) {
                if (var1.data[i].mobileAppGroupId) {
                    varReturn.push(var1.data[i].mobileAppGroupId);
                } else {
                    varReturn.push('');
                }
            }
            return varReturn;
        }
    };


    $scope.buildAssignedAppsFolderArray = function(var1, var2) {
        var varReturn = ["400b41ddb05943f48ea4a59801040e33"]; // array is initialized with the Com_RefData folder
        if (var1) {
            for (var i = 0; i < var1.length; i++) {
                if (var1[i]) {
                    if (var2.data[0].id) {
                        for (var j = 0; j < var2.data.length; j++) {
                            if (var1[i] == var2.data[j].id) {
                                varReturn.push(var2.data[j].folderId);
                            }
                        }
                    }
                } else {
                    varReturn.push('');
                }
            }
            return varReturn;
        }
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
        $scope.Widgets.formPSAUsers.formWidgets.checkboxMobileUser.datavalue = $data.MobileUser;
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
        $scope.Variables.AppenateGetUsersByEmailInvoke.setInput('Email', $scope.Widgets.gridPSAUsers.selecteditem.Email);
        $scope.Variables.AppenateGetUsersByEmailInvoke.setInput('Status', "Active");
        $scope.Variables.AppenateGetUsersByEmailInvoke.invoke();
        $scope.Variables.PSAExecutePoolLockInactiveMobile.invoke();
        /* If avaliable Locks an Account row in the inactive table, then calls PoolGetLocked to get that Appenate AccountID.
                This prevents two users from trying to build onto the same Inactive Appenate account at the same time
                Currently this Lock must be manually released via. $scope.Variables.PSAExecutePoolUNLockInactiveMobile.update() */

        //Clean up from any previous Modifies or new mobile users
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Password = null;
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.ResetPassword = false;
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Id = "";
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber";
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = null;
        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Status = null;
    };


    $scope.buttonNewClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = Math.floor(1000 + Math.random() * 9000);
        $scope.Variables.ModifyDisabled.dataSet.dataValue = false;
        $scope.Variables.newUserForm.dataSet.dataValue = 1;
        $scope.Widgets.formPSAUsers.resetForm();
        $scope.Widgets.checkboxActiveUser.datavalue = 0;
        $scope.Widgets.checkboxMobileUser.datavalue = 0;
        $scope.Variables.PSAExecutePoolLockInactiveMobile.update(); //If avaliable Locks an Account row in the inactive table, then calls PoolGetLocked to get that Appenate AccountID.
        //This prevents two users from trying to build onto the same Inactive Appenate account at the same time
        //Currently this Lock must be manually released. ($scope.Variables.PSAExecutePoolUNLockInactiveMobile.update();)
        $scope.Variables.staticShowTextPass.dataSet.dataValue = true;
    };


    $scope.buttonCancelClick = function($event, $isolateScope) {
        $scope.Variables.staticPIN.dataSet.dataValue = 0;
        $scope.Variables.ModifyDisabled.dataSet.dataValue = true;
        $scope.Variables.newUserForm.dataSet.dataValue = 0;
        $scope.Variables.PSAExecutePoolUNLockInactiveMobile.update();
        $scope.Variables.staticShowTextPass.dataSet.dataValue = false; //Re Hide password text
        $scope.Variables.staticShowAddJobNumber.dataSet.dataValue = false; // Hide Add Assigned Job Numbers
        $timeout($scope.Widgets.formPSAUsers.formWidgets.checkboxActiveUser.datavalue = $scope.Widgets.gridPSAUsers.selecteditem.Active); //Revert Checkbox to Grid Value (incase it changed)
        $timeout($scope.Widgets.formPSAUsers.formWidgets.checkboxMobileUser.datavalue = $scope.Widgets.gridPSAUsers.selecteditem.MobileUser); //Revert Checkbox to Grid Value (incase it changed)
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
                $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Password = $scope.Widgets.textPassword.datavalue; // Set Appenate Password to NewPassword
                $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.ResetPassword = true; // Impliments password change.
                $scope.Variables.staticResetPasswordPressed.dataSet.dataValue = false; //Clean up
            } //Else update user data and just UserName column of tblUserCreds
            $scope.Variables.PSAExecuteUpdateUserPSA.invoke();
            $scope.Variables.serviceUpdateUserCredsUsername.invoke();

            //Update User Assigned Apps
            for (var i = 0; i < $formData.checkBoxSetAppGroups.length; i++) { //Loop new values
                if (_.findIndex($scope.Variables.liveAssignedApps.dataSet.data, {
                        "mobileAppGroupId": $formData.checkBoxSetAppGroups[i]
                    }) == -1) { //If new value not in default value list, add it.
                    $scope.Variables.serviceInsertUserAssignedApps.setInput({
                        "UserID": $scope.Widgets.gridPSAUsers.selecteditem.ID,
                        "MobileAppGroupID": $formData.checkBoxSetAppGroups[i]
                    });
                    $scope.Variables.serviceInsertUserAssignedApps.invoke();
                }
            }

            for (var x = 0; x < $scope.Variables.liveAssignedApps.dataSet.data.length; x++) { //Loop default values
                if ($formData.checkBoxSetAppGroups.indexOf($scope.Variables.liveAssignedApps.dataSet.data[x].mobileAppGroupId) == -1) { //If default value is not in new value list, delete it.
                    $scope.Variables.serviceDeleteUserAssignedApps.setInput({
                        // UserID is set in gui.
                        "MobileAppGroupID": $scope.Variables.liveAssignedApps.dataSet.data[x].mobileAppGroupId
                    });
                    $scope.Variables.serviceDeleteUserAssignedApps.invoke();
                }
            }

            //Are they now an Active Mobile User?
            if ($scope.Widgets.checkboxActiveUser.datavalue == '1' && $scope.Widgets.checkboxMobileUser.datavalue == '1') { //YES - Active Mobile user Via BackOffice
                console.log("Active Mobile user");
                //Does Appenate user exist?
                if ($scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0] && $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id) { //YES - Appenate act. Exists
                    console.log("Appenate user already Exists, Updating");
                    $scope.Variables.PSAExecutePoolUNLockInactiveMobile.update(); //Lock no longer needed
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Id = $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id;
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber"; //Move to GUI once it is working
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = $scope.Widgets.selectDefaultJobNumber.datavalue; //Move to GUI once it is working
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Status = '';
                    $scope.Variables.AppenateUpdateUsersInvoke.update(); //Update
                } else { //NO
                    //Do I have an inactive user locked for me?
                    if ($scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0] && $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID) { //YES
                        console.log("NOT an Active Mobile user");
                        //Update Inactive Pool User
                        console.log("Inactive Account Aquired: " + $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID);
                        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Id = $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID;
                        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber"; //Move to GUI once it is working
                        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = $scope.Widgets.selectDefaultJobNumber.datavalue; //Move to GUI once it is working
                        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Status = 'Invited';
                        $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Password = $scope.Widgets.textPassword.datavalue; //Set Default Password
                        $scope.Variables.AppenateUpdateUsersInvoke.update(); //Update
                        $scope.Variables.PSAExecutePoolDeleteInactiveMobile.dataBinding.AccountID = $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID;
                        $scope.Variables.PSAExecutePoolDeleteInactiveMobile.update(); //Remove Account ID Row from Pool
                    } else { //NO - inactive user locked for assigining
                        console.log("NO Inactive Pool ");
                        $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber"; //Move to GUI once it is working
                        $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = $scope.Widgets.selectDefaultJobNumber.datavalue; //Move to GUI once it is working
                        $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Password = $scope.Widgets.textPassword.datavalue; //Set Default Password
                        console.log("New User RequestBody: " + JSON.stringify($scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody));
                        $scope.Variables.AppenateCreateUsersInvoke.update(); //No pool user avaliable, make new one.
                    }
                }
            } else { //NO - Not an active Mobile user, Inactivate as needed
                console.log("NOT an Active Mobile user, Trying to Deactivate..");
                //Does Appenate user exist?
                if ($scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0] && $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id) { //YES
                    console.log("User Exists to deactivate " + $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id);
                    $scope.Variables.PSAExecutePoolUNLockInactiveMobile.update(); // Release lock on inactive user.
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Id = $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id;
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Status = 'Inactive';
                    $scope.Variables.AppenateUpdateUsersInvoke.update(); //Update
                    if ($scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Status != 'Invited') { //Don't put Invited account into Pool.  They are not active yet
                        $scope.Variables.PSAExecutePoolInsertInactiveMobile.dataBinding.AccountID = $scope.Variables.AppenateGetUsersByEmailInvoke.dataSet.Users[0].Id;
                        $scope.Variables.PSAExecutePoolInsertInactiveMobile.update();
                    }
                } else { //NO - user doesn't exist
                    console.log("User Doesn't Exists, Nothing to Deactivate.");
                }
                //Remove all assigned Apps
                console.log("Removing Assigned Apps.");
                for (var y = 0; y < $scope.Variables.liveAssignedApps.dataSet.data.length; y++) { //Loop default values and delete entries
                    $scope.Variables.serviceDeleteUserAssignedApps.setInput({
                        // UserID is set in gui.
                        "MobileAppGroupID": $scope.Variables.liveAssignedApps.dataSet.data[y].mobileAppGroupId
                    });
                    $scope.Variables.serviceDeleteUserAssignedApps.invoke();

                }
            }
        } else if ($scope.Variables.ModifyDisabled.dataSet.dataValue === false && $scope.Variables.newUserForm.dataSet.dataValue === 1) { // New Button Was Pressed
            console.log("New Button was pressed");
            $scope.Variables.ModifyDisabled.dataSet.dataValue = true;
            $scope.Variables.newUserForm.dataSet.dataValue = 0;
            $scope.Variables.liveInsertUserPSA.createRecord();
            $scope.Variables.serviceEmailInvite.invoke(); //Send Email 

            if ($scope.Widgets.checkboxActiveUser.datavalue == '1' && $scope.Widgets.checkboxMobileUser.datavalue == '1') { //Get Mobile users only if Active & Mobile user is checked
                console.log("New Mobile User Code Run");
                //Do I have an inactive user locked for me?
                if ($scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0] && $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID) { //YES
                    //Update Inactive Pool User
                    console.log("Inactive Account Aquired: " + $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID);
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Id = $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID;
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber"; //Move to GUI once it is working
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = $scope.Widgets.selectDefaultJobNumber.datavalue; //Move to GUI once it is working
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Status = 'Invited';
                    $scope.Variables.AppenateUpdateUsersInvoke.dataBinding.RequestBody.Password = $scope.Widgets.textPassword.datavalue; //Set Default Password
                    $scope.Variables.AppenateUpdateUsersInvoke.update(); //Update
                    $scope.Variables.PSAExecutePoolDeleteInactiveMobile.dataBinding.AccountID = $scope.Variables.PSAExecutePoolGetLockedInactiveMobile.dataSet.content[0].AccountID;
                    $scope.Variables.PSAExecutePoolDeleteInactiveMobile.update(); //Remove Account ID Row from Pool
                } else { //NO
                    console.log("NO Inactive Pool ");
                    $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Metadata[0].Key = "JobNumber"; //Move to GUI once it is working
                    $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Metadata[0].Val = $scope.Widgets.selectDefaultJobNumber.datavalue; //Move to GUI once it is working
                    $scope.Variables.AppenateCreateUsersInvoke.dataBinding.RequestBody.Password = $scope.Widgets.textPassword.datavalue; //Set Default Password
                    $scope.Variables.AppenateCreateUsersInvoke.update(); //Make New Account.
                }
            }
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

        //Insert assigned apps into tblUserAssignedApps under newly created UserID.
        var CheckboxSelectArray = [];
        CheckboxSelectArray = $scope.Widgets.formPSAUsers.formWidgets.checkBoxSetAppGroups.datavalue;
        if (CheckboxSelectArray) {
            for (var i = 0; i < CheckboxSelectArray.length; i++) {
                $scope.Variables.serviceInsertUserAssignedApps.setInput({
                    "UserID": data.id,
                    "MobileAppGroupID": CheckboxSelectArray[i]
                });
                $scope.Variables.serviceInsertUserAssignedApps.invoke();
            }
        }

        //Insert Default JobNumber into tblUserJobNumbers under newly created userID
        $scope.Variables.serviceInsertFirstAssignedJobNumber.setInput({
            "UserId": data.id,
            "JobNumber": $scope.Widgets.formPSAUsers.formWidgets.selectDefaultJobNumber.datavalue
        });
        $scope.Variables.serviceInsertFirstAssignedJobNumber.invoke();
    };


    $scope.checkboxMobileUserChange = function($event, $isolateScope, newVal, oldVal) {
        //Needed to generate appropriate default password for current user, just like if Reset Password was pressed.
        $scope.Variables.staticGenPass.dataSet.dataValue = $scope.Widgets.textFirstName.datavalue.replace(/\s/g, '') + $scope.Widgets.textLastName.datavalue.charAt(0) + $scope.Variables.staticPIN.dataSet.dataValue;
    };


    $scope.checkboxActiveUserChange = function($event, $isolateScope, newVal, oldVal) {
        //On Activating a previously active account, Null is a valid password.. that will keep the Old password the user had before deactivation.. If they remember it.
        $scope.Variables.staticGenPass.dataSet.dataValue = null;
    };

}]);




Application.$controller("gridPSAUsersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);