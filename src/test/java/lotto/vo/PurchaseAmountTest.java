package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {


    @DisplayName("1000원 단위가 아닌 금액이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"500", "1500", "2100", "999"})
    void createPurchaseAmountWithInvalidUnit(String amount) {
        // given & when & then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1000원 단위 입니다");
    }

    @DisplayName("숫자가 아닌 문자열이면 예외가 발생한다")
    @Test
    void createPurchaseAmountWithNonNumeric() {
        // given
        String invalidAmount = "abc";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 숫자여야 합니다");
    }

    @DisplayName("공백이 포함된 문자열이면 예외가 발생한다")
    @Test
    void createPurchaseAmountWithSpace() {
        // given
        String amountWithSpace = "1000 ";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(amountWithSpace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열이면 예외가 발생한다")
    @Test
    void createPurchaseAmountWithEmpty() {
        // given
        String emptyAmount = "";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(emptyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}