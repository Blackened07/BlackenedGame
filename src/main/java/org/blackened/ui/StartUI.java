package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class StartUI extends ConsoleUI {

    public StartUI(View view, List<MenuAction> actions) {
        super(view, actions);
    }

    @Override
    public UIResponse execute() {
        setRunning(true);
        getView().renderMenu(getActions(), GameMessages.MAIN_MENU_LABEL);
        getView().render(GameMessages.PROVIDER);

        UIResponse response = null;

        while (isRunning()) {
            String input = getView().getLine();

            int numericInput = getNumberEqualsPlayerInput(getActions(), input);
            int index = numericInput - 1;

            if (numericInput <= getActions().size()) {
                MenuAction action = getActions().get(index);
                ActionResult result = action.execute();
                response = resultHandler(result, index);
                return response;// КОТОРЫЙ ВЕРНЁТ ЕНАМ С ТЕМ ЧТО ДЕЛАТЬ ДАЛЕЕ (CONTINUE, EXIT и тд)
            } else  {
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
                if (index == 0) {
                    setRunning(false);
                    response = UIResponse.RUN_ACCOUNT;
                }
                if (index == 1) {
                    setRunning(false);
                    response = UIResponse.RUN_ONLINE;
                }
            }
            case CONTINUE -> {
                // В ЭКШНЕ ДОЛЖНА БЫТЬ КНОПКА НАЗАД.. НАПРИМЕР В ОФФЛАЙН РЕГИСТРАЦИИ ЕСЛИ РЕШИЛИ ПОИГРАТЬ В ОНЛАЙН -Ю ВОЗВРАЩАЕМСЯ В СТАРТ МЕНЮ
            }
            case EXIT-> {
                response = UIResponse.EXIT;
            }
            default -> {
                getView().render(GameMessages.HELL_ERROR);
            }
        }

        return response;
    }
}
