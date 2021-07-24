package issue10964

import grails.gorm.transactions.Transactional

class TestService {

    @Transactional
    Test save() {
        def t = new Test()
        t.save()

        t.uid = "foo"
        t.save()

        return t
    }

    @Transactional
    Test update(Long id) {
        def t = Test.get(id)
        t.uid = "bar"
        t.save()

        return t
    }
}
