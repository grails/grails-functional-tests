package functionaltests.sitemesh

import functionaltests.Application
import grails.testing.mixin.integration.Integration
import spock.lang.*
import geb.spock.*

@Integration(applicationClass = Application)
class SitemeshLayoutFunctionalSpec extends GebSpec {

    @Issue('GRAILS-12045')
    void 'test layout by convention'() {
        when:
        go '/layoutByConvention'

        then:
        title == 'Convention Layout'
    }

    @Issue('GRAILS-12045')
    void 'test layout specified in controller property'() {
        when:
        go '/layoutSpecifiedByProperty'

        then:
        title == 'Foo Layout'

    }

    @Issue('GRAILS-12045')
    void 'test layout specified in controller property applied to a GSP that does not contain a root html tag'() {
        when:
        go '/layoutSpecifiedByProperty/snippetView'

        then:
        title  == 'Foo Layout'
        $().text().contains 'this is some content'
    }
}
