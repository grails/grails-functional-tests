package issue10964

class Test {

    String uid

    Date dateCreated
    Date lastUpdated

    static constraints = {
        uid nullable: true
    }
}
