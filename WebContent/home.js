/**
 * Created by sairam on 3/10/2016.
 */
(function(){
    'use strict';

    angular
        .module('permutation', ['ngRoute','angularUtils.directives.dirPagination','ngMessages'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig ($routeProvider) {

        $routeProvider
            .when('/guest', {
                templateUrl: 'userlogin.tmpl.html',


            })
            .when('/phnum', {
                templateUrl: 'number.tmpl.html',
                controller: 'NumberController',
                controllerAs: 'numVm'
            })


            .otherwise({
                redirectTo: '/guest'
            })
    }
})();