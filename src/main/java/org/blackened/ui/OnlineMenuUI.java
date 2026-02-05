package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class OnlineMenuUI extends ConsoleUI {

    public OnlineMenuUI(View view, List<MenuAction> actions) {
        super(view, actions);
    }

    public UIResponse execute() {
        setRunning(true);
        UIResponse response = null;

        while (isRunning()) {

            getView().renderMenu(getActions(), GameMessages.MAIN_MENU_LABEL);
            getView().render(GameMessages.REQUEST_TO_ENTER_MENU_POINT);

            while (isRunning()) {
                String input = getValidLine();

                int numericInput = getNumberEqualsPlayerInput(getActions(), input);
                int index = numericInput - 1;

                if (numericInput <= getActions().size()) {
                    MenuAction action = getActions().get(index);
                    ActionResult result = action.execute();
                    response = resultHandler(result, index);
                    if (response != null) {
                        return response;
                    }// КОТОРЫЙ ВЕРНЁТ ЕНАМ С ТЕМ ЧТО ДЕЛАТЬ ДАЛЕЕ (CONTINUE, EXIT и тд)
                } else {
                    getView().render(GameMessages.HELL_ERROR);
                }
            }
        }
        return response;
    }

    @Override
    protected UIResponse resultHandler(ActionResult result, int index) {

        UIResponse response = null;

        switch (result) {
            case SUCCESS -> {
                response = UIResponse.RUN_ACCOUNT;
            }
            case CONTINUE -> {}
            case BACK -> {
                response = UIResponse.BACK;
            }
        }
        return response;
    }

}
