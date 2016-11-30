package functionaltests.gsp

import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Value
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Integration
class GroovyServerPagesControllerSpec extends Specification {

    @Shared
    @Value('${local.server.port}')
    int serverPort

    @Shared
    def rest = new RestBuilder()

    @Unroll("/groovyServerPages/#action => #expectedContentType & contains #content")
    void "testing groovyServerPages"() {
        given:
            String baseUrl = "http://localhost:${serverPort}"

        when:
            def response = rest.get(baseUrl + "/groovyServerPages/$action")

        then:
            response.status == 200
            response.text
            response.text.contains(content)
        and:
            response.getHeaders().getFirst('Content-Type').startsWith(expectedContentType)

        where:
            action           | content                                      | expectedContentType
            "html"           | "<div>This content should be rendered</div>" | "text/html"
            "renderHTML"     | "<div>This content should be rendered</div>" | "text/html"
            "json"           | "{\"foo\":\"bar\"}"                          | "application/json"
            "renderJSON"     | "{\"foo\":\"bar\"}"                          | "application/json"
            "markdown"       | "# H1"                                       | "text/markdown"
            "renderMarkdown" | "# H1"                                       | "text/markdown"
            "xml"            | "<Foo bar=\"true\">"                         | "text/xml"
            "renderXML"      | "<Foo bar=\"true\">"                         | "text/xml"
            "svg"            | "</svg>"                                     | "image/svg+xml"
            "renderSVG"      | "</svg>"                                     | "image/svg+xml"
    }
}
