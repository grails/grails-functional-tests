package hyphenated

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback

@Integration(applicationClass = Application)
@Rollback
class FooBarControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test returns null"() {
        when:"The home page is visited"
        go '/foo-bar/returns-null'

        then:"The title is correct"
        $().text() == 'returns null'
    }

    void "test returns map"() {
        when:"The home page is visited"
        go '/foo-bar/returns-map'

        then:"The title is correct"
        $().text() == 'returns Map Sally'
    }

    void "test default action"() {
        when:"The home page is visited"
        go '/foo-bar'

        then:"The title is correct"
        $().text() == 'default action'
    }
}
