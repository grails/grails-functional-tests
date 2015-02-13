package functionaltests
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    void "Test validating a book"() {
        expect:"The book validates"
            new Book(title:"The Stand").validate()
    }
}
