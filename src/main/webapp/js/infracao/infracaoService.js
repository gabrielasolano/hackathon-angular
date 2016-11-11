App.factory('InfracaoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'infracao');
		},
		create: function(item){
			return $http.post(API+'infracao', item);
		},
		update: function(item, id){
			return $http.put(API+'infracao/'+id, item);	
		},
		delete: function(item){
			return $http.post(API+'infracao/deletar', item);
		}/*,
		showMsg: function(){
			return $http.post(API+'agente', item);
		}*/
	}
})