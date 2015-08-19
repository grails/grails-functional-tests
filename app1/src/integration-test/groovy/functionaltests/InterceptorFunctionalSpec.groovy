package functionaltests

import grails.test.mixin.integration.Integration

import geb.spock.GebSpec
import spock.lang.Issue

@Integration
class InterceptorFunctionalSpec extends GebSpec {

    @Issue('grails/grails-core#9183')
    void "Test that an after interceptor can render text and return false to disable view rendering"() {
        when:
        go '/demo/show'

        then:
        $().text() == 'the after interceptor rendered this'
    }

    void 'Test that after interceptor can render a model and view'() {
        when:
        go '/demo/show?interceptorRendersView=true'

        then:
        $().text() == 'Name: JSB'
    }


    void 'Test that after interceptor can render text'() {
        when:
        go '/demo/show?interceptorRendersText=true'

        then:
        $().text() == 'text rendered by interceptor'
    }

    @Issue('grails/grails-core#9194')
    void 'Test that after interceptor can redirect'() {
        when:
        go '/demo/show?interceptorRedirects=true'

        then:
        $().text() == 'Hi There!'
    }

}
