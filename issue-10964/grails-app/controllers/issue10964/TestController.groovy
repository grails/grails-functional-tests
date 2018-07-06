package issue10964

import grails.converters.JSON

class TestController {

    TestService testService

    def save() {
        def test = testService.save()

        render test as JSON
    }

    def update(Long id) {
        def test = testService.update(id)

        render test as JSON
    }
}
