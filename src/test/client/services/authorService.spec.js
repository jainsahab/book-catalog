beforeEach(module("bookCatalogApp"));

describe("Author Book Service",function(){
    var authorService;

    beforeEach(inject(function($injector) {
        authorService = $injector.get('authorService');
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    describe("#submitBook", function() {
        it('should get all the authors', function() {
            var authors = [{id:1 , name:'Prayas'}, {id:2 , name:'Prateek'}];

            httpBackend.when('GET', '/book-catalog/author/all').respond(200, authors);

            authorService.getAll();

            httpBackend.flush();
            expect(authorService.allAuthors.length).toBe(2);
        });

//    it('should callback failure if request fails', function() {
//        httpBackend.when('POST', '/book-catalog/book/add').respond(500)
//        var book = {};
//        var onSuccess = jasmine.createSpy();
//        var onFailure = jasmine.createSpy();
//
//        authorService.submitBook(book, onSuccess, onFailure)
//        httpBackend.flush();
//        expect(onSuccess).not.toHaveBeenCalled();
//        expect(onFailure).toHaveBeenCalled();
//    });
    });
//

})