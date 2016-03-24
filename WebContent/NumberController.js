/**
 * Created by sairam on 3/16/2016.
 */
(function(){

    'use strict';

    angular
        .module('permutation')
        .controller('NumberController', NumberController);

    NumberController.$inject = ['dataService'];

    function NumberController(dataService) {
        var numVm = this;

        numVm.obj={};
        numVm.permute= function(number){
            console.log(number);
            numVm.count=Math.pow(36,7);
            dataService
                .getresults(number)
                .then(function (data) {
                    numVm.perm = data;
                    console.log(numVm.perm);
                }, function (error) {
                    console.log(error);
                })
        }

    }
})();