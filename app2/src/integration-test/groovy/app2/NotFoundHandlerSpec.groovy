package app2

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotFoundHandlerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a 404 handler renders the view correctly when a forward is executed"() {
        when:"An action is visited where an interceptor uses response.sendError(404)"
            go '/foo/index'

        then:"The 404 handler is rendered"
        	title == "Page Not Found"

        when:"No response.sendError(404) method is called"
            go '/foo/index?user=admin'

        then:"The 404 handler is not executed"
            title == "Foo List"            
    }
}
