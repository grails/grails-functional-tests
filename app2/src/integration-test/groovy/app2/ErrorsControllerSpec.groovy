package app2

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass = Application)
@Rollback
class ErrorsControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }


    void "Test a global 500 mapping that maps to another controller"() {
        when:"An action that throws a error that is handled by a 500 mapping in UrlMappings.groovy"
            go '/test/throwGeneralError'

        then:"The correct action is executed"
            driver.pageSource.contains 'error occured'
    }

}
