package org.blackened.game.entity.factory;
import org.blackened.game.entity.hero.Hero;

import java.util.List;

public class HeroesFactory {
    //list of all heroes upload when it need
    private final List<Hero> heroes;

    public HeroesFactory(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public Hero create(int index) {
        return heroes.get(index - 1);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
