import loadfirst.LoadfirstGrailsPlugin

beans {
    
    myBean {
        name = "Brian"
    }
}
myPlugins {
    loadFirstPluginNameBean = LoadfirstGrailsPlugin.name
}
foo {
    baz = 1
}
foo.bax = 2
