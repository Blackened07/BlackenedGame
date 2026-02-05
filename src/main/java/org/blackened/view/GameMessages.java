package org.blackened.view;

public enum GameMessages {
    PROVIDER("Chose a game type"),
    BACK_TEXT("If you wanna go back, please enter 'B'"),
    GO_BACK("Go Back"),
    MAIN_MENU_LABEL("****** ****** ****** WELCOME TO DEATH SATANIC ARENA GAME ****** ****** ****** "),
    REQUEST_TO_ENTER_MENU_POINT("Please enter menu point number"),
    HELL_ERROR("Burn In HEll"),
    ACC_CREATION("Welcome to Account Creator\nPlease enter your LogIn:\nLogIn can contains only english letters and arabic numbers:"),
    ACC_CREATION_PASSWORD_PHASE("Your LogIn is: %s\nPlease enter your password with only english letters and arabic numbers:"),
    PLEASE_TRY_AGAIN("Please try again"),
    REQUEST_TO_ENTER_LOGIN("Please enter your LogIn"),
    REQUEST_TO_ENTER_PASSWORD("Please enter your password"),
    ACCOUNT_LABEL("------Welcome to your account------"),
    CHOSE_YOUR_HERO("Chose your Hero"),
    YOUR_HEROES_LIST("Your have %d heroes"),
    YOUR_HEROES_LIST_IS_EMPTY("Your heroes list is empty");;

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
