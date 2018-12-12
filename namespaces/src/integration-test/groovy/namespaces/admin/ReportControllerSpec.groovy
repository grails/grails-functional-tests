package namespaces.admin

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class ReportControllerSpec extends GebSpec {

    void "test that admin report page renders correctly"() {
        when: "The admin report page is visited"
        go '/myAppTest/admin/report/index'

        then: "The title is correct"
        title == 'Admin Report'

        when: "The admin report page is visited without namespace"
        go '/myAppTest/report/index'

        then: "The title is correct"
        title == 'Admin Report'
    }
}
