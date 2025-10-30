package lotto.service;

import lotto.io.Input;
import lotto.io.Output;
import lotto.vo.PurchaseAmount;
import lotto.vo.Wallet;

public class InputService {
    public Wallet getPrice() {
        int purchaseAmount = inputPurchaseAmount();
        Wallet wallet = new Wallet(purchaseAmount);

        return wallet;
    }

    private int inputPurchaseAmount() {
        try {
            String input = Input.inputPurchaseAmount();

            return new PurchaseAmount(input).getPrice();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e);

            return inputPurchaseAmount();
        }
    }
}
