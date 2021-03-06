(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('PreferredContactController', PreferredContactController);

    PreferredContactController.$inject = ['$scope', '$state', 'PreferredContact'];

    function PreferredContactController ($scope, $state, PreferredContact) {
        var vm = this;
        
        vm.preferredContacts = [];

        loadAll();

        function loadAll() {
            PreferredContact.query(function(result) {
                vm.preferredContacts = result;
            });
        }
    }
})();
