package gorm


import grails.test.mixin.integration.Integration
import grails.transaction.*
import org.grails.datastore.gorm.query.transform.ApplyDetachedCriteriaTransform
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class BookSpec extends Specification {


    @Autowired
    TestService testService

    void "Test dynamic finders work"() {
        expect:"Dynamic finders to work"
            testService.testDynamicFinders() // test when called from service
            Book.count() == 1
            Book.findByTitle("The Stand")
            Book.countByTitle("The Stand") == 1
            Book.countByTitle("Something Else") == 0
            Book.findAllByTitle("The Stand").size() == 1

    }

    void "Test that services are autowired on construction and retrieval"() {
        expect:
            new Book().testService
            Book.first().testService
    }
}
