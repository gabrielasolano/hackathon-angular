App.factory('LocalInfracaoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'localInfracao');
		},
		create: function(item){
			return $http.post(API+'localInfracao', item);
		},
		update: function(item, id){
			return $http.put(API+'localInfracao/'+id, item);	
		},
		delete: function(item){
			return $http.post(API+'localInfracao/deletar', item);
		}/*,
		showMsg: function(){
			return $http.post(API+'agente', item);
		}*/
	}
})