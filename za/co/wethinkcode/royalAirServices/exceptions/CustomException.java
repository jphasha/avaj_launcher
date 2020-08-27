package za.co.wethinkcode.royalAirServices.exceptions;

public class CustomException extends Exception {
    final static long serialVersionUID = 0;
    public CustomException(String reason, String statement) {
        super(reason + ": " + statement);
    }

    public CustomException(String reason, String statement, Throwable cause) {
        super(reason + ": " + statement, cause);
    }
}