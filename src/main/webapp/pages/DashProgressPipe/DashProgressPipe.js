Application.$controller("DashProgressPipePageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        $scope.Variables.timerStatsRefresh.delay = $scope.Variables.SettingsApplication.getData().data.find(x => x.label === 'DashUpdateInt').value2;
        $scope.Variables.timerStatsRefresh.fire();
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


    $scope.panel5Fullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel5.height = '95%';
    };


    $scope.panel5Exitfullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel5.height = '450px';
    };


    $scope.panel4Fullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel4.height = '95%';
    };


    $scope.panel4Exitfullscreen = function($event, $isolateScope) {
        $scope.Widgets.panel4.height = '450px';
    };


    $scope.panelHourGroupedFullscreen = function($event, $isolateScope) {
        $scope.Widgets.panelHourGrouped.height = '95%';
    };


    $scope.panelHourGroupedExitfullscreen = function($event, $isolateScope) {
        $scope.Widgets.panelHourGrouped.height = '350px';
    };


    $scope.selectGroupChange = function($event, $isolateScope, newVal, oldVal) {
        $scope.Widgets.chartHoursGrouped.setProperty("xaxisdatakey", newVal);
    };
}]);





Application.$controller("grid2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);