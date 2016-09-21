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
class ConfigTestControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that configuration properties are correctly read"() {
        when:"When evaluting configuration values"
        go '/configTest/index'

        then:"The values are correct"
        $('div', 0).text() == 'test'
        $('div', 1).text() == '1'
        $('div', 2).text() == 'test'
        $('div', 3).text() == '1'
        $('div', 4).text() == 'test'
        $('div', 5).text() == '1'
        $('div', 6).text() == '{bar=test, baz=1, bax=2}'
    }
}
