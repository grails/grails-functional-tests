package functionaltests.scaffolding

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration
@Rollback
class FooFunctionalSpec extends GebSpec {

    void "Test that a scaffolded view is resolved correctly"() {
        when:
        go '/foo/index'

        then:
        title == "Foo List"
    }
}
