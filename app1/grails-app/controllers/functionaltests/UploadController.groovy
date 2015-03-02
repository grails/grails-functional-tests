package functionaltests

class UploadController {

    def index() {
        render view:"index"
    }

    def upload() {
        def contents = new String( request.getFile("myFile").bytes, 'UTF-8' )

        render text: "<p>$contents</p>", contentType:"text/html"
    }
}
