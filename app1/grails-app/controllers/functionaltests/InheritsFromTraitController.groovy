package functionaltests

import grails.web.Action
import grails.web.RequestParameter

/**
 * Created by jameskleeh on 3/31/17.
 */
class InheritsFromTraitController implements ControllerTrait {

    def index(Long id, @RequestParameter('foo') Long x) {
        render(text: "id=$id,x=$x")
    }

}
