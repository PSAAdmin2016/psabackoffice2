Application.$controller("DashProgressJobPageController", ["$scope", function($scope) {
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


    $scope.dataTransformer = function(var1) {

        var varReturn = [];
        for (var i = 0; i < var1.length; i++) {
            if (!isNaN(var1[i].Value)) {
                varReturn.push({
                    "Label": var1[i].Label,
                    "Value": var1[i].Value
                });
            } else {
                varReturn.push({
                    "Label": var1[i].Label,
                    "Value": 0
                });

            }
        }
        return varReturn;
    };

    $scope.panel1Fullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel1.height = '95%';
    };


    $scope.panel1Exitfullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel1.height = '450px';
    };



    $scope.serviceGetDashUpdateIntervalonSuccess = function(variable, data) {
        $scope.Variables.timerUpdateStats.delay = data.content[0].Interval2;
        $scope.Variables.timerUpdateStats.fire();
    };

}]);