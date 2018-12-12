package app3

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class LoadAfterSpec extends GebSpec {

    void "Test override one plugin view from another plugin"() {
        when:
        go '/login/auth'

        then:
        title == "My Plugin Login Auth"
    }
}
