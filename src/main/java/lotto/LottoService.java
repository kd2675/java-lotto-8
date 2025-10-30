package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    public void buyLottos(Wallet wallet) {
        int money = wallet.getMoney();
        int price = Item.LOTTO.getPrice();

        for (int i = 0; i < money / price; i++) {
            buyLotto(wallet);
        }
    }

    private void buyLotto(Wallet wallet) {
        Lotto lotto = generateLotto();
        wallet.spend(Item.LOTTO.getPrice());
        wallet.addLotto(lotto);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
