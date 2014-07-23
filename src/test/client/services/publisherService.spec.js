describe("Publisher Book Service",function(){
    var publisherService;
    var httpBackend;
    beforeEach(module("bookCatalogApp"));
    beforeEach(inject(function($injector) {
        publisherService = $injector.get('publisherService');
        httpBackend = $injector.get('$httpBackend');
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    describe("#getAllPublishers", function() {
        it('should get all the publishers for the first time', function() {
            var publishers = [{id:1 , name:'Prayas'}, {id:2 , name:'Prateek'}];

            httpBackend.when('GET', '/book-catalog/publisher/all').respond(200, publishers);

            var promise = publisherService.getAll();

            httpBackend.flush();
            promise.then(function(data){
                expect(data.length).toBe(2)
            });
        });

        it('should get all the publishers as they have already cached', function() {
            publisherService.allPublishers = [{id:1 , name:'Prayas'}, {id:2 , name:'Prateek'}];

            var promise = publisherService.getAll();

            promise.then(function(data){
                expect(data.length).toBe(2)
            });
        });
    });
});
