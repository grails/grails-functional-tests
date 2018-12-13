package functionaltests

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import spock.lang.Ignore

@Integration
class LoadAfterSpec extends GebSpec {

    @Ignore("Ignored until spring-security-core is migrated")
    void "Test override one plugin view from another plugin"() {
        when:
        go '/login/auth'

        then:
        title == "My Plugin Login Auth"
    }
}
