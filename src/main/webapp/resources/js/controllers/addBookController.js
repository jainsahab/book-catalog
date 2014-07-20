bookCatalogApp.controller('AddBookController', ["$scope","bookService",
    function($scope, bookService){
        var book = {};
        book.title = '';
        book.author = {};
        book.publisher = {};
        $scope.book = book;

        $scope.submitBook = function(){
            bookService.submitBook(this.book);
        }

}]);