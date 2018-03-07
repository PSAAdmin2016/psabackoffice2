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

}]);