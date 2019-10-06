app.factory('usuarioAbmService', ['$http', '$q', function($http, $q){

	return {
		    
		    login: function(usuario){
		    	
		    	var url = "http://localhost:8080/postUsuario";
		    	
				var config = {
		                headers : {
		                    'Accept': 'text/plain'
		                }
		        }
		    	
					return $http.post(url, usuario, config)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error al realizar login');
										return $q.reject(errResponse);
									}
							);
		    },
		    
//			fetchUsuario: function(usuarioId) {
//				
//				var url = $location.absUrl() + "getUsuario/" + usuario.id;
//				
//				return $http.get(url)
//							.then(
//									function(response){
//										return response.data;
//									}, 
//									function(errResponse){
//										console.error('Error while fetching users');
//										return $q.reject(errResponse);
//									}
//							);
//			},
		
	};

}]);