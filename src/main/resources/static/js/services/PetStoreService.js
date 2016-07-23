mainApp.service('PetStoreService', function($http){
   this.loadPetCategory = function() {
       var promise = $http.get('/petworld/api/category');
       return promise;
     
   }
   
   this.loadTags = function() {
       var promise = $http.get('/petworld/api/tag');
       return promise;
     
   }
   
    this.loadPets = function() {
       var promise = $http.get('/petworld/api/pet');
       return promise;
     
   }
    this.save = function(petObj) {
       var petJsonObj = angular.copy(petObj);
       console.log(JSON.stringify(petJsonObj));
       var promise = $http.post('/petworld/api/pet', JSON.stringify(petJsonObj));
       return promise;
     
   }
    this.delete = function(petId) {
       console.log("deleting pet:"+petId);
       var promise = $http.delete('/petworld/api/pet/'+petId);
       return promise;
     
   }
});