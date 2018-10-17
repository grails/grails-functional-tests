package myapp.foo

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration(applicationClass = TestApplication)
class FooIntegrationSpec extends Specification {

	void "test custom integration test application class"() {
		expect:
		true
	}

}
