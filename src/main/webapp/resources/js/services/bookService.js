bookCatalogApp.service('bookService', ["$resource", function($resource){

    var Book =$resource('/book-catalog/book/add',{},{
        submit : {
            method: 'POST'
        }
    });

    var bookService = {}
    bookService.submitBook = function(book){
        var onSuccess = function(){console.log("chal gaya bhai")};
        var onFailure = function(){console.log("nahi chala bhai")};
        Book.submit(book, onSuccess, onFailure);
    };

    return bookService;
}]);