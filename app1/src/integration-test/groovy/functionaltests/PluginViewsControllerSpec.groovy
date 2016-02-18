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
class PluginViewsControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that when plugin templates are rendered they render correctly"() {
        when:"A view that renders plugin templates is visisted"
            go '/pluginViews/testTemplateFromPlugin'

        then:"The title is correct"
        	$('div', 0).text() == "Template from plugin: Hello from plugin"
            $('div', 1).text() == "Template from plugin no plugin attribute: Hello from app"
    }

    void "Test that views from a plugin loaded after another plugin override when using loadAfter"() {
        when:"A view that renders plugin views"
            go '/pluginViews/testPluginViewOverrideInPlugin'

        then:"The title is correct"
            $('h1', 0).text() == "Second Plugin"
            
    }    
}
