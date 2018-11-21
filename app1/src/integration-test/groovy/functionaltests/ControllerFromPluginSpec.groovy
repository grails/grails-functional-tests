package functionaltests

import grails.testing.mixin.integration.Integration
import spock.lang.*
import geb.spock.*

@Integration(applicationClass=functionaltests.Application)
class ControllerFromPluginSpec extends GebSpec {

    void 'test invoking a controller provided by a plugin'() {
        when:
        go '/alpha'

        then:
        $('h2',0).text() == 'This is views/alpha/index.gsp'
    }
}
