package org.blackened;

import org.blackened.game.entity.hero.Elurion;
import org.blackened.game.entity.hero.Grobul;
import org.blackened.game.entity.hero.HeroesFactory;
import org.blackened.game.ui.*;
import org.blackened.game.ui.ConsoleUI;
import org.blackened.game.ui.menuActions.*;
import org.blackened.game.ui.menuActions.startActions.*;
import org.blackened.service.GameSession;
import org.blackened.view.ConsoleView;
import org.blackened.view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GameSession session = new GameSession();

        HeroesFactory heroesFactory = new HeroesFactory(
                List.of(new Grobul("Grobul"),
                        new Elurion("Elurion"))
        );


        View view = new ConsoleView();

        List<MenuAction> challenges = List.of(
                //duel
                //maze
                //dungeon
                //boss
        );

        ConsoleUI challengeUI = new ChoseChallengeUI(view, challenges, session);

        List<MenuAction> accItems = List.of(
                new CreateHeroAction("Create new Hero", view, heroesFactory, session),
                new ChoseHeroAction("Chose your Hero", view, session)
        );

        GameAccountUI accountUI = new GameAccountUI(view, accItems, session);

        List<MenuAction> items = List.of(
                new CreateAccountAction("Create account", view, session),
                new IntoAccountAction("Log In", view, session),
                new ExitAction("Exit Game", view, session)
        );

        ConsoleUI onlineMenuUI = new OnlineMenuUI(view, items, accountUI);

        List<MenuAction> start = List.of(
                new OfflineAction("OffLine Game", view, session),
                new OnlineAction("OnLine Game", view, session, onlineMenuUI), // online menu
                new ExitAction("Exit Game", view, session)
        );

        ConsoleUI startUI = new StartUI(view, start, accountUI);

        startUI.execute();

    }

}