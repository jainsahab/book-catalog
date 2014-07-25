bookCatalogApp.service('authorService', ["$resource", "$q", function($resource, $q){

    var Author =$resource('/book-catalog/author',{},{
        getAll : { method: 'GET', isArray: true, url: '/book-catalog/author/all'},
        save : { method: 'PUT', url: '/book-catalog/author/save'}
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

    authorService.saveUser = function(author, success, failure){
        Author.save(author, success, failure);
    };

    return authorService;
}]);