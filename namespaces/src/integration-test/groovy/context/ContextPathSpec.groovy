package context

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import namespaces.Application
import spock.lang.PendingFeature

@Integration(applicationClass = Application)
@Rollback
class ContextPathSpec extends GebSpec {

    @PendingFeature(reason = 'title is blank')
    void "test the context path defined in the environment overrides the standard one"() {
        when:
        go '/myAppTest'

        then:
        title == "Welcome to Grails"

        when:
        go '/myApp'

        then:
        title == "HTTP Status 404 – Not Found"
    }
}
