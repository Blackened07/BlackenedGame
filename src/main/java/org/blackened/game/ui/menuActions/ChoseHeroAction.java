package org.blackened.game.ui.menuActions;

import org.blackened.game.entity.hero.Hero;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class ChoseHeroAction extends MenuAction {

    public ChoseHeroAction(String title, View view, GameSession session) {

        super(title, view, session);
    }

    @Override
    public Hero executeHero() {

        List<Hero> heroes = List.of();

        if (!getSession().getPlayerHeroesList().isEmpty()) {
            heroes = getSession().getPlayerHeroesList();
            getView().renderMenu(heroes, GameMessages.CHOSE_YOUR_HERO);
        }

        int input = choseYourHero(heroes);

        return heroes.get(input - 1);
    }
}
