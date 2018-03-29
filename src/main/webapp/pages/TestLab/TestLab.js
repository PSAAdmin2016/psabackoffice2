Application.$controller("TestLabPageController", ["$scope", function($scope) {
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


    $scope.replaceFields = function(userName, password, body) {
        if (body !== undefined && body !== null && body !== '') {

            var varReturn = body.replace('{{USERNAME}}', userName);
            varReturn = varReturn.replace('{{PASSWORD}}', password);
            return varReturn;
        }

    };



    $scope.button6Click = function($event, $isolateScope) {
        $scope.Variables.ActiveJobNumber.dataSet.dataValue = 1234;
        $scope.Variables.ActiveJobNumber.setValue("dataValue", 1234);
        $scope.Variables.serviceGetACHEquipFA.invoke();
        debugger;
    };





    $scope.button8Click = function($event, $isolateScope) {
        $scope.Variables.liveCreateFBNotes.createRecord({

        });
    };

}]);

Application.$controller("FeedBackLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("FeedBackNotesLiveForm1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);