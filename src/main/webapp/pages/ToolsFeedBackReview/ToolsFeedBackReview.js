Application.$controller("ToolsFeedBackReviewPageController", ["$scope", function($scope) {
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

    $scope.PSAExecuteInsertFeedbackTicketNotesonSuccess = function(variable, data) {
        $scope.Widgets.textareaNewNote.datavalue = '';
        $scope.Variables.PSAExecuteGetFBNotesByFBID.invoke();
    };


    $scope.gridFeedbackRowdblclick = function($event, $rowData) {
        WM.element($event.target).parent().find('.edit-row-button').click();
    };


}]);




Application.$controller("livefilter2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("gridFeedbackController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.updaterowAction = function($event, $rowData) {
            $scope.Variables.staticShowNotesInput.dataSet.dataValue = true;
        };

        $scope.customButtonAction = function($event) {
            $scope.Variables.staticShowNotesInput.dataSet.dataValue = true;
        };

    }
]);

Application.$controller("liveform2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.saveAction = function($event) {
            if ($scope.Widgets.textareaNewNote.datavalue !== '' && $scope.Widgets.textareaNewNote.datavalue !== null && $scope.Widgets.textareaNewNote.datavalue) {
                $scope.Variables.PSAExecuteInsertFeedbackTicketNotes.invoke();
            }
            $scope.Variables.staticShowNotesInput.dataSet.dataValue = false;
        };

        $scope.cancelAction = function($event) {
            $scope.Variables.staticShowNotesInput.dataSet.dataValue = false;
            $scope.Widgets.textareaNewNote.datavalue = '';
        };
    }
]);