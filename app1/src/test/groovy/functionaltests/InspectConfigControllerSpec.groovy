package functionaltests

import grails.test.mixin.integration.Integration

import spock.lang.Issue
import geb.spock.GebSpec

@Integration
class InspectConfigControllerSpec extends GebSpec {

    @Issue('GRAILS-11951')
    void "test config properties from plugins"() {
        when:
        go '/inspectConfig/showPropertyValues'

        then:
        $('div', 0).text() == 'Prop One Defined By LoadFirst Plugin'
        $('div', 1).text() == 'Prop Two Defined By LoadSecond Plugin'
        $('div', 2).text() == 'Prop Three Defined By app1 Application'
    }
}
