package functionaltests

import grails.test.mixin.integration.Integration

import geb.spock.*

@Integration
class FiltersFunctionalSpec extends GebSpec {

    void 'test filters'() {
        when:
        go '/misc/hello'

        then:
        $('h2', 0).text() == 'Helper Before Filter Ran? yes'
        $('h2', 1).text() == 'Helper Message: This Message Came From The After Filter'
    }
}
