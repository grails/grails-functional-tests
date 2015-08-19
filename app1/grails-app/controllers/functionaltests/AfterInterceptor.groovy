package functionaltests

class AfterInterceptor {

    public AfterInterceptor() {
        match controller: 'demo', action: 'show'
    }

    boolean after() {
        if(params.interceptorRendersView) {
            render view: '/fromFilter', model: [name: 'JSB']
        } else if(params.interceptorRendersText) {
            render text: 'text rendered by interceptor'
        } else if(params.interceptorRedirects) {
            redirect controller: 'demo', action: 'sayHello', params: [actionTakenInInterceptor: 'redirect']
        } else if(params.interceptorForwards) {
            forward controller: 'demo', action: 'sayHello', params: [actionTakenInInterceptor: 'forward']
        } else if(params.interceptorChains) {
            chain controller: 'demo', action: 'sayHello', params: [actionTakenInInterceptor: 'chain']
        } else {
            render 'the after interceptor rendered this'
        }
        false
    }
}
