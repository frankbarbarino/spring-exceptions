package api.challenge;

import api.challenge.model.ErrorResponseBody;
import api.challenge.model.ErrorResponseRuntimeException;
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


//  @ExceptionHandler(value = Exception.class)
//  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//    // If the exception is annotated with @ResponseStatus rethrow it and let
//    // the framework handle it.
//    // AnnotationUtils is a Spring Framework utility class.
//    if (AnnotationUtils.findAnnotation
//        (e.getClass(), ResponseStatus.class) != null)
//      throw e;
//
//    // Otherwise setup and send the user to a default error-view.
//    ModelAndView mav = new ModelAndView();
//    mav.addObject("exception", e);
//    mav.addObject("url", req.getRequestURL());
//    mav.addObject("this is view", "and model");
//    // mav.setViewName();
//    return mav;
//  }

  @ExceptionHandler(value
      = { ErrorResponseRuntimeException.class })
  protected ResponseEntity<ErrorResponseBody> handleRuntime(ErrorResponseRuntimeException ex, WebRequest request) {
    // log error.
    ErrorResponseBody errorResponseBody = new ErrorResponseBody();
    errorResponseBody.setPath(ex.getPath());
    errorResponseBody.setReason(ex.getReason());
    logger.warning(errorResponseBody.toString());
    return new ResponseEntity<ErrorResponseBody>(
        errorResponseBody,
        new HttpHeaders(),
        HttpStatus.BAD_GATEWAY);
  }


  @ExceptionHandler(value
      = { Exception.class })
  protected ResponseEntity<ErrorResponseBody> handleUnexpected(Exception ex, WebRequest request) {
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
