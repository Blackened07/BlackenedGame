package org.blackened.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.service.GameSession;
import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class ChoseHeroAction extends MenuAction {

    public ChoseHeroAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {

        List<Hero> heroes = getGameSession().getHeroesList();

        if (!heroes.isEmpty()) {
            heroes = getGameSession().getHeroesList();
            getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
            getView().render(GameMessages.BACK_TEXT);
        } else {
            getView().render(GameMessages.YOUR_HEROES_LIST_IS_EMPTY);
        }

        String line = getConsoleInput().getValidLine();

        if (getConsoleInput().isLineForExit(String.valueOf(line))) {
            return ActionResult.CONTINUE;
        }

        int input = getConsoleInput().getNumberEqualsPlayerInput(heroes, line);

        getGameSession().saveHero(input - 1);

        return ActionResult.SUCCESS;
    }
}
