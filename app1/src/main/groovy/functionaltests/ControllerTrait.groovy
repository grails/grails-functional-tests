package functionaltests

import grails.web.Action
import grails.web.Controller
import grails.web.RequestParameter

@Controller
trait ControllerTrait {

    @Action
    def show(Long id, @RequestParameter('foo') Long x) {
        render(text: "id=$id,x=$x")
    }
}
