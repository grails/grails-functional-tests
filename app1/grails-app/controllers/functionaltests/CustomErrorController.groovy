package functionaltests

import groovy.transform.CompileStatic

@CompileStatic
class CustomErrorController {

    def index() {
        throw new CustomErrorException("custom error")
    }

    def handleError() {
        render "id:${params.id ?: ''} name:${params.name ?: ''} color:${params.color ?: ''} format:${params.format ?: ''}"
    }
}