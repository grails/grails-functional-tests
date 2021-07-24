package functionaltests

import grails.core.GrailsApplication
import grails.gorm.transactions.Rollback
import grails.test.mixin.integration.Integration
import grails.util.Holders
import groovy.util.logging.Slf4j

import org.example.MyBean
import org.springframework.context.support.GenericApplicationContext
import org.springframework.core.io.ClassPathResource
import spock.lang.Specification

@Integration
@Rollback
@Slf4j
class ContextLoadingSpec extends Specification {

    ContextLoaderService contextLoaderService

    void "test managing child app context"() {

        given:
        ClassPathResource myAppCtx = new ClassPathResource("AppCtx.xml")

        when:
        GrailsApplication application = Holders.getGrailsApplication()

        then:
        application != null

        when:
        GenericApplicationContext context = contextLoaderService.loadContext(myAppCtx)
        MyBean bean = context.getBean("myBean", MyBean)

        then:
        bean != null
        Holders.getGrailsApplication() == application

        when:
        context.close()

        then:
        Holders.getGrailsApplication() == application

    }
}
