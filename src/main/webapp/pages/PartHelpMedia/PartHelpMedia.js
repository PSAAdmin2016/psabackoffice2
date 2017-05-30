Application.$controller("PartHelpMediaPageController", ["$scope", function($scope) {
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


    $scope.tree1Select = function($event, $isolateScope, $item, $path) {
        $scope.Widgets.label1.caption = $item.title;
        $scope.Widgets.video1.setProperty("mp4format", "https://psa.performance-contractors.com/videos/HelpVideos/" + $item.fileName);
    };


    $scope.liveGetMenuonBeforeDatasetReady = function(variable, data) {
        return _.uniqBy(data, 'id');
    };


    $scope.liveGetSubMenuonSuccess = function(variable, data) {
        _.map(data, function(obj) {
            obj.menuHelpVideos = [obj.menuHelpVideos];
        });
    };

}]);