Application.$controller("TestLab2PageController", ["$scope", function($scope) {
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


    $scope.button1Click = function($event, $isolateScope) {

        $scope.Variables.webServiceWeatherHistory.invoke({
                "inputFields": {
                    "yyyy": "2018",
                    "mm": "03",
                    "dd": "01",
                    "zipcode": "70460"
                }
            },
            function(data) {
                // Success Callback
                //console.log("success", data);
                alert('Your max temp for ' + data.history.date.pretty + ' is ' + data.history.dailysummary[0].maxtempi);

            },
            function(error) {
                // Error Callback
                //console.log("error", error)
                alert(error);
            });


    };


    $scope.clearButtonClick = function($event, $isolateScope) {
        $scope.Widgets.zipCodeField.datavalue = "";
        $scope.Widgets.datePicker.datavalue = "";
    };


    $scope.button2Click = function($event, $isolateScope) {

        if ($scope.Widgets.datePicker.datavalue.length > 4 && $scope.Widgets.zipCodeField.datavalue.length > 4) {
            var monDayYear = $scope.Widgets.datePicker.datavalue.split("-");
            $scope.Variables.webServiceWeatherHistory.invoke({
                    "inputFields": {
                        "yyyy": monDayYear[0],
                        "mm": monDayYear[1],
                        "dd": monDayYear[2],
                        "zipcode": $scope.Widgets.zipCodeField.datavalue
                    }
                },
                function(data) {
                    // Success Callback
                    //console.log("success", data);
                    alert('Your max temp for ' + data.history.date.pretty + ' is ' + data.history.dailysummary[0].maxtempi);

                },
                function(error) {
                    // Error Callback
                    //console.log("error", error)
                    alert(error);
                });
        }
    };


    $scope.WeatherHistoryForm1Success = function($event, $isolateScope, $data) {
        $scope.Widgets.labelWeatherHistoryTitle.content = 'Success';


    };

}]);

Application.$controller("WeatherHistoryTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);