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


grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/**',             access: ['permitAll']],
        [pattern: '/**/**',          access: ['permitAll']],
        [pattern: '/**/**/**',       access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]