beforeEach(module("bookCatalogApp"));
var bookService;
var httpBackend;
beforeEach(inject(function($injector) {
    httpBackend = $injector.get('$httpBackend');
    bookService = $injector.get('bookService');
}));

afterEach(function() {
    httpBackend.verifyNoOutstandingExpectation();
    httpBackend.verifyNoOutstandingRequest();
});

describe("#submitBook", function() {
    it('should callback success if request fails', function() {
        httpBackend.when('POST', '/book-catalog/book/add').respond(201)
        var book = {};
        var onSuccess = jasmine.createSpy();
        var onFailure = jasmine.createSpy();

        bookService.submitBook(book, onSuccess, onFailure)
        httpBackend.flush();
        expect(onSuccess).toHaveBeenCalled();
        expect(onFailure).not.toHaveBeenCalled();
    });

    it('should callback failure if request fails', function() {
        httpBackend.when('POST', '/book-catalog/book/add').respond(500)
        var book = {};
        var onSuccess = jasmine.createSpy();
        var onFailure = jasmine.createSpy();

        bookService.submitBook(book, onSuccess, onFailure)
        httpBackend.flush();
        expect(onSuccess).not.toHaveBeenCalled();
        expect(onFailure).toHaveBeenCalled();
    });
});

