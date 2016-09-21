package functionaltests.gsp

class GroovyServerPagesController {

    def html() {}

    def renderHTML() {
        render view: 'html'
    }

    def json() {}

    def renderJSON() {
        render view: 'json'
    }

    def markdown() {}

    def renderMarkdown() {
        render view: 'markdown'
    }

    def xml() {}

    def renderXML() {
        render view: 'xml'
    }

    def svg() {}

    def renderSVG() {
        render view: 'svg'
    }
}