package com.group4.Objects;

import com.group4.Interfaces.Enchantment;

public class GodMode implements Enchantment {

    @Override
    public void apply(){
        System.out.println("this weapon now inflicts 100% damage from the power of this enchantment");
    }
}
