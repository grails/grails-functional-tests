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
        } else {
            render 'the after interceptor rendered this'
        }
        false
    }
}
