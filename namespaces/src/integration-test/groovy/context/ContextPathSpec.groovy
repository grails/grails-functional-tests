package context

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback

@Integration
@Rollback
class ContextPathSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {

    }

    void "test the context path defined in the environment overrides the standard one"() {
        when:
        go '/myAppTest'

        then:
        title == "Welcome to Grails"

        when:
        go '/myApp'

        then:
        title.contains('HTTP Status 404')
    }
}
