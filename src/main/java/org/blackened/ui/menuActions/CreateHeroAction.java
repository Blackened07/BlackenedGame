package org.blackened.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.game.entity.factory.HeroesFactory;
import org.blackened.service.GameSession;
import org.blackened.ui.ActionResult;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class CreateHeroAction extends MenuAction {

    private final HeroesFactory heroesFactory;

    public CreateHeroAction(String title, View view, HeroesFactory heroesFactory, GameSession session) {
        super(title, view, session);
        this.heroesFactory = heroesFactory;
    }

    @Override
    public ActionResult execute() {
        //list of all heroes with description
        List<Hero> heroes = heroesFactory.getHeroes();
        getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
        getView().render(GameMessages.BACK_TEXT);
        //take a hero and show description

        String line = getValidLine();

        if (isLineForExit(String.valueOf(line))) {
            return ActionResult.CONTINUE;
        }

        int input = getNumberEqualsPlayerInput(heroes, line);

        Hero hero = heroesFactory.create(input - 1);
        getSession().setHeroToAccountList(hero);

        return ActionResult.CONTINUE;
    }
}
