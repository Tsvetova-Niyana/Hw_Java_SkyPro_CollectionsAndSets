package sky.pro.java.collectionsandsets.exeption;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectSurnameException extends RuntimeException {
    public IncorrectSurnameException(String surname) {
        super(surname);
    }
}
