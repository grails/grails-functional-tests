package functionaltests.sitemesh

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

import spock.lang.*
import geb.spock.*

@Integration
@Rollback
class LayoutWithTemplateSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that a layout is not applied to a template rendered by a controller by default"() {
        when:"The home page is visited"
            go '/layoutTemplate/index'
        then:"The title is correct"
            title == "Welcome to My Partial"
    }
}
