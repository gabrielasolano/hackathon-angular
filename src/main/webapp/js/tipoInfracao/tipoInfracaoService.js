App.factory('TipoInfracaoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'tipoInfracao');
		},
		create: function(item){
			return $http.post(API+'tipoInfracao', item);
		},
		update: function(item, id){
			return $http.put(API+'tipoInfracao/'+id, item);	
		},
		delete: function(item){
			return $http.post(API+'tipoInfracao/deletar', item);
		}/*,
		showMsg: function(){
			return $http.post(API+'agente', item);
		}*/
	}
})