package com.group4.Objects;

public class trapBuilder {

    private final String description;
    private final boolean hasSpikes;
    private final boolean hasFire;
    private final boolean hasElectrified;
    private final boolean trapActive;
    private final int damage;

    public trapBuilder (Builder builder)
    {
        this.description = builder.description;
        this.hasSpikes = builder.hasSpikes;
        this.hasFire = builder.hasFire;
        this.hasElectrified = builder.hasElectrified;
        this.trapActive = builder.trapActive;
        this.damage = builder.damage;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHasSpikes() {
        return hasSpikes;
    }

    public boolean isHasFire() {
        return hasFire;
    }

    public boolean isHasElectrified() {
        return hasElectrified;
    }

    public boolean isTrapActive() {
        return trapActive;
    }

    public int getDamage() {
        return damage;
    }

    public static class Builder {
        private String description;
        private boolean hasSpikes;
        private boolean hasFire;
        private boolean hasElectrified;
        private boolean trapActive;
        private int damage;


        public Builder() {
        }

        public Builder(String description, boolean hasSpikes, boolean hasFire, boolean hasElectrified, boolean trapActive, int damage) {
            this.description = description;
            this.hasSpikes = hasSpikes;
            this.hasFire = hasFire;
            this.hasElectrified = hasElectrified;
            this.trapActive = trapActive;
            this.damage = damage;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setHasSpikes(boolean hasSpikes){
            this.hasSpikes = hasSpikes;
            damage = 25;
            return this;
        }

        public Builder setHasFire(boolean hasFire){
            this.hasFire = hasFire;
            damage = 18;
            return this;
        }

        public Builder setHasElectrified(boolean hasElectrified){
            this.hasElectrified = hasElectrified;
            damage = 30;
            return this;
        }

        public Builder setTrapActive(boolean trapActive){
            this.trapActive = trapActive;
            return this;
        }

        public trapBuilder build() {return new trapBuilder(this);}
    }

}


