package functionaltests

import functionaltests.*

class BootStrap {

    def init = { servletContext ->
        Book.withTransaction {
            new Book(title:"Example Book").save(flush:true)
            assert Book.count() == 1
        }
    }
    def destroy = {
    }
}
