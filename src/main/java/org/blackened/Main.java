package org.blackened;

import org.blackened.db.account.factory.StorageFactory;
import org.blackened.game.entity.hero.Elurion;
import org.blackened.game.entity.hero.Grobul;
import org.blackened.game.entity.factory.HeroesFactory;
import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.*;
import org.blackened.service.GameSession;
import org.blackened.ui.factory.ConsoleUIFactory;
import org.blackened.view.ConsoleView;
import org.blackened.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /// TODO сделать отдельный класс CONSOLE_INPUT и внедрить его в конструкторы экшн и УИ


        /// TODO СОЗДАТЬ DTO КЛАСС ДЛЯ ЭКШНОВ, ДЛЯ ФОРМИРОВАНИЯ ОТОБРАЖЕНИЯ ГЕРОЯ С НУЖНЫМИ СТАТАМИ И ТД

        /// ВЕРОЯТНО НЕ СТОИТ СОЗДАВАТЬ ГЕЙМ СЕШН СРАЗУ, А СОЗДАВТАЬ ЕГО ТОЛЬКО ПРИ ВЫБОРЕ ОФФЛАЙН ИЛИ ОНЛАЙН РЕЖИМА
        /// ТО ЕСТЬ: СОЗДАТЬ ГС ФАКТОРИ СО ССЫЛКОЙ НА СТОР ФАКТОРИ. МЕТОД ИНИТ СТОР ИЗ ГС ПЕРЕНЕСТИ ТУДА

        /// ВЕРОЯТНО СТОИТ РАЗДЕЛИТЬ ЛОГИКУ ВХОДА\РЕГИСТРАЦИИ ОТ СОЗДАНИЯ СОХРАНЕНИЯ ГЕРОЯ
        /// СОЗДАТЬ КЛАСС РЕГСТРЕЙШН СЕШН
        /// ВЫДЕЛИТЬ У НИХ ОБЩЕЕ И СОЗДАТЬ ИНТЕРФЕЙС

        StorageFactory storageFactory = new StorageFactory();

        HeroesFactory heroesFactory = new HeroesFactory(
                List.of(new Grobul("Grobul"),
                        new Elurion("Elurion"))
        );

        RegistrationSession registrationSession = new RegistrationSession(storageFactory);
        GameSession gameSession = new GameSession();

        SessionService sessionService = new SessionService(registrationSession,gameSession);

        View view = new ConsoleView();


        ConsoleInput consoleInput = new ConsoleInput(view);


        ConsoleUIFactory uiFactory = new ConsoleUIFactory(view, sessionService, consoleInput, heroesFactory);

        Deque<ConsoleUI> stack = new ArrayDeque<>();

        stack.add(uiFactory.createStartUi());

        MenuManager menuManager = new MenuManager(stack, uiFactory);

        menuManager.start();

    }

}