var app = angular.module('myApp');
app.controller('prendasAbmController', ['$scope', '$location', function($scope, $location) {	
	
//	$scope.mostrarPrendas = function(){
//		$location.path = '/prendas'
//	}
    
//	var self = this;
//    self.prenda={id:null,username:'',address:'',email:''};
//    self.prendas=[];
//    
//    self.fetchAllPrendas = function(){
//    	prendasAbmService.fetchAllPrendas()
//            .then(
//					       function(d) {
//						        self.users = d;
//					       },
//      					function(errResponse){
//      						console.error('Error al obtener las actualizaciones');
//      					}
//			       );
//    };
//    
//    self.createPrenda = function(prenda){
//    	prendasAbmService.createPrenda(prenda)
//	              .then(
//                self.fetchAllPrendas, 
//			              function(errResponse){
//				               console.error('Error al crear prenda.');
//			              }	
//            );
//    };
//    
//    self.updatePrenda = function(prenda, id){
//    	prendasAbmService.updatePrenda(prenda, id)
//	              .then(
//			              self.fetchAllPrendas, 
//			              function(errResponse){
//				               console.error('Error al actualizar prenda.');
//			              }	
//            );
//    };
//    
//    self.deletePrenda = function(id){
//    	prendasAbmService.deletePrenda(id)
//	              .then(
//			              self.fetchAllPrendas, 
//			              function(errResponse){
//				               console.error('Error al eliminar prenda.');
//			              }	
//            );
//    };
//    
//    self.fetchAllUsers();
//    
//    self.submitPrenda = function() {
//        if(self.prenda.id==null){
//            console.log('Guardando nueva prenda', self.prenda);    
//            self.createPrenda(self.prenda);
//        }else{
//            self.updatePrenda(self.prenda, self.prenda.id);
//            console.log('Prenda modificada con id ', self.prenda.id);
//        }
//        self.reset();
//    };
    
}]);
