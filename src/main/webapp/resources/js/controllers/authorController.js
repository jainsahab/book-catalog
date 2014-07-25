bookCatalogApp.controller('AuthorController', ["$scope","authorService",
    function($scope, authorService){
        $scope.author = {};

        $scope.saveAuthor = function(){
            var success = function(){console.log("chal gaya re")};
            var failure = function(){console.log("nahi chala re")};
            authorService.saveUser($scope.author, success, failure);
        };
}]);