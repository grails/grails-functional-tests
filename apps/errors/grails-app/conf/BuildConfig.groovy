grails.project.work.dir = "target/work"

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    useOrigin true
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenRepo "http://repo.grails.org/grails/core"
        mavenCentral()
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'

        runtime 'org.hsqldb:hsqldb:2.3.2'
        test( 'commons-codec:commons-codec:1.6') {
            excludes 'xml-apis', 'xerces'
        }
        test 'net.sourceforge.nekohtml:nekohtml:1.9.18'
        test 'net.sourceforge.htmlunit:htmlunit:2.12'
        test 'net.sourceforge.htmlunit:htmlunit-core-js:2.12'
        test( 'net.sourceforge.cssparser:cssparser:0.9.7') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'xalan:serializer:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'xalan:xalan:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
/*
        test( 'xercesImpl:xercesImpl:2.9.1') {
            excludes 'xml-apis'
        }
*/

        test( 'org.w3c.css:sac:1.3') {
            excludes 'xml-apis', 'xerces'
        }
    }
    plugins {
        runtime "${System.getProperty('hibernatePluginVersion',':hibernate:3.6.10.19')}"
        build ":tomcat:7.0.55.2"
        test ':functional-test:2.0.0'
        compile ':scaffolding:2.1.2'
    }
}
