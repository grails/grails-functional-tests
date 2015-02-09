package functionaltests


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BookInterceptor)
class BookInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test book interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"book")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
