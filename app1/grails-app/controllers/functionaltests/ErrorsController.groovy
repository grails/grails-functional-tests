package functionaltests

class ErrorsController {

    def throwCustomError() {
        throw new CustomException("Something bad")
    }

    def throwGeneralError() {
        throw new IllegalStateException("Something went wrong")
    }

    def customError(CustomException exception) {
        render "Message = $exception.message"
    }

    def notFound() {
    	render "Page Not Found"
    }

    def notFoundTest() {
    	render status:404
    }
}
