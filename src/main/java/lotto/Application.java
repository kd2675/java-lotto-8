package lotto;

import lotto.controller.LottoController;
import lotto.service.InputServiceImpl;
import lotto.service.LottoService;
import lotto.service.WinningService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(
                new InputServiceImpl(),
                new LottoService(),
                new WinningService()
        ).start();
    }
}
