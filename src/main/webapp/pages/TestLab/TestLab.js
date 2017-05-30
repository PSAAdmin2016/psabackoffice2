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


}]);