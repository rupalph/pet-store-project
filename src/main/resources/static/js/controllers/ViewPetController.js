mainApp.controller('ViewPetsController', function($scope, PetStoreService) {
            $scope.message = "This page will be used to display all the pets";
            $scope.pets = [];
            
            $scope.init = function() { 
            	 	$scope.load();
            };
            
            $scope.load = function() {
            	PetStoreService.loadPets().then(function(resp) {
            	 		if(resp!=null && resp.data !=null) {
				      		$scope.pets = resp.data;
				      	}
				    });
            };
             $scope.deletePet = function(petObj) { 
            	 	PetStoreService.delete(petObj.id).then(function(resp) {
            	 		$scope.load();
				    });
            };
         });
		