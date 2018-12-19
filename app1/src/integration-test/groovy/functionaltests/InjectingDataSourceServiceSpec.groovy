package functionaltests

import grails.testing.mixin.integration.Integration
import spock.lang.PendingFeature
import spock.lang.Specification

@Integration(applicationClass = Application)
class InjectingDataSourceServiceSpec extends Specification {

    InjectingDataSourceService injectingDataSourceService

    @PendingFeature(reason = "pending GORM release with https://github.com/grails/grails-data-mapping/commit/da53cc19d29f76f4f016749ac08e7e2f2ae44014")
    def "you can inject DataSource with def dataSource"() {
        expect:
        injectingDataSourceService != null

        and:
        injectingDataSourceService.dataSourceInjectionWorked()
    }
}
