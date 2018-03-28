Application.$controller("MainPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {

        if ($scope.Variables.ActiveJobNumber.dataSet.dataValue < 1111) { //Test if ActiveJobNumber is already set
            console.log("Updating ActiveJobNumber: Main.js: GetDefaultJobNumber: ");
            $scope.Variables.serviceGetDefaultJobNumber.update();
        } else {
            console.log("ActiveJobNumber already set. :Main.js: MainPageOnReady");
        }
    };


    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        $scope.Variables.staticProjectVersion.setValue('dataValue', _WM_APP_PROPERTIES.version);
    };


}]);