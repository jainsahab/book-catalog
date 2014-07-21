bookCatalogApp.service('authorService', ["$resource", function($resource){

    var Author =$resource('/book-catalog/author/all',{},{
        getAll : { method: 'GET', isArray: true}
    });

    var authorService = {};

    authorService.assignAuthors = function(data){
        authorService.allAuthors = data;
    };

    authorService.getAll = function(){
        Author.getAll({}, this.assignAuthors);
    };

    return authorService;
}]);