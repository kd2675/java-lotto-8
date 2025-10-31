package lotto.vo;

public enum Item {
    LOTTO(1_000);

    private int price;

    Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}