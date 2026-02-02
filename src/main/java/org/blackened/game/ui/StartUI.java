package org.blackened.game.ui;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class StartUI extends ConsoleUI{

    private final GameAccountUI accountUI;

    public StartUI(View view, List<MenuAction> actions, GameAccountUI accountUI) {
        super(view, actions);
        this.accountUI = accountUI;
    }

    @Override
    public void execute() {
        getView().renderMenu(getActions(), GameMessages.MAIN_MENU_LABEL);
        getView().render(GameMessages.PROVIDER);

        while(isOn()) {
            String input = getView().getLine();

            switch (input) {
                case "1" -> {
                    MenuAction action = getActions().get(0);
                    action.execute();
                    if (action.isOperationSuccess()) {
                        setOn(false);
                        accountUI.execute();
                    }
                }
                case "2" -> {
                    MenuAction action = getActions().get(1);
                    action.execute();
                    setOn(false);
                    accountUI.execute();
                }
                case "3" -> {
                    MenuAction action = getActions().get(2);
                    action.execute();
                }
                default -> {
                    getView().render(GameMessages.HELL_ERROR);
                }
            }
        }
    }
}
