package functionaltests

class AfterInterceptor {

    public AfterInterceptor() {
        match controller: 'demo', action: 'show'
    }

    boolean after() {
        if(params.interceptorRendersView) {
            render view: '/fromFilter', model: [name: 'JSB']
        } else if(params.interceptorRendersText) {
            render text: '<html><body>text rendered by interceptor</body></html>'
        } else {
            render '<html><body>the after interceptor rendered this</body></html>'
        }
        false
    }
}
