describe("Routes Test",function(){
    beforeEach(module("bookCatalogApp"));
    var route;

    beforeEach(inject(function($injector) {
        route = $injector.get('$route');
    }));

    describe("#submitBook", function() {
        it('should get all the authors for the first time', function() {
            expect(route.routes['/add_book'].controller).toBe('AddBookController');
            expect(route.routes['/add_book'].templateUrl).toBe('templates/html/add_book.html')
        });
    });
})