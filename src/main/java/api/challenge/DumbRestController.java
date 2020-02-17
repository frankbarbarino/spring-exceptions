package api.challenge;

import api.challenge.model.ErrorResponseRuntimeException;
import api.challenge.model.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class DumbRestController {

  @Autowired
  DumbService dumbService;

  @RequestMapping(value = "/ok", method = (RequestMethod.GET))
  public StockDto getStockDto() throws ParseException {
    return dumbService.getStockDto();
  }

  @RequestMapping(value = "/403", method = (RequestMethod.GET))
  public StockDto throwFourHundred() {
    ErrorResponseRuntimeException error = new ErrorResponseRuntimeException();
    error.setReason("unauthorized");
    error.setPath("path");
    error.setStackTrace(new Exception().getStackTrace());
    throw error;
  }

  @RequestMapping(value = "/500", method = (RequestMethod.GET))
  public StockDto notAcceptable() throws Exception {
    throw new Exception("Internal Server ERror");
  }

  @RequestMapping(value = "/406", method = (RequestMethod.GET))
  public StockDto badRequest() throws Exception {
      throw new IllegalArgumentException("bad request");
  }

}
