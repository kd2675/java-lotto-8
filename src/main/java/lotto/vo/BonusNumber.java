package lotto.vo;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, WinningNumber winningNumber) {
        validateRange(number);
        validateDuplicate(number, winningNumber);
        this.number = number;
    }

    public boolean match(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1-45 사이 숫자이어야합니다.");
        }
    }

    private void validateDuplicate(int number, WinningNumber winningNumber) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}