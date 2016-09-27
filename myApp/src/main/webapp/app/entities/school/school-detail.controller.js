(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('SchoolDetailController', SchoolDetailController);

    SchoolDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'School', 'Student'];

    function SchoolDetailController($scope, $rootScope, $stateParams, previousState, entity, School, Student) {
        var vm = this;

        vm.school = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myApp:schoolUpdate', function(event, result) {
            vm.school = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
