package gorm

class User {

    String name
    static belongsTo = [city:City]

    static constraints = {
    }
}
