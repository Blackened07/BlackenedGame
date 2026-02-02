package org.blackened.game.ui.menuActions.startActions;

import org.blackened.game.ui.ConsoleUI;
import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.View;

public class OnlineAction extends MenuAction {

    private final ConsoleUI menu;

    public OnlineAction(String title, View view, GameSession session, ConsoleUI menu) {
        super(title, view, session);

        this.menu = menu;
    }

    @Override
    public void execute() {
        getSession().initOnlineStorage();
        menu.execute();
    }
}
