package functionaltests

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

import spock.lang.*

/**
 */
@Integration(applicationClass = Application)
@Rollback
class BookIntegrationSpec extends Specification {

    void "create book and save"() {
        given:
        def book = new Book(title:"The Stand")
        when:
        book.save(flush: true)

        then:
        Book.list()?.size() == 2
    }

    void "test transaction rolled back from previous test"() {
        expect:
            Book.count() == 1
    }

    void "create book and save with where"() {
        given:
        def book = new Book(title:title).save(flush: true)

        expect:
        book != null
        where:
        title        | count
        "The Stand"  | 2
    }


    def "test toUpperCase"() {
        given:
        def result = value.toUpperCase()

        expect:
        result == expectedResult

        where:
        value | expectedResult
        'King Crimson' | 'KING CRIMSON'
        'Riverside'    | 'RIVERSIDE'
    }
}
