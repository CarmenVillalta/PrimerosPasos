app.factory('prendasAbmService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllPrendas: function(usuario, guardarropa) {
				
				var url = "localhost:8080/getPrendas";
				
				return $http.get(url)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createPrenda: function(prenda){
		    	
		    	var url = $location.absUrl() + "createPrenda";
		    	
				var config = {
		                headers : {
		                    'Accept': 'text/plain'
		                }
		        }
		    	
					return $http.post(url, prenda)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updatePrenda: function(prenda, id){
		    	
		    	var url = $location.absUrl() + "updatePrenda/";
		    	
					return $http.put(url + id, prenda)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deletePrenda: function(id){
				
				var url = $location.absUrl() + "deletePrenda/";
				
					return $http.delete(url + id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting user');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);