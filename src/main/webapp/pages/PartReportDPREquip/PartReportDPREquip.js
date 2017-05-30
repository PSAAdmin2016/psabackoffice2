Application.$controller("PartReportDPREquipPageController", ["$scope", function($scope) {
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


    $scope.buttonGetReport2Click = function($event, $isolateScope) {
        //Get results for DPR By Date
        $scope.Variables.serviceGetDPRByDate2.setInput('ForemanID', "%");
        $scope.Variables.serviceGetDPRByDate2.setInput('SuperID', $scope.Widgets.selectSuperintendent1.datavalue);
        $scope.Variables.serviceGetDPRByDate2.setInput('ManagerID', "%");
        $scope.Variables.serviceGetDPRByDate2.setInput('StartDate', $scope.Widgets.dateStart2.datavalue);
        $scope.Variables.serviceGetDPRByDate2.setInput('EndDate', ($scope.Widgets.dateEnd2.datavalue));
        $scope.Variables.serviceGetDPRByDate2.invoke();
    };


    $scope.buttonGetReport3Click = function($event, $isolateScope) {
        //Get results for DPR By Date
        $scope.Variables.serviceGetDPRByDate3.setInput('ForemanID', $scope.Widgets.selectForeman.datavalue);
        $scope.Variables.serviceGetDPRByDate3.setInput('SuperID', "%");
        $scope.Variables.serviceGetDPRByDate3.setInput('ManagerID', "%");
        $scope.Variables.serviceGetDPRByDate3.setInput('StartDate', $scope.Widgets.dateStart3.datavalue);
        $scope.Variables.serviceGetDPRByDate3.setInput('EndDate', ($scope.Widgets.dateEnd3.datavalue));
        $scope.Variables.serviceGetDPRByDate3.invoke();
    };
}]);

Application.$controller("gridDPRBySuperController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("gridDPRByForemanController", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);