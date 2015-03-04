package functionaltests

class ForwardingController {

    def one() {
        forward action:"next"
    }

    def two() {
        forward controller:"forwarding", action:"next"
    }

    def three() {
        forward controller:"forwarding", action:"next", params:[param1:'test']
    }

    def next() {
        render "Forward Destination. Params: ${params.param1 ?: ''}"
    }
}
