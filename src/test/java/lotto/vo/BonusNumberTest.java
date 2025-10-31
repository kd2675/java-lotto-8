package lotto.vo;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호는 1-45 사이 숫자 정상입력")
    @Test
    void bonusNumberRange() {
        // given
        int inputBonusNumber = 7;

        // when
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumber);

        // then
        assertThat(bonusNumber).isNotNull();
    }

    @DisplayName("보너스 번호가 1-45 사이 숫자를 벗어나면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, -1000, 1000})
    void bonusNumberRangeError(int value) {
        //given

        //when
        ThrowableAssert.ThrowingCallable executable = () -> new BonusNumber(value, winningNumber);

        //then
        assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void bonusNumberDuplError(){
        int inputBonusNumber = 1;

        ThrowableAssert.ThrowingCallable executable = () -> new BonusNumber(inputBonusNumber, winningNumber);

        assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 true를 반환한다")
    @Test
    void matchBonusNumberTrue() {
        // given
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Lotto lotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when
        boolean result = bonusNumber.match(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않으면 false를 반환한다")
    @Test
    void matchBonusNumberFalse() {
        // given
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        // when
        boolean result = bonusNumber.match(lotto);

        // then
        assertThat(result).isFalse();
    }
}