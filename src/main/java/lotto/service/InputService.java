package lotto.service;

import lotto.vo.BonusNumber;
import lotto.vo.Wallet;
import lotto.vo.WinningNumber;

public interface InputService {
    /**
     * @Method 설명 : 구입 금액 입력
     * @작성일 : 2025. 10. 31.
     * @작성자 : 김도영
     * @변경이력 : 
     **/
    int inputPurchaseAmount();

    /**
     * @Method 설명 : 당첨 번호 입력
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **/
    WinningNumber inputWinningNumber();

    /**
     * @Method 설명 : 보너스 번호 입력
     * @작성일 : 2025. 10. 30.
     * @작성자 : 김도영
     * @변경이력 :
     **/
    BonusNumber inputBonusNumber(WinningNumber winningNumber);
}
