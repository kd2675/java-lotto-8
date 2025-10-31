package lotto.service;

import lotto.vo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningServiceTest {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(10, winningNumber);
    }

    @DisplayName("3개 일치한 로또의 당첨 통계를 확인한다 (5등)")
    @Test
    void checkWinningFifthRank() {
        // given
        WinningService winningService = new WinningService();
        Wallet wallet = new Wallet(1000);
        wallet.addLotto(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

        // when
        WinningStat result = winningService.checkWinning(wallet, winningNumber, bonusNumber);

        // then
        assertThat(result.getCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getTotalPrize()).isEqualTo(5000);
    }

    @DisplayName("5개 일치 + 보너스 일치한 로또의 당첨 통계를 확인한다 (2등)")
    @Test
    void checkWinningSecondRank() {
        // given
        WinningService winningService = new WinningService();
        Wallet wallet = new Wallet(1000);
        wallet.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

        // when
        WinningStat result = winningService.checkWinning(wallet, winningNumber, bonusNumber);

        // then
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getTotalPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("6개 일치한 로또의 당첨 통계를 확인한다 (1등)")
    @Test
    void checkWinningFirstRank() {
        // given
        WinningService winningService = new WinningService();
        Wallet wallet = new Wallet(1000);
        wallet.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when
        WinningStat result = winningService.checkWinning(wallet, winningNumber, bonusNumber);

        // then
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getTotalPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("당첨되지 않은 로또의 통계를 확인한다")
    @Test
    void checkWinningNoRank() {
        // given
        WinningService winningService = new WinningService();
        Wallet wallet = new Wallet(1000);
        wallet.addLotto(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        // when
        WinningStat result = winningService.checkWinning(wallet, winningNumber, new BonusNumber(13, winningNumber));

        // then
        assertThat(result.getTotalPrize()).isEqualTo(0);
    }
}