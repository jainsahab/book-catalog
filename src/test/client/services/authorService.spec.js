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
        it('should get all the authors for the first time', function() {
            var authors = [{id:1 , name:'Prayas'}, {id:2 , name:'Prateek'}];

            httpBackend.when('GET', '/book-catalog/author/all').respond(200, authors);

            var promise = authorService.getAll();

            httpBackend.flush();
            promise.then(function(data){
                expect(data.length).toBe(2)
            });
        });

        it('should get all the authors as they have already cached', function() {
            authorService.allAuthors = [{id:1 , name:'Prayas'}, {id:2 , name:'Prateek'}];

            var promise = authorService.getAll();

            promise.then(function(data){
                expect(data.length).toBe(2)
            });
        });

    });
})