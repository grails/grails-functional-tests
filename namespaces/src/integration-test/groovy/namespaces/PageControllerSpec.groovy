package namespaces

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class PageControllerSpec extends GebSpec {

    void "test that the page renders correctly"() {
        when: "The admin page is visited"
        go '/myAppTest/admin/page/index'

        then: "The title is correct"
        title == 'Admin Page'

        when: "The page is visited without namespace"
        go '/myAppTest/page/index'

        then: "The title is correct"
        title == 'Frontend Page'
    }
}
