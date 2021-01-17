

public class Warrior extends Character implements Atacker {

    private int stamina;
    private int strength;

    public Warrior (String id, String name, int hp, int stamina, int strength ) {

        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public int attack() { // Devuelve el daño causado al oponente en el ataque

        if(this.stamina >=5){

            return heavyAttack();

        } else{

            return weakAttack();
        }
    }

    public int heavyAttack(){ // Devuelve el daño causado al oponente por heavyAttack


        this.stamina -= 5;
        return this.strength;
    }

    public int weakAttack(){ // Devuelve el daño causado al oponente por heavyAttack


        this.stamina++;
        return (int) Math.round(this.strength /2);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}

