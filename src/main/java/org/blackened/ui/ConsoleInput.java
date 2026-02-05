package org.blackened.ui;

import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;
import java.util.regex.Pattern;

public class ConsoleInput {

    private final View view;

    private final Pattern INPUT_PATTERN = Pattern.compile("^[Bb0-9]$");
    private final Pattern ACCOUNT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,15}$");

    public ConsoleInput(View view) {

        this.view = view;
    }

    protected View getView() {
        return view;
    }

    protected String getValidLineForLogIn() {
        String info = getLine();

        while (!isInputValidForLogIn(info)) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            info = getLine();
        }
        return info;
    }

    protected String getValidLine() {
        String line = getLine();

        while (!isInputValid(line)) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            line = getLine();
        }
        return line;
    }

    protected int getNumberEqualsPlayerInput(List<?> src, String input) {

        int inputNumeric = parse(input);

        while (inputNumeric > src.size()) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            inputNumeric = parse(getLine());
        }
        return inputNumeric;
    }

    protected boolean isLineForExit(String login) {
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
