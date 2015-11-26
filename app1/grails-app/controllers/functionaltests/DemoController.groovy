package functionaltests

class DemoController {

    def show() {
        [name: 'Jeff']
    }

    def another() {
        render view:"show", model:[name: 'Jeff']
    }

    def sayHello(String actionTakenInInterceptor) {
        render "Hi There! Special Action: $actionTakenInInterceptor"
    }

    def throwCustomError() {
        throw new CustomException("Something bad")
    }    
}
