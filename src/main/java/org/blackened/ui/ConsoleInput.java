package org.blackened.ui;

import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;
import java.util.regex.Pattern;

public class ConsoleInput {

    private final View view;

    private static final Pattern INPUT_PATTERN = Pattern.compile("^[Bb0-9]$");
    private static final Pattern ACCOUNT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,15}$");

    public ConsoleInput(View view) {
        this.view = view;
    }

    public String getValidLineForLogIn() {
        String info = getLine();

        while (!isInputValidForLogIn(info)) {
            if (info.length() < 6) {
                view.render(GameMessages.PLEASE_TRY_AGAIN_WITH_MORE_SYMBOLS);
            } else {
                view.render(GameMessages.PLEASE_TRY_AGAIN);
            }
            info = getLine();
        }
        return info;
    }

    public String getValidLine() {
        String line = getLine();

        while (!isInputValid(line)) {
            view.render(GameMessages.PLEASE_TRY_AGAIN);
            line = getLine();
        }
        return line;
    }

    public int getNumberEqualsPlayerInput(List<?> src, String input) {

        int inputNumeric = parse(input);

        while (inputNumeric > src.size()) {
            view.render(GameMessages.PLEASE_TRY_AGAIN);
            inputNumeric = parse(getLine());
        }
        return inputNumeric;
    }

    public boolean isLineForExit(String login) {

        return login.equals("b");
    }

    private int parse(String line) {
        int numeric = 0;
        try {
            numeric = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            view.render(GameMessages.HELL_ERROR);
        }
        return numeric;
    }

    private String getLine() {
        return view.getLine();
    }

    private boolean isInputValidForLogIn(String accountName) {
        return ACCOUNT_NAME_PATTERN.matcher(accountName).matches();
    }

    private boolean isInputValid(String input) {
        return INPUT_PATTERN.matcher(input).matches();
    }
}
