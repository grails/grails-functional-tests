package functionaltests

import org.grails.exceptions.*

class ErrorsController {
    def throwErrorInInterceptor() {
        // never hit
        assert false
    }
    def throwCustomError() {
        throw new CustomException("Something bad")
    }

    def throwGeneralError() {
        throw new IllegalStateException("Something went wrong")
    }

    def customError(CustomException exception) {
        render "<html><body>Message = $exception.message</body><html>"
    }

    def customErrorHandler() {
        def cause = ExceptionUtils.getRootCause(request.exception)
        render "<html><body>Message = $cause.message</body><html>"   
    }

    def notFound() {
    	render "Page Not Found"
    }

    def notFoundTest() {
    	render status:404
    }
}
