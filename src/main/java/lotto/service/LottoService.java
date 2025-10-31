package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.Output;
import lotto.vo.Item;
import lotto.vo.Lotto;
import lotto.vo.Wallet;

import java.util.List;

public class LottoService {
    /**********************************************************************************************
     * @Method 설명 : 로또구매 - 복수
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    public void buyLottos(Wallet wallet) {
        int money = wallet.getMoney();
        int price = Item.LOTTO.getPrice();

        for (int i = 0; i < money / price; i++) {
            buyLotto(wallet);
        }

        Output.printPurchaseResult(wallet);
    }

    /**********************************************************************************************
     * @Method 설명 : 로또구매 - 단수
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    private void buyLotto(Wallet wallet) {
        Lotto lotto = generateLotto();
        wallet.spend(Item.LOTTO.getPrice());
        wallet.addLotto(lotto);
    }

    /**********************************************************************************************
     * @Method 설명 : 랜덤 로또 번호 생성
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }
}