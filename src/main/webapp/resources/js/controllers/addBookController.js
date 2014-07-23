bookCatalogApp.controller('AddBookController', ["$scope","bookService","authorService","publisherService",
    function($scope, bookService, authorService, publisherService){
        var book = {};
        book.title = '';
        book.author = {};
        book.publisher = {};
        $scope.book = book;

        $scope.getAuthorsAndPublishers = function(){
            authorService.getAll().then(assignAuthors);
            publisherService.getAll().then(assignPublishers);
        };

        $scope.submitBook = function(){
            var success = function(){console.log("chal gaya re")};
            var failure = function(){console.log("nahi chala re")};
            bookService.submitBook(this.book, success, failure);
        };

        var assignAuthors = function(data){
            $scope.allAuthors = data;
        };

        var assignPublishers = function(data){
            $scope.allPublishers = data;
        }

}]);