package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.View;

import java.util.List;

public class ChoseChallengeUI extends ConsoleUI {

    private final GameSession session;

    public ChoseChallengeUI(View view, List<MenuAction> actions, GameSession session) {
        super(view, actions);
        this.session = session;
    }
    //ВЫБОР ЧЕЛЕНЖА ТИПА ДУЕЛЬ, БОСС, ДАНЖ И ТД.. И СООТВЕТСТВЕННО ЕГО ЗАПУСК ИЗ ФАБРИКИ СУДЯ ПО ВСЕМУ
    //ВНУТРИ ЧЕЛЕНДЖА ВЫБОР КОНКРЕТНОСТИ. ДУЕЛЬ ПРОТИВ 1 2 3 4 И ТД - ВОТ ТУТ И ВКЛЮЧАЕТСЯ ФАБРИКА
    //ПРОДУМАТЬ КАК СЕТИТЬ\СОЗДАВАТЬ ИГРУ

    //В ГЕЙМ СЕШН СДЕЛАТЬ МЕТОД ПРИНИМАЮЩИЙ ЕНАМ ТИПА ИГРЫ, ВЕРОЯТНО ЗАЮЗАТЬ САПЛАЕР
    //ВОЗВРАЩАЕМ ИГРУ - СЕТИМ В ПОЛЕ РАЗУМЕЕТСЯ (ПОЛЕ ТИПА ИНТЕРФЕЙС ГЕЙМ) И У ГЕЙМ ВЫЗЫВАЕМ РАН ИЛИ ТИПА ТОГО
    @Override
    public UIResponse execute() {

    }

    @Override
    protected UIResponse resultHandler(ActionResult result, int index) {
        return null;
    }
}
