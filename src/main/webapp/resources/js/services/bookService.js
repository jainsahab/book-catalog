bookCatalogApp.service('bookService', ["$resource", function($resource){

    var Book =$resource('/book-catalog/book/add',{},{
        submit : {
            method: 'POST'
        }
    });

    var bookService = {}
    bookService.submitBook = function(book, onSuccess, onFailure){
        Book.submit(book, onSuccess, onFailure);
    };

    return bookService;
}]);