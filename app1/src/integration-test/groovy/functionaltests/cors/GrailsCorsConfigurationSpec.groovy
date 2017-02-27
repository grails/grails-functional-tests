package functionaltests.cors

import grails.web.mapping.cors.GrailsCorsConfiguration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import grails.test.mixin.integration.Integration
import grails.transaction.*

@Integration
@Rollback
class GrailsCorsConfigurationSpec extends Specification {

    @Autowired
    GrailsCorsConfiguration grailsCorsConfiguration

    void "test configuration is as expected"() {

        expect:
        grailsCorsConfiguration.mappings.size() == 1
        grailsCorsConfiguration.mappings.get('/api/**') != null
        grailsCorsConfiguration.corsConfigurations.size() == 1
    }

}
