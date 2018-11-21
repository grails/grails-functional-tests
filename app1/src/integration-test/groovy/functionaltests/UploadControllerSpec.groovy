package functionaltests

import geb.spock.*
import grails.testing.mixin.integration.Integration

/**
 */
@Integration(applicationClass=functionaltests.Application)
class UploadControllerSpec extends GebSpec {


    void "Test file upload"() {
        when:"When go to an upload page"
            go "/upload/index"

            def f = File.createTempFile("uploadtest", "txt")
            f.deleteOnExit()
            f.text = "Test upload"
            def form = $('#myForm')

            form.myFile = f.absolutePath
            $('#input1').click()

        then:"The file is uploaded"
            $('p').text() == 'Test upload'

    }

    void "Test file upload parameters"() {
        when:"When go to an upload page"
        go "/upload/index"

        def f = File.createTempFile("uploadtest", "txt")
        f.deleteOnExit()
        f.text = "Test upload"
        def form = $('#myForm2')

        form.myFile = f.absolutePath
        $('#input2').click()

        then:"The file is uploaded"
        $('p').text() == 'ok'

    }
}
