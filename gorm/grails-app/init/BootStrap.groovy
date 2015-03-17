import gorm.*

class BootStrap {

    def init = { servletContext ->
        new Book(title:"The Stand").save(flush:true)
    }
    def destroy = {
    }
}
