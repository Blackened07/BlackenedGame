package org.blackened.game.entity.hero;

import org.blackened.game.Displayable;
import org.blackened.game.entity.Creature;

public class Hero extends Creature implements Displayable {
    //stats

    public Hero(String name) {
        super(name);
    }

    @Override
    public String getDisplayName() {
        return getName();
    }
}
