package functionaltests.scaffolding

import functionaltests.Application
import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
@Rollback
class BarFunctionalSpec extends GebSpec {

    void "Test that a scaffolded view is resolved correctly"() {
        when:
        go '/bar/index'

        then:
        title == "Bar List"
    }
}