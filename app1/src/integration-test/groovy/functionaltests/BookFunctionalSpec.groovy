package functionaltests

import geb.spock.*
import grails.testing.mixin.integration.Integration

/**
 */

@Integration(applicationClass = Application)
class BookFunctionalSpec extends GebSpec {

//    @Value('${local.server.port}')
//    int serverPort

    void "Test that when the /viewBooks URL is hit it redirects to the book list"() {
        when:"We go to the book URI"
            go "/book/index"

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
