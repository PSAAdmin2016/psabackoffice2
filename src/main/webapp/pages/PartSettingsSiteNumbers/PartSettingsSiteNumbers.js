Application.$controller("PartSettingsSiteNumbersPageController", ["$scope", function($scope) {
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



    $scope.serviceCheckJobNumberonBeforeUpdate = function(variable, inputData) {
        inputData.JobNumber = $scope.Widgets.textJobNumber.datavalue;
    };


    $scope.serviceCheckJobNumberonResult = function(variable, data) {
        if (data.content[0].JobNumberCount === 0) {
            $scope.Widgets.wizardstep2.disablenext = false;
            $scope.Widgets.wizardstep3.disablenext = false;
        } else {
            $scope.Widgets.wizardstep2.disablenext = true;
            $scope.Widgets.wizardstep3.disablenext = true;
        }

    };


    $scope.serviceGetJobSiteMatchesonResult = function(variable, data) {
        if (data.content[0] && data.content[0].ID > 0) {
            $scope.Variables.liveCreateJobNumber.setInput('fkJobSiteId', data.content[0].ID);
            $scope.Variables.timerJobNumberCreateDelay.invoke();
        } else {
            $scope.Variables.liveCreateJobSites.createRecord();
        }
    };


    $scope.liveCreateJobSitesonSuccess = function(variable, data) {
        $scope.Variables.liveCreateJobNumber.setInput('fkJobSiteId', data.id);
        $scope.Variables.timerJobNumberCreateDelay.invoke();
    };




    $scope.liveCreateJobNumberonSuccess = function(variable, data) {
        $scope.Widgets.label54.show = true;
        $scope.Widgets.icon11.show = true;
        $scope.Widgets.label55.show = false;
    };


    $scope.liveCreateJobNumberonError = function(variable, data) {
        $scope.Widgets.label54.show = false;
        $scope.Widgets.icon11.show = false;
        $scope.Widgets.label55.show = true;
    };

}]);






Application.$controller("gridJobNumbersController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);



Application.$controller("dialogNewJobController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.textJobNumberKeyup = function($event, $isolateScope) {
            $scope.Variables.serviceCheckJobNumber.invoke();
        };



        $scope.dialogNewJobOpened = function($event, $isolateScope) {
            $scope.Variables.serviceCheckJobNumber.clearData(); //This is needed to prevent the JobNumber in use error from showing if user canceled while it was visible.
        };


        $scope.wizardstep4Load = function($isolateScope, stepIndex) {
            $scope.Widgets.label54.show = false;
            $scope.Widgets.icon11.show = false;
            $scope.Widgets.label55.show = false;
        };

    }
]);