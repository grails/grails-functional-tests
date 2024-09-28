package functionaltests

import spock.lang.Ignore

class BookHibernateSpec extends grails.test.hibernate.HibernateSpec {
    def setup() {
        new Book(title: 'foo').save()
    }

    @Ignore('Either class [functionaltests.Book] is not a domain class or GORM has not been initialized correctly or has already been shutdown. Ensure GORM is loaded and configured correctly before calling any methods on a GORM entity.')
    void "Test that dynamic finders work"() {
        expect:"The book validates"
        	Book.count() == 1
            !Book.findByTitle('hello')

    }
}
