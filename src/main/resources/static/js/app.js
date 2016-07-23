var mainApp = angular.module("mainApp", ['ngRoute', 'checklist-model','angular-growl']);

mainApp.config(['$routeProvider', function($routeProvider) {
   $routeProvider.
   
   when('/addPet', {
      templateUrl: 'addPet.htm', controller: 'AddPetController'
   }).
   
   when('/viewPets', {
      templateUrl: 'viewPets.htm', controller: 'ViewPetsController'
   }).
   
   otherwise({
      redirectTo: '/addPet'
   });
	
}]);