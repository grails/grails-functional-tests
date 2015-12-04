package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

import spock.lang.*
import geb.spock.*

import org.springframework.context.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class i18nSpec extends GebSpec {

    @Autowired
    MessageSource messageSource

    void "Test i18n messages from plugins"() {
      expect:"That plugin messages can be resolved"
      messageSource.getMessage('default.home.label', [] as Object[], Locale.ENGLISH) == 'Home'
      messageSource.getMessage('my.plugin.message', [] as Object[], Locale.ENGLISH) == 'From a Plugin'
      messageSource.getMessage('my.plugin.message', [] as Object[], Locale.US) == 'From a US Plugin'
    }
}
