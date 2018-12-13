package views182

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus

@Integration
@Rollback
class CustomErrorSpec extends HttpClientCommonSpec {

    void 'it is possible to use gson views for handling exception errors'() {
        when: 'executing get to custom error'
        HttpResponse<String> response = client.toBlocking().exchange(HttpRequest.GET("/customError"))

        then:
        response.status == HttpStatus.INTERNAL_SERVER_ERROR
        response.body() == '{"message":"My custom exception handler","error":500}'
    }
}
