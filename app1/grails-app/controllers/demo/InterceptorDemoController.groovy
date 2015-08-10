package demo

class InterceptorDemoController {

    def one() {
        if(params.didUriMatchingInterceptorMatch) {
            render 'interceptor did match for the one action'
        } else {
            render 'interceptor did not match for the one action'
        }
    }

    def two() {
        if(params.didUriMatchingInterceptorMatch) {
            render 'interceptor did match for the two action'
        } else {
            render 'interceptor did not match for the two action'
        }
    }
}
