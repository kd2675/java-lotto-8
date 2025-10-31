package lotto.vo;

public class WinningAndBonusNumber {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningAndBonusNumber(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        return winningNumber.countMatch(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return bonusNumber.match(lotto);
    }
}