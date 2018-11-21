package functionaltests

import geb.spock.*
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.*

/**
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
