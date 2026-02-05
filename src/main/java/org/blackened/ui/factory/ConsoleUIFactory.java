package org.blackened.ui.factory;

import org.blackened.game.entity.factory.HeroesFactory;
import org.blackened.service.GameSession;
import org.blackened.ui.ConsoleUI;
import org.blackened.ui.GameAccountUI;
import org.blackened.ui.OnlineMenuUI;
import org.blackened.ui.menuActions.ChoseHeroAction;
import org.blackened.ui.menuActions.CreateHeroAction;
import org.blackened.ui.menuActions.GoBackAction;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.ui.menuActions.startActions.CreateAccountAction;

import org.blackened.ui.menuActions.startActions.LogInAction;
import org.blackened.view.View;

import java.util.List;

public class ConsoleUIFactory {

    private final View view;
    private final GameSession session;
    private final HeroesFactory heroesFactory;

    public ConsoleUIFactory(View view, GameSession session, HeroesFactory heroesFactory) {
        this.view = view;
        this.session = session;
        this.heroesFactory = heroesFactory;
    }

    public  ConsoleUI createOnlineMenu() {
        List<MenuAction> items = List.of(
                new CreateAccountAction("Create account", view, session),
                new LogInAction("Log In", view, session),
                new GoBackAction("Back", view, session)
        );

        return new OnlineMenuUI(view, items);
    };

    public ConsoleUI createAccountMenu() {
        List<MenuAction> accItems = List.of(
                new CreateHeroAction("Create new Hero", view, heroesFactory, session),
                new ChoseHeroAction("Chose your Hero", view, session),
                new GoBackAction("Back", view, session)
        );

        return new GameAccountUI(view, accItems, session);
    }

}
