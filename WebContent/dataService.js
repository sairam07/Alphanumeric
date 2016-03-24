/**
 * Created by sairam on 3/10/2016.
 */
(function() {
    'use strict';

    angular
        .module('permutation')
        .service('dataService', dataService);

    dataService.$inject = ['$http', '$q'];

    function dataService ($http, $q) {

        var self = this;

        self.getresults = function (id) {
            var defer = $q.defer();

            $http
                .get('http://localhost:8080/Permutation/app/permut/' + id)
                .then(function (response) {
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };






    }



})();