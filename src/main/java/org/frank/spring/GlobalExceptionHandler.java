package org.frank.spring;

import org.frank.model.ErrorResponseBody;
import org.frank.model.ErrorResponseRuntimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

  final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

  @ExceptionHandler(value
      = {ErrorResponseRuntimeException.class})
  protected ResponseEntity<ErrorResponseBody> handleRuntime(ErrorResponseRuntimeException ex, WebRequest request) {
    ErrorResponseBody errorResponseBody = new ErrorResponseBody();
    errorResponseBody.setPath(ex.getPath());
    // TODO: transpose Http status codes if needed
    // e.g. 400s to 503
    errorResponseBody.setReason(ex.getReason());
    logger.warning(errorResponseBody.toString());
    return new ResponseEntity<ErrorResponseBody>(
        errorResponseBody,
        new HttpHeaders(),
        HttpStatus.BAD_GATEWAY);
  }


  @ExceptionHandler(value
      = {Exception.class})
  protected ResponseEntity<ErrorResponseBody> handleUnexpected(Exception ex, WebRequest request) {
//    // If the exception is annotated with @ResponseStatus rethrow it and let
//    // the framework handle it.
//    // AnnotationUtils is a Spring Framework utility class.
//    if (AnnotationUtils.findAnnotation
//        (e.getClass(), ResponseStatus.class) != null)
//      throw e;
      ErrorResponseBody errorResponseBody = new ErrorResponseBody();
    errorResponseBody.setPath(request.getContextPath());
    errorResponseBody.setReason(ex.getMessage());
    logger.warning(errorResponseBody.toString());
    return new ResponseEntity<ErrorResponseBody>(
        errorResponseBody,
        new HttpHeaders(),
        HttpStatus.BAD_GATEWAY);
  }


}
