package net.coinpurse.api.coinpurseapi.tests;

public class Test {
    private String health;

    // Constructor 1
    public Test() {
        this.health = "OK";
    }

    private String getHealth() {
        return this.health;
    }

    private void setHealth(String newHealth) {
        this.health = newHealth;
    }
}
