package functionaltests

import grails.testing.mixin.integration.Integration
import spock.lang.*
import geb.spock.*

@Integration
class ValidationFunctionalSpec extends GebSpec {

    @Issue('GRAILS-12039')
    void "Test validation of an invalid Hibernate entity"() {
        when:
        go '/book/validateBook'

        then:
        $().text() == 'The validate method returned false'
    }

    @Issue('GRAILS-12039')
    void "Test validation of a valid Hibernate entity"() {
        when:
        go '/book/validateBook?title=DGG'

        then:
        $().text() == 'The validate method returned true'
    }
}
