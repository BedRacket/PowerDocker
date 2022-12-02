package org.bedracket.powerdocker.api.mana;

public interface IManaHandler {

    void setMana(float mana);
    void setMaxMana(float maxMana);

    void regenMana(float mana);

    float getMana();
    float getMaxMana();

    void reduceMana(float mana);
}
