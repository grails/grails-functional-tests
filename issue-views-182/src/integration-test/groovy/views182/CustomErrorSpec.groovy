package views182

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class CustomErrorSpec extends Specification {

    void 'it is possible to use gson views for handling exception errors'() {
        given: 'a rest client'
        def builder = new RestBuilder()

        when: 'executing get to custom error'
        def resp = builder.get("http://localhost:${serverPort}/customError")

        then:
        resp.status == 500
        resp.text == '{"message":"My custom exception handler","error":500}'
    }
}
