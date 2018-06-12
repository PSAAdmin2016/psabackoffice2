Application.$controller("PopDashPipeConnectionChartsPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {};


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
}]);