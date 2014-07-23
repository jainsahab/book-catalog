bookCatalogApp.service('publisherService', ["$resource", "$q", function($resource, $q){

    var Publisher =$resource('/book-catalog/publisher/all',{},{
        getAll : { method: 'GET', isArray: true}
    });

    var publisherService = {};

    publisherService.assignAuthors = function(data){
        publisherService.allPublishers = data;
    };

    publisherService.getAll = function(){
        if (publisherService.allPublishers)
            return {then: function(callback){callback(publisherService.allPublishers)}}

        var deferred = $q.defer();
        Publisher.getAll(function(data){
            deferred.resolve(data);
            publisherService.assignAuthors(data);
        });
        return deferred.promise;
    };

    return publisherService;
}]);