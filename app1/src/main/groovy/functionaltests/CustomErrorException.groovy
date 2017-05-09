package functionaltests

class CustomErrorException extends RuntimeException {

    CustomErrorException() {
        super()
    }

    CustomErrorException(String message) {
        super(message)
    }

}
