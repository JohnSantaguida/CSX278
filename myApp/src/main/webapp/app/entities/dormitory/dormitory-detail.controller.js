(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('DormitoryDetailController', DormitoryDetailController);

    DormitoryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Dormitory', 'Student'];

    function DormitoryDetailController($scope, $rootScope, $stateParams, previousState, entity, Dormitory, Student) {
        var vm = this;

        vm.dormitory = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myApp:dormitoryUpdate', function(event, result) {
            vm.dormitory = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
