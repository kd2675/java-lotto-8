package lotto.vo;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private int money;
    private final List<Lotto> lottos;

    public Wallet(int money) {
        this.money = money;
        this.lottos = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void spend(int amount) {
        validateEnoughMoney(amount);
        this.money -= amount;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public int getSpentMoney() {
        return lottos.size() * Item.LOTTO.getPrice();
    }

    private void validateEnoughMoney(int amount) {
        if (money < amount) {
            throw new IllegalArgumentException("[ERROR] 잔액이 부족합니다.");
        }
    }
}