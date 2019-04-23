package com.group4.Objects;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DamageRandomiser {

    public static int getRandomDamage(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
