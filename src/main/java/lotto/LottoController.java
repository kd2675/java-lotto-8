package lotto;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        Wallet wallet = new Wallet(purchaseAmount);

        // TODO: 로또구매
        lottoService.buyLottos(wallet);
        printPurchaseResult(wallet);
        
        // TODO: 당첨 확인 및 수익률 계산

    }

    private int inputPurchaseAmount() {
        try {
            String input = Input.input(Input.INPUT_MONEY_MESSAGE);
            return new LottoPrice(Integer.parseInt(input)).getPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private void printPurchaseResult(Wallet wallet) {
        System.out.println(String.format(Output.PURCHASE_COUNT_FORMAT, wallet.getLottoCount()));
        for (Lotto lotto : wallet.getLottos()) {
            System.out.println(lotto);
        }
    }
}
