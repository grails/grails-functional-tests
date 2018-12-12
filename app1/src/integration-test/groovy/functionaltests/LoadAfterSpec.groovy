package functionaltests

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class LoadAfterSpec extends GebSpec {

    void "Test override one plugin view from another plugin"() {
        when:
        go '/login/auth'

        then:
        title == "My Plugin Login Auth"
    }
}
