package functionaltests

class DemoController {

    def show() {
        [name: 'Jeff']
    }

    def sayHello(String actionTakenInInterceptor) {
        render "Hi There! Special Action: $actionTakenInInterceptor"
    }
}
