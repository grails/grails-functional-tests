package functionaltests

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Issue

@Integration
@Rollback
class RedirectWithAndWithoutParamsFunctionalSpec extends GebSpec {

    @Issue('grails-core-#10965')
    void 'Params are not added to the url after a redirect even if they are passed to the redirect'() {
        when: 'creating and object'
        go "/baz/create"
        $('input', name:'name').value('foo')
        $('input', type:'submit').click()

        then: 'the params are not added to the url'
        !currentUrl.contains('?name=foo')
        driver.pageSource.contains('"id":')
        driver.pageSource.contains('"name":"foo"')
    }
}
