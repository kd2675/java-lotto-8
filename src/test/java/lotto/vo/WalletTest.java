package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class WalletTest {
    @DisplayName("지갑에서 금액을 지출한다")
    @Test
    void spend() {
        // given
        Wallet wallet = new Wallet(10000);
        int amount = 1000;

        // when
        wallet.spend(amount);

        // then
        assertThat(wallet.getMoney()).isEqualTo(9000);
    }

    @DisplayName("잔액보다 많은 금액을 지출하면 예외가 발생한다")
    @Test
    void spendMoreThanBalance() {
        // given
        Wallet wallet = new Wallet(5000);
        int amount = 10000;

        // when & then
        assertThatThrownBy(() -> wallet.spend(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잔액이 부족합니다");
    }

    @DisplayName("지갑에 로또를 추가한다")
    @Test
    void addLotto() {
        // given
        Wallet wallet = new Wallet(10000);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        wallet.addLotto(lotto);

        // then
        assertThat(wallet.getLottos()).hasSize(1);
        assertThat(wallet.getLottoCount()).isEqualTo(1);
    }

    @DisplayName("구매한 로또 개수를 확인한다")
    @Test
    void getLottoCount() {
        // given
        Wallet wallet = new Wallet(10000);
        wallet.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        wallet.addLotto(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        // when
        int count = wallet.getLottoCount();

        // then
        assertThat(count).isEqualTo(2);
    }

    @DisplayName("지출한 총 금액을 계산한다")
    @Test
    void getSpentMoney() {
        // given
        Wallet wallet = new Wallet(10000);
        wallet.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        wallet.addLotto(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        wallet.addLotto(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)));

        // when
        int spentMoney = wallet.getSpentMoney();

        // then
        assertThat(spentMoney).isEqualTo(3000);
    }
}