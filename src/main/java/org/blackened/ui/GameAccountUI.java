package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class GameAccountUI extends ConsoleUI {

    private final GameSession session;

    public GameAccountUI(View view, ConsoleInput consoleInput, List<MenuAction> actions, GameSession session) {
        super(view, consoleInput, actions);
        this.session = session;
    }

    /// ACCOUNT UI НЕ ЗНАЕТ ОНЛАЙН ИЛИ ОФФЛАЙН ИГРА!!! ОН СОВЕРШАЕТ СВОИ ОБЫЧНЫЕ ДЕЙСТВИЯ ОБРАЩАЯСЬ К СЕССИИ ЗА ИНФОЙ

    @Override
    public UIResponse execute() {
        setRunning(true);
        UIResponse response = null;

        var size = session.getHeroesListSize();

        while (isRunning()) {

            getView().renderMenu(getActions(), GameMessages.ACCOUNT_LABEL);

            if (size == 0) {
                getView().render(GameMessages.YOUR_HEROES_LIST_IS_EMPTY);
            } else {
                getView().render(GameMessages.YOUR_HEROES_LIST, size);
            }

            String input = getConsoleInput().getValidLine();

            if (input.equals("b")) {
                response = UIResponse.BACK;
                return  response;
            }

            int numericInput = getConsoleInput().getNumberEqualsPlayerInput(getActions(), input);
            int index = numericInput - 1;

            if (numericInput <= getActions().size()) {
                MenuAction action = getActions().get(index);
                ActionResult result = action.execute();
                response = resultHandler(result, index);

                if (response != null) {
                    return response;
                }
            } else {
                getView().render(GameMessages.HELL_ERROR);
            }

        }
        return response;
    }

    @Override
    protected UIResponse resultHandler(ActionResult result, int index) {
        UIResponse response = null;

        switch (result) {
            case SUCCESS -> {
                response = UIResponse.RUN_SELECT_CHALLENGE;
            }
            case CONTINUE -> {}
            case BACK -> {
                response = UIResponse.BACK;
            }
            default -> {
                getView().render(GameMessages.HELL_ERROR);
            }
        }

        return response;
    }


}
