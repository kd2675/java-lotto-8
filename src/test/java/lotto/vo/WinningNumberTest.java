package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {
    @DisplayName("6개의 번호로 당첨 번호를 생성한다")
    @Test
    void createWinningNumber() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        WinningNumber winningNumber = new WinningNumber(numbers);

        // then
        assertThat(winningNumber).isNotNull();
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void createWinningNumberWithInvalidSize() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1-45 범위를 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 50})
    void createWinningNumberWithOutOfRange(int invalidNumber) {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, invalidNumber);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void createWinningNumberWithDuplicate() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 null이 포함되면 예외가 발생한다")
    @Test
    void createWinningNumberWithNull() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, null);

        // when & then
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 일치하는 개수를 반환한다 - 3개 일치")
    @Test
    void countMatch() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = winningNumber.countMatch(lotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또 번호와 일치하는 개수를 반환한다 - 전체 일치")
    @Test
    void countMatchAll() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        int matchCount = winningNumber.countMatch(lotto);

        // then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또 번호와 일치하는 개수를 반환한다 - 전체 불일치")
    @Test
    void countMatchNone() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when
        int matchCount = winningNumber.countMatch(lotto);

        // then
        assertThat(matchCount).isEqualTo(0);
    }
}