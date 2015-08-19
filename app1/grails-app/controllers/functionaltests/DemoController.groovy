package functionaltests

class DemoController {

    def show() {
        [name: 'Jeff']
    }

    def sayHello() {
        render 'Hi There!'
    }
}
