package gorm

import grails.transaction.Transactional

class UserService {

    List bycity(Long id) {
        User.where { city.id == id }.list()
    }
}
