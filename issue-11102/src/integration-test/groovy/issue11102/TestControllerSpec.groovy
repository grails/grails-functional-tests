package issue11102

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class TestControllerSpec extends Specification {

    void 'can forward a request from a GET to another GET action'() {
        given:
        RestBuilder rest = new RestBuilder()

        when: 'getting the get1 action'
        def resp = rest.get("http://localhost:${serverPort}/get1")

        then: 'it is executed correctly'
        resp.status == 200
        resp.text == 'GET1'

        when: 'executing an action with a forward to the other one'
        def resp2 = rest.get("http://localhost:${serverPort}/get2")

        then: 'the request is forwarded'
        resp2.status == 200
        resp2.text == 'GET1'
    }
}
