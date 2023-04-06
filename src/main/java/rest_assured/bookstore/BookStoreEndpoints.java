package rest_assured.bookstore;

public enum BookStoreEndpoints {

  AUTHORIZED("/Account/V1/Authorized"),
  GENERATE_TOKEN("/Account/v1/GenerateToken");

  BookStoreEndpoints(String value) {
    this.value = value;
  }

  private String value;

  public String getValue() {
    return value;
  }
}
