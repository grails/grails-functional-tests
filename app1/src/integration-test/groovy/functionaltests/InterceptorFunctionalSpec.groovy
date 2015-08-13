package functionaltests

import grails.test.mixin.integration.Integration

import geb.spock.GebSpec
import spock.lang.Issue

@Integration
class InterceptorFunctionalSpec extends GebSpec {

    @Issue('grails/grails-core#9183')
    void "Test that an after interceptor can return false to disable view rendering"() {
        when:
        go '/demo/show'

        then:
        $().text() == 'the after interceptor rendered this'
    }
}
