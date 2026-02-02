package org.blackened.game.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.game.entity.hero.HeroesFactory;
import org.blackened.service.GameSession;
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
    public Hero executeHero() {
        //list of all heroes with description
        List<Hero> heroes = heroesFactory.getHeroes();
        getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
        //take a hero and show description


        int input = choseYourHero(heroes);

        return heroesFactory.create(input);
    }
}
