package functionaltests

import grails.converters.JSON

class BazController {
    def index() {
        render Baz.list() as JSON
    }

    def create() {}

    def save() {
        def baz = new Baz(name: params.name).save(flush: true)
        redirect action: "index", params: [id: baz?.id]
    }
}
