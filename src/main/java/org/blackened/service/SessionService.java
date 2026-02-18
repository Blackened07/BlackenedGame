package org.blackened.service;

public class SessionService {

    private final RegistrationSession registrationSession;
    private final GameSession gameSession;

    public SessionService(RegistrationSession registrationSession, GameSession gameSession) {
        this.registrationSession = registrationSession;
        this.gameSession = gameSession;
    }

    public RegistrationSession getRegistrationSession() {
        return registrationSession;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

}
