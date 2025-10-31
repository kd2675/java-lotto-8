package lotto.service;

import lotto.io.Input;
import lotto.io.Output;
import lotto.vo.BonusNumber;
import lotto.vo.PurchaseAmount;
import lotto.vo.Wallet;
import lotto.vo.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputServiceImpl implements InputService {
    @Override
    public int inputPurchaseAmount() {
        try {
            String input = Input.inputPurchaseAmount();

            return new PurchaseAmount(input).getPrice();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e);

            return inputPurchaseAmount();
        }
    }

    @Override
    public WinningNumber inputWinningNumber() {
        try {
            String input = Input.inputWinningNumber();
            List<Integer> numbers = parseNumbers(input);

            return new WinningNumber(numbers);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e);

            return inputWinningNumber();
        }
    }

    @Override
    public BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        try {
            String input = Input.inputBonusNumber();
            int number = Integer.parseInt(input);

            return new BonusNumber(number, winningNumber);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e);

            return inputBonusNumber(winningNumber);
        }
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}