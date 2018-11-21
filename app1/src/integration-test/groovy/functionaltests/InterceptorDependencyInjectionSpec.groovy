package functionaltests

import grails.testing.mixin.integration.Integration
import spock.lang.*
import geb.spock.*

/**
 * @author graemerocher
 */
@Integration
class InterceptorDependencyInjectionSpec extends GebSpec {

    void "Test that interceptors are subjected to autowire by name"() {
        when:
        go '/misc/actionWhichReturnsMap'

        then:
        $('h2', text: 'The Magic Number Is 42')
    }
}
