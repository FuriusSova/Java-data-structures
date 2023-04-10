package department;

public class InvalidIDException extends Exception {
    public InvalidIDException(){
        super();
    }

    public InvalidIDException(String message){
        super(message);
    };
}
