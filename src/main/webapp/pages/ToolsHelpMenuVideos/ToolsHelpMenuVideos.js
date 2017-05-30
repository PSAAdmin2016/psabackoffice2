Application.$controller("ToolsHelpMenuVideosPageController", ["$scope", function($scope) {
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


    $scope.liveHelpMenuVideoCategoriesonBeforeDatasetReady = function(variable, data) {
        return _.uniqBy(data, 'id');
    };


    $scope.liveform1Beforeservicecall = function($event, $operation, $data) {
        $data.fkParentMenu = $scope.Widgets.gridCategories.selecteditem.id;
    };
}]);

Application.$controller("gridCategoriesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("gridSubCategoryController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.addNewRowAction = function($event) {
            $scope.Variables.staticUploadEnabled.dataSet.dataValue = true;
        };

        $scope.updaterowAction = function($event, $rowData) {
            $scope.Variables.staticUploadEnabled.dataSet.dataValue = true;
        };
    }
]);

Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.cancelAction = function($event) {
            $scope.Variables.staticUploadEnabled.dataSet.dataValue = false;
        };

        $scope.saveAction = function($event) {
            $scope.Variables.staticUploadEnabled.dataSet.dataValue = false;
        };

    }
]);