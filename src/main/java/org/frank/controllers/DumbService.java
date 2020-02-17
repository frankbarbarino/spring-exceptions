package org.frank.controllers;

import org.frank.model.StockDto;
import org.springframework.stereotype.Controller;

@Controller
public class DumbService {

  public StockDto getStockDto() {
    return new StockDto("price", "pe", "name", "ticker");
  }

}
