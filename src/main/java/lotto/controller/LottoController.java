package lotto.controller;

import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.vo.Wallet;

public class LottoController {
    private final InputService inputService;
    private final LottoService lottoService;

    public LottoController(InputService inputService, LottoService lottoService) {
        this.inputService = inputService;
        this.lottoService = lottoService;
    }

    public void start() {
        // TODO: 구입 금액 입력
        Wallet wallet = inputService.getPrice();

        // TODO: 로또구매
        lottoService.buyLottos(wallet);

        // TODO: 당첨번호 입력

        // TODO: 보너스 번호 입력

        // TODO: 당첨 확인 및 수익률 계산

    }
}
