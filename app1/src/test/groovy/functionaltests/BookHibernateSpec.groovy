package functionaltests
/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class BookHibernateSpec extends grails.test.hibernate.HibernateSpec {
    def setup() {
        new Book(title: 'foo').save()
    }

    void "Test that dynamic finders work"() {
        expect:"The book validates"
        	Book.count() == 1
            !Book.findByTitle('hello')

    }
}
