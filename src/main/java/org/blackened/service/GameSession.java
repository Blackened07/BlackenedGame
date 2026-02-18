package org.blackened.service;

import org.blackened.db.account.GameAccount;
import org.blackened.game.entity.hero.Hero;

import java.util.List;

public class GameSession {

    private GameAccount account;
    private Hero currentHero;


    public void setAccount(GameAccount account) {
        this.account = account;
    }

    public void setHeroToAccountList(Hero hero) {
        account.setHeroes(hero);
        //saveAccount();
    }

    public void saveHero(int index) {
        this.currentHero = account.getHero(index);
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public List<Hero> getHeroesList() {
        if (account.checkHeroesListIsNotEmpty()) {
            return account.getHeroesList();
        }
        return List.of();
    }

    public int getHeroesListSize() {
        return account.getHeroesList().size();
    }

}
