package lotto;

import lotto.controller.LottoController;
import lotto.service.InputService;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(
                new InputService(),
                new LottoService()
        ).start();
    }
}
