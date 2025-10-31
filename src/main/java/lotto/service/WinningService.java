package lotto.service;

import lotto.io.Output;
import lotto.vo.*;

public class WinningService {
    /**********************************************************************************************
     * @Method 설명 : 당첨번호와 보너스 번호 통합 > 번호 확인후 출력
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    public void winningLottos(Wallet wallet, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningAndBonusNumber winningAndBonusNumber = new WinningAndBonusNumber(winningNumber, bonusNumber);

        WinningStat result = checkWinning(wallet, winningAndBonusNumber);
        Output.printWinningStatistics(result, wallet.getSpentMoney());
    }

    /**********************************************************************************************
     * @Method 설명 : 지갑에 있는 모든 로또 당첨번호 확인
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    public WinningStat checkWinning(Wallet wallet, WinningAndBonusNumber winningAndBonusNumber) {
        WinningStat result = new WinningStat();

        for (Lotto lotto : wallet.getLottos()) {
            Rank rank = determineRank(lotto, winningAndBonusNumber);
            result.addRank(rank);
        }

        return result;
    }

    /**********************************************************************************************
     * @Method 설명 : 당첨번호 맞은 수와 보너스 번호 유무를 통해 등수 확인
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **********************************************************************************************/
    private Rank determineRank(Lotto lotto, WinningAndBonusNumber winningAndBonusNumber) {
        int matchCount = winningAndBonusNumber.countMatch(lotto);
        boolean matchBonus = winningAndBonusNumber.matchBonus(lotto);

        return Rank.valueOf(matchCount, matchBonus);
    }
}