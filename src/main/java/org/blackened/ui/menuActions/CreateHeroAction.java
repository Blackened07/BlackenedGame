package org.blackened.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.game.entity.factory.HeroesFactory;
import org.blackened.service.GameSession;
import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class CreateHeroAction extends MenuAction {

    private final HeroesFactory heroesFactory;

    public CreateHeroAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService, HeroesFactory heroesFactory) {
        super(title, view, consoleInput, sessionService);
        this.heroesFactory = heroesFactory;
    }

    @Override
    public ActionResult execute() {
        //list of all heroes with description
        List<Hero> heroes = heroesFactory.getHeroes();
        getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
        getView().render(GameMessages.BACK_TEXT);
        //take a hero and show description

        String line = getConsoleInput().getValidLine();

        if (getConsoleInput().isLineForExit(String.valueOf(line))) {
            return ActionResult.CONTINUE;
        }

        int input = getConsoleInput().getNumberEqualsPlayerInput(heroes, line);

        Hero hero = heroesFactory.create(input - 1);
        getGameSession().setHeroToAccountList(hero);

        return ActionResult.CONTINUE;
    }
}
