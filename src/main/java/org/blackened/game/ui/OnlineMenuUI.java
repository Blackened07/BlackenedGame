package org.blackened.game.ui;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class OnlineMenuUI extends ConsoleUI {
    private final GameAccountUI accountUI;
    private boolean isOnMenu;

    public OnlineMenuUI(View view, List<MenuAction> actions, GameAccountUI accountUI) {
        super(view, actions);
        this.isOnMenu = true;
        this.accountUI = accountUI;
    }

    public void execute() {
        //setIsOn to true at start

        while (isOnMenu) {
            getView().renderMenu(getActions(), GameMessages.MAIN_MENU_LABEL);
            getView().render(GameMessages.REQUEST_TO_ENTER_MENU_POINT);

            String input = getView().getLine();

            switch (input) {
                case "1" -> {
                    MenuAction item = getActions().get(0);
                    item.execute();
                    if (item.isOperationSuccess()) {
                        MenuAction itemIntoAcc = getActions().get(1);
                        itemIntoAcc.execute();
                        if (item.isOperationSuccess()) {
                            setState(false);
                        }
                    }
                }
                case "2" -> {
                    MenuAction item = getActions().get(1);
                    item.execute();
                    if (item.isOperationSuccess()) {
                        setState(false);
                        accountUI.execute();
                    }
                }
                case "3" -> {
                    getActions().get(2).execute();
                }
                default -> {
                    getView().render(GameMessages.HELL_ERROR);
                }
            }
        }
    }

    private void setState(boolean state) {
        isOnMenu = state;
    }
}
