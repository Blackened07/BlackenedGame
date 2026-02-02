package org.blackened.game.entity;

public class Creature extends Entity {

    private float maxHealth;
    private float maxResource;

    private float currentHealth;
    private float currentResource;

    private int strength;
    private int stamina;
    private int agility;
    private int intellect;

    private float attackPower;
    private float spellPower;
    private float evasion;
    private float block;
    private float spellResist;

    private int experience;
    private int level;

    private int gold;

    public Creature(String name) {
        super(name);
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getMaxResource() {
        return maxResource;
    }

    public void setMaxResource(float maxResource) {
        this.maxResource = maxResource;
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(float currentHealth) {
        this.currentHealth = currentHealth;
    }

    public float getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(float currentResource) {
        this.currentResource = currentResource;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public float getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(float attackPower) {
        this.attackPower = attackPower;
    }

    public float getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(float spellPower) {
        this.spellPower = spellPower;
    }

    public float getEvasion() {
        return evasion;
    }

    public void setEvasion(float evasion) {
        this.evasion = evasion;
    }

    public float getBlock() {
        return block;
    }

    public void setBlock(float block) {
        this.block = block;
    }

    public float getSpellResist() {
        return spellResist;
    }

    public void setSpellResist(float spellResist) {
        this.spellResist = spellResist;
    }
}
