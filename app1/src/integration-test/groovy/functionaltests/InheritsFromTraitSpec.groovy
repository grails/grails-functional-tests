package functionaltests

import geb.spock.GebSpec

/**
 * Created by jameskleeh on 3/31/17.
 */
class InheritsFromTraitSpec extends GebSpec {

    void "test index"() {
        when:
        go '/inheritsFromTrait/index/1?foo=2'

        then:
        $('body').text() == "id=1,x=2"
    }

    void "test show"() {
        when:
        go '/inheritsFromTrait/show/1?foo=2'

        then:
        $('body').text() == "id=1,x=2"
    }
}
