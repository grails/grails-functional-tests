package functionaltests

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class CustomErrorControllerFunctionalSpec extends GebSpec {

    def "params forwarded to error controller"() {
        when:
        go '/customError'

        then:
        $('body').text() == 'id: name: color: format:'

        when:
        go '/customErrorWithName/sergio/'

        then:
        $('body').text() == 'id: name:sergio color: format:'

        when:
        go '/customErrorWithId/123/'

        then:
        $('body').text() == 'id:123 name: color: format:'

        when:
        go '/customErrorWithId/123/?color=red'

        then:
        $('body').text() == 'id:123 name: color:red format:'

        when:
        go '/customError.json'

        then:
        $('body').text() == 'id: name: color: format:json'
    }

}
