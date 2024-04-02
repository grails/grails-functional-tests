package myapp.foo

import grails.artefact.Artefact
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

@Artefact('Application')
class TestApplication extends GrailsAutoConfiguration {

	static void main(String[] args) {
		GrailsApp.run(TestApplication, args)
	}

	Collection<String> packageNames() {
		super.packageNames()
	}
}