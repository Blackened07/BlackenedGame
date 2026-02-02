package org.blackened.view;

import org.blackened.game.Displayable;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render(GameMessages message) {
        System.out.println(message.getMessage());
    }

    @Override
    public void render(GameMessages message, Object... args) {
        System.out.printf(message.getMessage() + "%n", args);
    }

    @Override
    public void renderMenu(List<? extends Displayable> collection, GameMessages messages) {
        System.out.println(messages.getMessage());

        for (int i = 0; i < collection.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, collection.get(i).getDisplayName());
        }
    }

    @Override
    public String getLine() {
        return scanner.nextLine();
    }
}
