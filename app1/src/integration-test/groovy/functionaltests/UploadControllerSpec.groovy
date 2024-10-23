package functionaltests


import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration
import spock.lang.PendingFeature

/**
 */
@Integration(applicationClass = Application)
class UploadControllerSpec extends ContainerGebSpec {

    @PendingFeature(reason='text is null')
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

    @PendingFeature(reason='text is null')
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
