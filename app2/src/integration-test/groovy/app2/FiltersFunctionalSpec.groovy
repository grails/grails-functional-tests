package app2

import grails.test.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

@Integration
@Ignore
class FiltersFunctionalSpec extends GebSpec {

    void 'test before filter'() {
        when:
        go '/filtersDemo/index'

        then:
        driver.pageSource.contains 'Filter Ran: yes.'

        // TODO: Why doesn't this work?...
        // $().text() == 'Filter Ran: yes.'
    }

    void 'test after filter'() {
        when:
        go '/filtersDemo/data'

        then:
        $('h2', 0).text() == 'Company Name: OCI'
        $('h2', 1).text() == 'Company City: St. Louis'
    }
}
