package org.blackened.game.ui;

import org.blackened.game.entity.hero.Hero;
import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public class GameAccountUI extends ConsoleUI {

    private final GameSession session;

    public GameAccountUI(View view, List<MenuAction> actions, GameSession session) {
        super(view, actions);
        this.session = session;
    }

    /// ACCOUNT UI НЕ ЗНАЕТ ОНЛАЙН ИЛИ ОФФЛАЙН ИГРА!!! ОН СОВЕРШАЕТ СВОИ ОБЫЧНЫЕ ДЕЙСТВИЯ ОБРАЩАЯСЬ К СЕССИИ ЗА ИНФОЙ
    @Override
    public void execute() {

        while (isOn()) {
            getView().renderMenu(getActions(), GameMessages.ACCOUNT_LABEL);
            getView().renderMenu(session.getPlayerHeroesList(), GameMessages.YOUR_HEROES_LIST);

            MenuAction item;
            Hero hero;

            String input = getView().getLine();

            switch (input) {
                case "1" -> {
                    item = getActions().get(0);
                    hero = item.executeHero();
                    session.setHero(hero);
                    session.saveAccount();
                }
                case "2" -> {
                    item = getActions().get(1);
                    hero = item.executeHero();
                    //hero add to someGameLoop
                    //RUN CHALLENGE UI
                }
                default -> {
                    getView().render(GameMessages.HELL_ERROR);
                }
            }
        }
    }


}
