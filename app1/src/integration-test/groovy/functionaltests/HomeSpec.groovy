package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class HomeSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the home page renders correctly"() {
        when:"The home page is visited"
            go '/'
            if($('title').text() != "Welcome to Grails") {
              println driver.pageSource
            }
        then:"The title is correct"
        	$('title').text() == "Welcome to Grails"
          $('li.controller',0).text() == 'functionaltests.BookController'
          $('li.controller',1).text() == 'functionaltests.ErrorsController'
          $('li.controller',2).text() == 'functionaltests.InspectConfigController'
          $('li.controller',3).text() == 'functionaltests.MiscController'
          $('li.controller',4).text() == 'functionaltests.UploadController'
          // SimpleController should not become a controller as it is not in a grails-app/controllers dir
          !$('li.controller',5).text()

    }
}
