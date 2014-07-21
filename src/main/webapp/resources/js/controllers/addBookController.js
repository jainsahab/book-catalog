bookCatalogApp.controller('AddBookController', ["$scope","bookService","authorService",
    function($scope, bookService, authorService){
        var book = {};
        book.title = '';
        book.author = {};
        book.publisher = {};
        $scope.book = book;

        $scope.getAllAuthors = function(){
            authorService.getAll();
        }

        $scope.submitBook = function(){
            var success = function(){console.log("chal gaya re")};
            var failure = function(){console.log("nahi chala re")};
            bookService.submitBook(this.book, success, failure);
        }

}]);