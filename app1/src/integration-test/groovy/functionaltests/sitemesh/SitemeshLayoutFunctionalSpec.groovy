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

    @Issue('GRAILS-12045')
    void 'test layout specified in controller property applied to a GSP that does not contain a root html tag'() {
        when:
        go '/layoutSpecifiedByProperty/snippetView'

        then:
        $('title').text() == 'Foo Layout'
        $().text().contains 'this is some content'
    }
}
