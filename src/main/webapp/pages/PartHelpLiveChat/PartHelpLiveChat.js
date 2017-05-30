Application.$controller("PartHelpLiveChatPageController", ["$scope", "$timeout", function($scope, $timeout) {
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


    $scope.livelistConversationsClick = function($event, $isolateScope) {
        $scope.Variables.staticActiveConversation.dataSet.dataValue = $scope.Widgets.livelistConversations.selecteditem.ConversationID;
        $scope.Variables.serviceGetChatMessages.invoke();

    };


    $scope.serviceGetChatMessagesonBeforeUpdate = function(variable, inputData) {
        inputData.ConversationID = $scope.Variables.staticActiveConversation.dataSet.dataValue;

        $timeout(function() {
            var livelistMessages = WM.element('[name="livelistMessages"]'),
                listH;
            if (livelistMessages.length) {
                listH = livelistMessages[0].scrollHeight;
                livelistMessages.scrollTop(listH);
            }
        }, 500);
    };


    $scope.buttonBackClick = function($event, $isolateScope) {
        $scope.Variables.staticShowConversations.dataSet.dataValue = true;
        $scope.Variables.staticExistingConversation.dataSet.dataValue = false;
        $scope.Variables.serviceGetChatConversations.invoke();
        $scope.Variables.serviceGetAllChatLastRead.invoke();
        $scope.Variables.serviceGetAllChatLatestTimestamp.invoke();
    };


    $scope.buttonNewConversationClick = function($event, $isolateScope) {
        $scope.Variables.staticShowConversations.dataSet.dataValue = false;
        $scope.Variables.staticExistingConversation.dataSet.dataValue = false;
    };


    $scope.searchChatUsersSelect = function($event, $isolateScope, selectedValue) {
        for (var i = 0; i < $scope.Variables.serviceGetChatConversations.dataSet.numberOfElements; i++) {
            if ($scope.Variables.serviceGetChatConversations.dataSet.content[i].RecipientUserID == selectedValue) { //Does Conversation already exists?
                $scope.Variables.staticActiveConversation.dataSet.dataValue = $scope.Variables.serviceGetChatConversations.dataSet.content[i].ConversationID;
                $scope.Variables.serviceGetChatMessages.invoke();
                $scope.Variables.staticExistingConversation.dataSet.dataValue = true;
                i = $scope.Variables.serviceGetChatConversations.dataSet.numberOfElements;
            }
        }
        if ($scope.Variables.staticExistingConversation.dataSet.dataValue) {
            $scope.Widgets.searchChatUsers.datavalue = '';
        }
        if ($scope.Variables.staticExistingConversation.dataSet.dataValue === false) {
            $scope.Variables.serviceCreateChatConversation.invoke();
            $scope.Variables.staticExistingConversation.dataSet.dataValue = true;
            $scope.Widgets.searchChatUsers.datavalue = '';
        }
    };


    $scope.serviceCreateChatConversationonBeforeUpdate = function(variable, inputData) {
        inputData.varRecipient = $scope.Widgets.searchChatUsers.datavalue;
    };


    $scope.serviceCreateChatConversationonSuccess = function(variable, data) {
        $scope.Variables.serviceGetChatMessages.invoke();
        $scope.Variables.staticActiveConversation.dataSet.dataValue = $scope.Variables.serviceCreateChatConversation.dataSet[0].ReturnConversationID;
    };


    $scope.formNewMessageSuccess = function($event, $isolateScope, $data) {
        $scope.Widgets.formNewMessage.formWidgets.Message.datavalue = '';
    };



    $scope.containerAllChatConvoClick = function($event, $isolateScope) {
        $scope.Variables.staticActiveConversation.dataSet.dataValue = 1;
        $scope.Variables.serviceGetChatMessages.invoke();
        $scope.Variables.serviceUpdateAllChatLastRead.invoke();
    };


    $scope.serviceGetChatMessagesonSuccess = function(variable, data) {
        $scope.Variables.staticShowConversations.dataSet.dataValue = false;
        $scope.Variables.staticExistingConversation.dataSet.dataValue = true;
        $scope.Variables.serviceUpdateMessageStatus.invoke();
    };

}]);