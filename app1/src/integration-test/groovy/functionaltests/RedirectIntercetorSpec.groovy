package functionaltests

import grails.test.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

/**
 * @author graemerocher
 */
@Integration
class RedirectInterceptorSpec extends GebSpec {

    void "Test that an interceptor that redirects works"() {
        when:
        go '/misc/interceptedByInterceptor'

        then:
        driver.pageSource.contains 'Test' // the redirect worked
    }
}
