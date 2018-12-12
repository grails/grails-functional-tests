package app2

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

/**
 */
@Integration(applicationClass = Application)
@Rollback
class ErrorsControllerSpec extends GebSpec {

    void "Test a global 500 mapping that maps to another controller"() {
        when:"An action that throws a error that is handled by a 500 mapping in UrlMappings.groovy"
            go '/test/throwGeneralError'

        then:"The correct action is executed"
            driver.pageSource.contains 'error occured'
    }

}
