(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('PreferredContactDetailController', PreferredContactDetailController);

    PreferredContactDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PreferredContact', 'Student'];

    function PreferredContactDetailController($scope, $rootScope, $stateParams, previousState, entity, PreferredContact, Student) {
        var vm = this;

        vm.preferredContact = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myApp:preferredContactUpdate', function(event, result) {
            vm.preferredContact = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
