package com.group4.Objects;

import com.group4.Interfaces.Enchantment;

public class DoubleDamage implements Enchantment {

    @Override
    public void apply(){
        System.out.println("this weapon now inflicts double damage");
    }
}
