package lotto.controller;

import lotto.io.Output;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.vo.BonusNumber;
import lotto.vo.Wallet;
import lotto.vo.WinningNumber;

public class LottoController {
    private final InputService inputService;
    private final LottoService lottoService;
    private final WinningService winningService;

    public LottoController(InputService inputService, LottoService lottoService, WinningService winningService) {
        this.inputService = inputService;
        this.lottoService = lottoService;
        this.winningService = winningService;
    }

    public void start() {
        try {
            // TODO: 구입 금액 입력
            int purchaseAmount = inputService.inputPurchaseAmount();
            Wallet wallet = new Wallet(purchaseAmount);

            // TODO: 로또구매
            lottoService.buyLottos(wallet);

            // TODO: 당첨번호 입력
            WinningNumber winningNumber = inputService.inputWinningNumber();

            // TODO: 보너스 번호 입력
            BonusNumber bonusNumber = inputService.inputBonusNumber(winningNumber);

            // TODO: 당첨 확인 및 수익률 계산
            winningService.winningLottos(wallet, winningNumber, bonusNumber);
        } catch (Exception e) {
            Output.printErrorMessage(e);

            throw e;
        }
    }
}