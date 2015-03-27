package functionaltests

import static grails.async.Promises.*

class AsyncController {

    def test() {
        task {
            sleep 500
            render "Hello"
        }
    }
}
