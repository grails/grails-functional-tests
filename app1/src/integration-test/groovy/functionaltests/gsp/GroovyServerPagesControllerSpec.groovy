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

        where:
            action           | content
            "html"           | "<div>This content should be rendered</div>"
            "renderHTML"     | "<div>This content should be rendered</div>"
            "json"           | "{\"foo\":\"bar\"}"
            "renderJSON"     | "{\"foo\":\"bar\"}"
            "markdown"       | "# H1"
            "renderMarkdown" | "# H1"
            "xml"            | "<Foo bar=\"true\">"
            "renderXML"      | "<Foo bar=\"true\">"
            "svg"            | "</svg>"
            "renderSVG"      | "</svg>"
    }
}
