Application.$controller("headerMainPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
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



    $scope.selectActiveJobNumberChange = function($event, $isolateScope) {
        $scope.Variables.SchemaChangeServiceChangeSchema.setInput('newSchema', $scope.Widgets.selectActiveJobNumber.datavalue);
        $scope.Variables.SchemaChangeServiceChangeSchema.update();

    };


    $rootScope.showFAQ = function($event, $isolateScope) {
        DialogService.showDialog("iframedialogFAQ");
    };


    $rootScope.showMedia = function() {
        DialogService.showDialog("pagedialogMedia");
    };


    $scope.SchemaChangeServiceChangeSchemaonSuccess = function(variable, data) {
        try {

            console.log("Refreshing RefWeldSpecProcedures" + " :selectActiveJobNumberChange");
            $rootScope.Variables.Job1111RefWeldSpecProcedures.listRecords();

        } catch (err) {
            console.log("selectActiveJobNumberChange Error :Main.js: selectActiveJobNumberChange: " + err);
        }
    };


    $scope.newMessageCount = function(dataSet) {
        var varReturn = 0;
        var varAllowed = false;

        //Count up new messages.
        if (dataSet.content) {
            for (var i = 0; i < dataSet.content.length; i++) {
                if (!isNaN(dataSet.content[i].Status) && dataSet.content[i].Author != $scope.Variables.loggedInUser.dataSet.id) {
                    varReturn = varReturn + dataSet.content[i].Status;
                }
            }
        }

        //Check security permission.  If They can't use AllChat, Don't add +1 to Badge number
        var varAllowedRoles = ['SuperUser', 'Corp. Office-Site Admin', 'Corp. Office-Project Services', 'Site Office-Project Services A', 'Site Office-Project Services B'];
        for (var i2 = 0; i2 < $scope.Variables.loggedInUser.dataSet.roles.length; i2++) {
            for (var i3 = 0; i3 < varAllowedRoles.length; i3++) {
                if ($scope.Variables.loggedInUser.dataSet.roles[i2] == varAllowedRoles[i3]) {
                    varAllowed = true;
                }
            }

        }

        //Add +1 to account for new AllChat Messages
        if (varAllowed && $scope.Variables.serviceGetAllChatLastRead && $scope.Variables.serviceGetAllChatLatestTimestamp && $scope.Variables.serviceGetAllChatLastRead.firstRecord.timeStamp < $scope.Variables.serviceGetAllChatLatestTimestamp.firstRecord.latestTimeStamp) {
            varReturn = varReturn + 1;
        }

        // Return blank instead of 0 to make badget not show up.
        if (varReturn === 0) {
            varReturn = '';
        }

        return varReturn;
    };



}]);

Application.$controller("iframedialogFAQController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("pagedialogMediaController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialogLiveChatController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);