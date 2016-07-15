package gorm


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass = Application)
@Rollback
class AbstractParentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that persisting a domain class with an abstract parent works"() {
        when:"An entity with an abstract parent is persisted"
            new ChildA(name:"A", ageA:10).save(flush:true)
            new ChildB(name:"B", ageB:15).save(flush:true)

        then:"The result is correct"
            AbstractParent.count() == 2
    }
}
