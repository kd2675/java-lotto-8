package lotto;

public class LottoPrice {
    private final Integer price;

    public LottoPrice(Integer price) {
        validateEmpty(price);
        validateUnit(price);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    private void validateEmpty(Integer price) {
        if (price == null) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액 에러");
        }
    }

    private void validateUnit(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위 입니다.");
        }
    }
}
