package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class ErrorsFunctionalSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test 500 mappings for custom exceptions"() {
        when:"An action that throws a custom error that is handled by a 500 mapping in UrlMappings.groovy"
            go '/errors/throwCustomError'

        then:"The correct action is executed"
            driver.pageSource.contains 'Message = Something bad'
    }

    void "Test default 500 mapping"() {
        when:"An excetion that throws a general error handled by the default 500 mapping in UrlMapings.groovy"
            go '/errors/throwGeneralError'

            println driver.pageSource

        then:"The title is correct"
            $('ul', class:'errors').text() == 'An error has occurred'
    }
}
