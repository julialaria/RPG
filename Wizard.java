

public class Wizard extends Character implements Atacker {

    private int mana;
    private int intelligence;

    public Wizard (String id, String name, int hp, int mana, int intelligence) {

        super(id, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public int attack() { // Devuelve el daño causado al oponente en el ataque

        if(this.mana >= 5){
            return fireBall();

        } else{

            return staffHit();
        }
    }

    public int fireBall(){ // Devuelve el daño causado al oponente por el ataque fireBall

        this.mana -= 5;
        return this.intelligence;
    }

    public int staffHit(){ // Devuelve el daño causado al oponente por el ataque satffHit
        this.mana++;
        return 2;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
