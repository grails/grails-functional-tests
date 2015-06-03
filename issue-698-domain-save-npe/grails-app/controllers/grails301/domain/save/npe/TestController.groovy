package grails301.domain.save.npe

import grails.transaction.Transactional

@Transactional
class TestController {

    def index() {
        def d = new Book()
        d.validate()
        d.save(flush: true)
        render "OK: ${d.class}: ${d.errors}"
    }
}
