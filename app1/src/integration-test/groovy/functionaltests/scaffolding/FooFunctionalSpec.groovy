package functionaltests.scaffolding

import functionaltests.Application
import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
@Rollback
class FooFunctionalSpec extends GebSpec {

    void "Test that a scaffolded view is resolved correctly"() {
        when:
        go '/foo/index'

        then:
        title == "Foo List"
    }
}
