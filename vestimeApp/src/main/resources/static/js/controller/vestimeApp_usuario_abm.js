var app = angular.module('myApp');
app.controller('usuarioAbmController', ['$scope', '$http', '$location', 'usuarioAbmService', 'prendasAbmService', function($scope, $http, $location, usuarioAbmService, prendasAbmService) {
	
//	var self = this;
//    self.usuario= {id:null,mail:'',membresia:''};   
//    
//    self.createUsuario = function(usuario){
//    	usuarioAbmService.createUsuario(usuario)
//	              .then(
//			              function(errResponse){
//				               console.error('Error al realizar el login');
//			              }	
//            );
//    };
//    
//    self.ingresar = function(usuarioId){
//    	usuarioAbmService.updatePrenda(prenda, id)
//	              .then(
//			              self.fetchAllPrendas, 
//			              function(errResponse){
//				               console.error('Error al actualizar prenda.');
//			              }	
//            );
//    };
	
//    self.submitUsuario = function() {
//        if(self.usuario.id==null){
//            console.log('Guardando usuario', self.usuario);    
//            self.createUsuario(self.usuario);
//        }else{
//            self.ingresar(self.usuario.id);
//            console.log('Ingresando con usuario: ', self.usuario.id);
//        }
//        self.reset();
//    };
    

										$scope.submitForm = function() {

				var data = {
					mail : $scope.mail,
				};

				usuarioAbmService.login(data).then(
						function(response) {
							 $location.path( "/home" );
						},
						function error(response) {
							$scope.postResultMessage = "Error with status: "
									+ response.statusText;
						});

				$scope.firstname = "";
				$scope.lastname = "";
			}
							
					          self.fetchAllUsers = function(){
					              UserService.fetchAllUsers()
					                  .then(
					      					       function(d) {
					      						        self.users = d;
					      					       },
					            					function(errResponse){
					            						console.error('Error while fetching Currencies');
					            					}
					      			       );
					          };
	
	
}]);