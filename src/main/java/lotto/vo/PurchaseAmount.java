package lotto.vo;

public class PurchaseAmount {
    private final Integer price;

    public PurchaseAmount(String priceStr) {
        Integer price = parseAmount(priceStr);
        validateNotNull(price);
        validateUnit(price);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    private Integer parseAmount(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateNotNull(Integer price) {
        if (price == null) {
            throw new IllegalArgumentException("로또 구입 금액 에러");
        }
    }

    private void validateUnit(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위 입니다.");
        }
    }
}