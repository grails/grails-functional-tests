package micronaut

import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import redis.embedded.RedisServer

@Integration
class BeanInjectionServiceSpec extends Specification {

    static RedisServer redisServer = new RedisServer(6379)

    def setupSpec() {
        redisServer.start()
    }

    def cleanupSpec() {
        if(redisServer) {
            redisServer.stop()
        }
    }

    @Autowired
    BeanInjectionService service

    void "test injection is working"() {
        expect:
        service.namedServices.size() == 4
        service.namedService2.name == "regular"
        service.namedService3.name == "special"
        service.namedService4.name == "qualified"
        service.namedService.name == "primary"
        service.statefulRedisConnection.sync().ping() == 'PONG'
    }
}
