package functionaltests.scaffolding

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration
@Rollback
class BarFunctionalSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a scaffolded view is resolved correctly"() {
        when:
        go '/bar/index'

        then:
        title == "Bar List"
    }
}