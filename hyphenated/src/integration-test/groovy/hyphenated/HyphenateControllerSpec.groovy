package hyphenated

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class HyphenateControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:"The home page is visited"
            go '/hyphenate/long-name'

        then:"The title is correct"
        	$().text() == 'good'
    }

    void 'test action which returns map'() {
        when:
        go '/hyphenate/some-action-which-returns-map'

        then:
        $('h2').text() == 'Company Name: OCI'
    }
}
