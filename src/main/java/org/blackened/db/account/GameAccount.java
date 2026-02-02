package org.blackened.db.account;

import com.google.gson.annotations.SerializedName;
import org.blackened.utils.JsonWriter;
import org.blackened.game.entity.hero.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameAccount {

    @SerializedName(value = "logIn")
    private final String login;

    @SerializedName(value = "password")
    private final String password;

    @SerializedName(value = "Heroes")
    private final List<Hero> heroes;

    //Вероятно прогресс тоже надо сохранять? Если не рандом.. если рандом, то учитываются характеристики бойца

    public GameAccount(String login, String password) {
        this.login = login;
        this.password = password;
        this.heroes = new ArrayList<>(6);

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Hero> getHeroesList() {
        return heroes;
    }

    public Hero getHero(int index) {
        return heroes.get(index);
    }

    public void setHeroes(Hero hero) {
        heroes.add(hero);
    }

    public boolean checkHeroesListIsNotEmpty() {
        return !heroes.isEmpty();
    }

    public void save() {
        JsonWriter.write(this, login);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        GameAccount that = (GameAccount) object;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "GameAccount{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
