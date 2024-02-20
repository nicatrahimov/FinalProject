package az.coders.FinalProject.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ContactNotFound.class})
    public ResponseEntity<String> contactNotFound(ContactNotFound contactNotFound) {
        return new ResponseEntity<>(contactNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {CompanyNotFound.class})
    public ResponseEntity<String> companyNotFound(CompanyNotFound companyNotFound) {
        return new ResponseEntity<>(companyNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {BadPeopleGroupName.class})
    public ResponseEntity<String>badPeopleGroupName(BadPeopleGroupName badPeopleGroupName){
        return new ResponseEntity<>(badPeopleGroupName.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<String>nullPointer(NullPointerException nullPointerException){
        return new ResponseEntity<>(nullPointerException.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ImageNotFound.class})
    public ResponseEntity<String>imageNotFound(ImageNotFound imageNotFound){
        return new ResponseEntity<>(imageNotFound.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {Base64FormatIsNotValid.class})
    public ResponseEntity<String>base64IsNotValid(Base64FormatIsNotValid base64FormatIsNotValid){
        return new ResponseEntity<>(base64FormatIsNotValid.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
