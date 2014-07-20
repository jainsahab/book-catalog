beforeEach(module("bookCatalogApp"));
describe("Add Book Controller", function(){
    beforeEach(inject(function($controller, $rootScope, bookService) {
        this.scope = $rootScope.$new();
        this.bookService = bookService;
        return this.controller = $controller('AddBookController', {
            $scope: this.scope,
            bookService: this.bookService
        });
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    describe("#submitBook", function() {
        it('should call service method', function() {
            this.scope.book = {};

            spyOn(this.bookService, 'submitBook');

            this.scope.submitBook();

            expect(bookService.submitBook).toHaveBeenCalledWith(this.scope.book);
        });
    });
});
