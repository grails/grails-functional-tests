package issue10964

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class PostgresDateCreatedNullSpec extends Specification {

    void 'test dateCreated is saved on Postgres'() {
        given:
        RestBuilder rest = new RestBuilder()

        when: 'saving an object with dateCreated and lastUpdated'
        def resp = rest.get("http://localhost:${serverPort}/test/save") {
            accept('application/json')
            contentType('application/json')
        }

        then: 'dateCreated and lastUpdated are set'
        resp.status == 200
        resp.json.id != null
        resp.json.dateCreated != null
        resp.json.lastUpdated != null
        resp.json.uid == 'foo'

        when: 'updating a property'
        def resp2 = rest.get("http://localhost:${serverPort}/test/update?id=${resp.json.id}") {
            accept('application/json')
            contentType('application/json')
        }

        then: 'dateCreated is the same but lastUpdated is updated'
        resp2.status == 200
        resp2.json.id == resp.json.id
        resp2.json.dateCreated == resp.json.dateCreated
        resp2.json.lastUpdated != resp.json.lastUpdated
        resp2.json.uid == 'bar'
    }
}
