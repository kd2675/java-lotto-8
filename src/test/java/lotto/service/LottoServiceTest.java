package lotto.service;

import lotto.vo.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @DisplayName("구매 금액에 따라 정확한 개수의 로또를 구매한다")
    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "5000, 5",
            "8000, 8",
            "10000, 10"
    })
    void buyLottosByAmount(int money, int expectedCount) {
        // given
        LottoService lottoService = new LottoService();
        Wallet wallet = new Wallet(money);

        // when
        lottoService.buyLottos(wallet);

        // then
        assertThat(wallet.getLottoCount()).isEqualTo(expectedCount);
        assertThat(wallet.getMoney()).isEqualTo(0);
    }
}