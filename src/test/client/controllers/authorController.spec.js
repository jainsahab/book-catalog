describe("Author Controller", function(){
    beforeEach(module("bookCatalogApp"));
    beforeEach(inject(function($controller, $rootScope, authorService) {
        this.scope = $rootScope.$new();
        this.authorService = authorService;
        return this.controller = $controller('AuthorController', {
            $scope: this.scope,
            authorService: this.authorService
        });
    }));


    describe("#submitBook", function() {
        it('should call service method', function() {
            this.scope.author = {name:'some-name'};

            spyOn(this.authorService, 'saveUser');

            this.scope.saveAuthor();

            expect(this.authorService.saveUser).toHaveBeenCalledWith(this.scope.author, jasmine.any(Function), jasmine.any(Function));
        });
    });
});
