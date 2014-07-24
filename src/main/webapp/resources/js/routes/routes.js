bookCatalogApp.config(['$routeProvider',function($routeProvider){

    $routeProvider.when("/add_book",{
        templateUrl: 'templates/html/add_book.html',
        controller: 'AddBookController'
    });
}]);
