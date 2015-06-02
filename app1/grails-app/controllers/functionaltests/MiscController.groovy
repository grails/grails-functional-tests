package functionaltests

class MiscController {

    def actionWhichReturnsNull() {
        null
    }

    def actionWhichReturnsMap() {
        [:]
    }

    def interceptedByInterceptor() {
    	// no op
    }
}
