package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.*
import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class BookFunctionalSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    @Value('${local.server.port}')
    int serverPort

    void "Test that when the /viewBooks URL is hit it redirects to the book list"() {
        when:"We go to the book URI"
            go "http://graemes-imac.local:$serverPort/book/index"

        then:"Then thew show book view is rendered"
            title == "Book List"
    }    

     void "Test that a book was created in the Bootstrap class"() {
         when:"We go to the book URI"
             go '/book/show/1'

         then:"Then thew show book view is rendered"
         	title == "Show Book"
     }

     void "Test that switching language results in correct encodings"() {
         when:"the show page is rendered in german"
             go "/book/show/1?lang=de"
             println driver.pageSource
         then:"The language is correct"
             $('a', class:'create').text() == 'Book anlegen'
             $('input', class:'delete').@value == 'Löschen'
     }
}
