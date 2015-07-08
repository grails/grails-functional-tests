package functionaltests

import org.springframework.beans.factory.annotation.*

class MiscController {

	@Value('${foo.bar}')
	String testProperty

    def actionWhichReturnsNull() {
        null
    }

    def actionWhichReturnsMap() {
        [:]
    }

    def interceptedByInterceptor() {
    	// no op
    }

    def placeHolderConfig() {
    	def config = grailsApplication.config

    	render "[${config.foo.bar} ${config.getProperty('foo.bar')} ${testProperty}]"
    }
}
