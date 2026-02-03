package org.blackened.ui;

import org.blackened.game.entity.hero.Hero;
import org.blackened.ui.menuActions.MenuAction;
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
    public UIResponse execute() {
        UIResponse response = null;
        while (isRunning()) {
            getView().renderMenu(getActions(), GameMessages.ACCOUNT_LABEL);
            getView().renderMenu(session.getPlayerHeroesList(), GameMessages.YOUR_HEROES_LIST);

            String input = getView().getLine();

            int numericInput = parser(input);
            int index = numericInput - 1;

            if (numericInput <= getActions().size()) {
                MenuAction action = getActions().get(index);
                ActionResult result = action.execute();
                response = resultHandler(result, index);// КОТОРЫЙ ВЕРНЁТ ЕНАМ С ТЕМ ЧТО ДЕЛАТЬ ДАЛЕЕ (CONTINUE, EXIT и тд)
            } else {
                getView().render(GameMessages.HELL_ERROR);
            }

        }
        return response;
    }

    @Override
    protected UIResponse resultHandler(ActionResult result, int index) {
        return null;
    }


}
