package org.blackened.ui.factory;

import org.blackened.game.entity.factory.HeroesFactory;
import org.blackened.service.SessionService;
import org.blackened.ui.*;
import org.blackened.ui.menuActions.*;
import org.blackened.ui.menuActions.startActions.CreateAccountAction;

import org.blackened.ui.menuActions.startActions.LogInAction;
import org.blackened.ui.menuActions.startActions.OfflineAction;
import org.blackened.ui.menuActions.startActions.OnlineAction;
import org.blackened.view.View;

import java.util.List;

public class ConsoleUIFactory {

    private final View view;
    private final SessionService sessionService;
    private final ConsoleInput consoleInput;
    private final HeroesFactory heroesFactory;

    public ConsoleUIFactory(
            View view,
            SessionService sessionService,
            ConsoleInput consoleInput,
            HeroesFactory heroesFactory) {
        this.view = view;
        this.sessionService = sessionService;
        this.consoleInput = consoleInput;
        this.heroesFactory = heroesFactory;
    }

    public ConsoleUI createStartUi() {
        List<MenuAction> start = List.of(
                new OfflineAction("OffLine Game", view, consoleInput, sessionService),
                new OnlineAction("OnLine Game", view, consoleInput, sessionService), // online menu
                new ExitAction("Exit Game", view, consoleInput, sessionService)
        );

        return new StartUI(view, consoleInput, start);
    }

    public  ConsoleUI createOnlineMenu() {
        List<MenuAction> items = List.of(
                new CreateAccountAction("Create account", view, consoleInput, sessionService),
                new LogInAction("Log In", view, consoleInput, sessionService),
                new GoBackAction("Back", view, consoleInput, sessionService)
        );

        return new OnlineMenuUI(view, consoleInput, items);
    };

    public ConsoleUI createAccountMenu() {
        List<MenuAction> accItems = List.of(
                new CreateHeroAction("Create new Hero", view, consoleInput, sessionService, heroesFactory),
                new ChoseHeroAction("Chose your Hero", view, consoleInput, sessionService),
                new GoBackAction("Back", view, consoleInput, sessionService)
        );

        return new GameAccountUI(view, consoleInput, accItems, sessionService.getGameSession());
    }

    public ConsoleUI createChallengeUI() {
        List<MenuAction> challenges = List.of(
                //duel
                //maze
                //dungeon
                //boss
        );

        return new ChoseChallengeUI(view, consoleInput, challenges, sessionService.getGameSession());
    }

}
