bookCatalogApp.controller('AddBookController', ["$scope","bookService",
    function($scope, bookService){
        var book = {};
        book.title = '';
        book.author = {};
        book.publisher = {};
        $scope.book = book;

        $scope.submitBook = function(){
            var success = function(){console.log("chal gaya re")};
            var failure = function(){console.log("nahi chala re")};
            bookService.submitBook(this.book, success, failure);
        }

}]);