package functionaltests
class InspectConfigController {

    def showPropertyValues() {
        def cfg = grailsApplication.config.grails11951
        def prop1 = cfg.prop1
        def prop2 = cfg.prop2
        def prop3 = cfg.prop3
        [prop1: prop1, prop2: prop2, prop3: prop3]
    }
}
