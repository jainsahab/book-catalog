bookCatalogApp.service('authorService', ["$resource", "$q", function($resource, $q){

    var Author =$resource('/book-catalog/author/all',{},{
        getAll : { method: 'GET', isArray: true}
    });

    var authorService = {};

    authorService.assignAuthors = function(data){
        authorService.allAuthors = data;
    };

    authorService.getAll = function(){
        if (authorService.allAuthors)
            return {then: function(callback){callback(authorService.allAuthors)}}

        var deferred = $q.defer();
        Author.getAll(function(data){
            deferred.resolve(data);
            authorService.assignAuthors(data);
        });
        return deferred.promise;
    };

    return authorService;
}]);