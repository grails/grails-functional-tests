package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class BookFunctionalSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a book was created in the Bootstrap class"() {
        when:"We go to the book URI"
            go '/book/show/1'

        then:"Then thew show book view is rendered"
        	$('title').text() == "Show Book"
    }
}
