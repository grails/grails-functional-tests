package micronaut

import bean.injection.NamedService
import bean.injection.Qualified
import org.springframework.beans.factory.annotation.Autowired
import io.lettuce.core.api.StatefulRedisConnection
import org.springframework.beans.factory.annotation.Qualifier
import javax.inject.Named

class BeanInjectionService {

    @Autowired
    List<NamedService> namedServices

    @Autowired
    @Named('regular')
    NamedService namedService2

    @Autowired
    @Named('special')
    NamedService namedService3

    @Autowired
    @Qualified
    NamedService namedService4

    @Autowired
    NamedService namedService

    // TODO: it should not be needed to add this Qualifier
    @Qualifier("io.lettuce.core.api.StatefulRedisConnection(Primary)")
    @Autowired
    StatefulRedisConnection<String, String> statefulRedisConnection
}
