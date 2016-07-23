 mainApp.controller('AddPetController', function($scope, PetStoreService, growl) {
            $scope.message = "This page will be used to display add pet form";
            $scope.categories = [];
            $scope.pet = {};
            $scope.photoUrl = "";
            $scope.selectedTags = [];
            $scope.init = function() { 
            	 	PetStoreService.loadPetCategory().then(function(resp) {
            	 		if(resp!=null && resp.data !=null) {
				      		$scope.categories = resp.data;
				      	}
				    });
				    
				    PetStoreService.loadTags().then(function(resp) {
            	 		if(resp!=null && resp.data !=null) {
				      		$scope.tags = resp.data;
				      	}
				    });
            };
            $scope.addNewPet = function() {
                if($scope.selectedTags.length > 0) {
                	$scope.pet.tags = $scope.selectedTags.toString();
                }
            	PetStoreService.save($scope.pet).then(function(resp) {
            	 		if(resp!=null && resp.data !=null) {
				      		console.log("save successful");
				      		growl.success("Save successful");
				      	}
				    });
            };
            $scope.addPhotoUrl = function() {
            	if($scope.pet.photoUrls === undefined)
            	{
            		$scope.pet.photoUrls = [];
            	} 
            	$scope.pet.photoUrls.push($scope.photoUrl);
            };
         });
         