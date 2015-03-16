package functionaltests.sitemesh

import grails.test.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

@Integration
class SitemeshLayoutFunctionalSpec extends GebSpec {

    @Issue('GRAILS-12045')
    void 'test layout by convention'() {
        when:
        go '/layoutByConvention'

        then:
        $('title').text() == 'Convention Layout'
    }

    @Issue('GRAILS-12045')
    void 'test layout specified in controller property'() {
        when:
        go '/layoutSpecifiedByProperty'

        then:
        $('title').text() == 'Foo Layout'

    }
}
