package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
class HomeSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:"The home page is visited"
            go '/'

        then:"The title is correct"
        	$('title').text() == "Welcome to Grails"
          $('li.controller',0).text() == 'functionaltests.BookController'
          // SimpleController should not become a controller as it is not in a grails-app/controllers dir
          !$('li.controller',1).text()

    }
}
