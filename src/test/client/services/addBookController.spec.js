describe("Add Book Controller", function(){
    beforeEach(module("bookCatalogApp"));
    beforeEach(inject(function($controller, $rootScope, bookService, authorService) {
        this.scope = $rootScope.$new();
        this.bookService = bookService;
        this.authorService = authorService;
        return this.controller = $controller('AddBookController', {
            $scope: this.scope,
            bookService: this.bookService
        });
    }));


    describe("#submitBook", function() {
        it('should call service method', function() {
            this.scope.book = {};

            spyOn(this.bookService, 'submitBook');

            this.scope.submitBook();

            expect(this.bookService.submitBook).toHaveBeenCalledWith(this.scope.book, jasmine.any(Function), jasmine.any(Function));
        });
    });

    describe("#getAllAuthors", function() {
        it('should call service method', function() {
            var authors = [{id: 1, name: 'Prateek'}];
            spyOn(this.authorService,'getAll').andReturn({ then: function(callback){
                 callback(authors);
            }});

            this.scope.getAllAuthors();

            expect(this.scope.allAuthors).toEqual(authors);
        });
    });
});
