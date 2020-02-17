package api.challenge.model;

import java.util.Objects;

public class StockDto {
  String price;
  String pe;
  String name;
  String ticker;

  public StockDto() {
  }

  public StockDto(String price, String pe, String name, String ticker) {
    this.price = price;
    this.pe = pe;
    this.name = name;
    this.ticker = ticker;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getPe() {
    return pe;
  }

  public void setPe(String pe) {
    this.pe = pe;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StockDto stock = (StockDto) o;
    return Objects.equals(price, stock.price) &&
        Objects.equals(pe, stock.pe) &&
        Objects.equals(name, stock.name) &&
        ticker.equals(stock.ticker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, pe, name, ticker);
  }

  @Override
  public String toString() {
    return "Stock{" +
        "price='" + price + '\'' +
        ", pe='" + pe + '\'' +
        ", name='" + name + '\'' +
        ", ticker='" + ticker + '\'' +
        '}';
  }
}
