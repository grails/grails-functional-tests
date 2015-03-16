package gorm


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test dynamic finders work"() {
        expect:"Dynamic finders to work"
            Book.count() == 1
            Book.where {
                title == "The Stand"
            }.count() == 1
            Book.findByTitle("The Stand")
            Book.countByTitle("The Stand") == 1    
            Book.findAllByTitle("The Stand").size() == 1
    }
}
