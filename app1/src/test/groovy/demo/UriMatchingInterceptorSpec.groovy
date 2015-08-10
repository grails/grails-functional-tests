package demo


import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UriMatchingInterceptor)
class UriMatchingInterceptorSpec extends Specification {

    void "Test uri matching interceptor"() {
        when:
        withRequest(uri: '/interceptorDemo/one')

        then:
        interceptor.doesMatch()

        when:
        withRequest(uri: '/interceptorDemo/two')

        then:
        !interceptor.doesMatch()
    }
}
