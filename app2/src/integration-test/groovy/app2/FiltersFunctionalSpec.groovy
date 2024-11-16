package app2

import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration
import spock.lang.Ignore

@Ignore('Filters support was dropped in Grails 3.2 according to f370b49')
@Integration(applicationClass = Application)
class FiltersFunctionalSpec extends ContainerGebSpec {

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
