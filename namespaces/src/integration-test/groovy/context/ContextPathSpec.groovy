package context

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

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
        title == null
    }
}
