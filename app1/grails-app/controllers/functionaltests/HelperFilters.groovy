package functionaltests

class HelperFilters {

    def filters = {
        misFilters(controller: 'misc', action: 'hello') {
            before  = {
                params.helperBeforeFilterRan = 'yes'
            }
            after = { Map model ->
                model.helperMessage = 'This Message Came From The After Filter'
            }
        }
    }
}
