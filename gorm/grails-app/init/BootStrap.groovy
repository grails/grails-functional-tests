import gorm.*

class BootStrap {

    def init = { servletContext ->
        def b = new Book(title:"The Stand")

        // GRAILS-12080
        assert b?.testService

        b.save(flush:true)
    }
    def destroy = {
    }
}
