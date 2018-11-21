package functionaltests.chaining


import geb.spock.*
import grails.testing.mixin.integration.Integration

@Integration
class ChainingToNamespacedControllersFunctionalSpec extends GebSpec {

    void "Test chaining to a namespaced controller"() {
        when:"A controller action chains to a namespaced controller"
            go '/chainingHome/chainDemo?ns=alpha'

        then:"The chain works correctly"
        	$('body').text() == 'rendered from the Demo controller in the alpha namespace'

    when:"A controller action chains to a namespaced controller"
        go '/chainingHome/chainDemo?ns=beta'

    then:"The chain works correctly"
        $('body').text() == 'rendered from the Demo controller in the beta namespace'
    }
}
