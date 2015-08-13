package functionaltests

class AfterInterceptor {

    public AfterInterceptor() {
        match controller: 'demo', action: 'show'
    }

    boolean after() {
        render 'the after interceptor rendered this'
        false
    }
}
