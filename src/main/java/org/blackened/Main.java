package org.blackened;

import org.blackened.game.entity.hero.Elurion;
import org.blackened.game.entity.hero.Grobul;
import org.blackened.game.entity.hero.HeroesFactory;
import org.blackened.ui.*;
import org.blackened.service.GameSession;
import org.blackened.ui.factory.ConsoleUIFactory;
import org.blackened.ui.menuActions.*;
import org.blackened.ui.menuActions.startActions.*;
import org.blackened.view.ConsoleView;
import org.blackened.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
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



        List<MenuAction> start = List.of(
                new OfflineAction("OffLine Game", view, session),
                new OnlineAction("OnLine Game", view, session), // online menu
                new ExitAction("Exit Game", view, session)
        );

        ConsoleUI startUI = new StartUI(view, start);

        ///TODO СОЗДАТЬ КЛАСС УПРАВЛЕНИЯ МЕНЮ С ЛИФО СТЕКОМ И УПРАВЛЕНИЕМ ИМ

        Deque<ConsoleUI> stack = new ArrayDeque<>();
        stack.add(startUI);

        ConsoleUIFactory uiFactory = new ConsoleUIFactory(view, session, heroesFactory);

        MenuManager menuManager = new MenuManager(stack, uiFactory);

        menuManager.start();

    }

}