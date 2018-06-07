Application.$controller("MainPageController", ["$scope", function($scope) {
    "use strict";

    $scope.onPageReady = function() {
        //Get App Version for display in footer
        $scope.Variables.staticProjectVersion.setValue('dataValue', _WM_APP_PROPERTIES.version);

        //Update Active JobNumber if needed
        if ($scope.Variables.ActiveJobNumber.dataSet.dataValue < 1111) {
            console.log("Updating ActiveJobNumber: Main.js: GetDefaultJobNumber: ");
            $scope.Variables.serviceGetDefaultJobNumber.update();
        } else {
            console.log("ActiveJobNumber already set. :Main.js: MainPageOnReady");
        }
    };
}]);