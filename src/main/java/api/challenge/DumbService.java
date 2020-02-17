package api.challenge;

import api.challenge.model.ErrorResponseBody;
import api.challenge.model.ErrorResponseRuntimeException;
import api.challenge.model.StockDto;
import org.springframework.stereotype.Controller;

@Controller
public class DumbService {

  public StockDto getStockDto() {
    return new StockDto("price", "pe", "name", "ticker");
  }

}
