package namespaces

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class NamespaceViewRenderingSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test view rendering works as expected when namespaces are used"() {
        when:"When an implicit namespace is used"
            go '/myAppTest/test/implicitView'

        then:"The view is rendered"
        	$('body').text() == "Implicit View Rendered!"

        when:"When an explicit view with a namespace is used"
            go '/myAppTest/test/explicitView'

        then:"The view is rendered"
        	$('body').text() == "Foo View Rendered"
    }
}
