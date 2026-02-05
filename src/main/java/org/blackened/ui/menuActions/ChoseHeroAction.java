package org.blackened.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.service.GameSession;
import org.blackened.ui.ActionResult;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class ChoseHeroAction extends MenuAction {

    public ChoseHeroAction(String title, View view, GameSession session) {

        super(title, view, session);
    }

    @Override
    public ActionResult execute() {

        List<Hero> heroes = getSession().getHeroesList();

        if (!heroes.isEmpty()) {
            heroes = getSession().getHeroesList();
            getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
            getView().render(GameMessages.BACK_TEXT);
        } else {
            getView().render(GameMessages.YOUR_HEROES_LIST_IS_EMPTY);
        }

        String line = getValidLine();

        if (isLineForExit(String.valueOf(line))) {
            return ActionResult.CONTINUE;
        }

        int input = getNumberEqualsPlayerInput(heroes, line);

        getSession().saveHero(input - 1);

        return ActionResult.SUCCESS;
    }
}
