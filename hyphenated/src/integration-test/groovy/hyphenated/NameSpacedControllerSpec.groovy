package hyphenated

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
@Rollback
class NameSpacedControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test returns null"() {
        when: "The home page is visited"
        go '/abc-xyz/name-spaced/returns-null'

        then: "The title is correct"
        $().text() == 'returns null'
    }

    void "test returns map"() {
        when: "The home page is visited"
        go '/abc-xyz/name-spaced/returns-map'

        then: "The title is correct"
        $().text() == 'returns Map Sally'
    }

    void "test default action"() {
        when: "The home page is visited"
        go '/abc-xyz/name-spaced'

        then: "The title is correct"
        $().text() == 'default action'
    }
}