Application.$controller("BidEditorMechanicalPageController", ["$scope", function($scope) {
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




    $scope.buttonShowChangeLogClick = function($event, $isolateScope) {
        $scope.Variables.staticShowChangeLog.dataSet.dataValue = true;
        $scope.Widgets.gridBidEditor.setProperty('height', "550px");
        //$scope.Variables.Job1111ExecuteGetBidChangeLogByID.setInput('Id', $scope.Widgets.gridBidEditor.selecteditem.Id);

    };


    $scope.buttonHideChangeLogClick = function($event, $isolateScope) {
        $scope.Variables.staticShowChangeLog.dataSet.dataValue = false;
        $scope.Widgets.gridBidEditor.setProperty('height', "700px");
        //$scope.Variables.Job1111ExecuteGetBidChangeLogByID.setInput('Id', 0);
    };


    $scope.gridBidEditorRowdblclick = function($event, $data) {
        WM.element($event.target).parent().find('.edit-row-button').click();
    };









}]);


Application.$controller("livefilterTrackerMasterPipeController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridBidEditorController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

    }
]);

Application.$controller("gridChangeLogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);