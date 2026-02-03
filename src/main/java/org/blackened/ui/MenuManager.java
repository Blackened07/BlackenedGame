package org.blackened.ui;

import org.blackened.ui.factory.ConsoleUIFactory;


import java.util.Deque;

public class MenuManager {
    private final ConsoleUIFactory uIFactory;
    private final Deque<ConsoleUI> stack;

    public MenuManager(Deque<ConsoleUI> stack, ConsoleUIFactory uIFactory) {
        this.stack = stack;
        this.uIFactory = uIFactory;
    }

    public void start() {
        while (!stack.isEmpty()) {
            ConsoleUI current = stack.peek();

            //waiting for response
            UIResponse response = current.execute();

            //call response handler
            responseHandler(response);
        }
    }

    private void responseHandler(UIResponse response) {
        switch (response) {
            case BACK -> {
                stack.pop();
            }
            case RUN_ONLINE -> {
                stack.push(uIFactory.createOnlineMenu());
            }
            case RUN_ACCOUNT -> {
                stack.push(uIFactory.createAccountMenu());
            }
            case RUN_SELECT_CHALLENGE -> {}
        }
    }
}
