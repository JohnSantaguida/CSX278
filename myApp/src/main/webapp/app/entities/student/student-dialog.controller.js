(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('StudentDialogController', StudentDialogController);

    StudentDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Student', 'PreferredContact', 'Dormitory', 'School'];

    function StudentDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Student, PreferredContact, Dormitory, School) {
        var vm = this;

        vm.student = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.preferredcontacts = PreferredContact.query();
        vm.dormitories = Dormitory.query();
        vm.schools = School.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.student.id !== null) {
                Student.update(vm.student, onSaveSuccess, onSaveError);
            } else {
                Student.save(vm.student, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('myApp:studentUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.graduationDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
