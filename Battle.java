import java.util.ArrayList;
import java.util.List;

public class Battle implements Atacker{

    ArrayList <Object> graveyard;
    private Party firstParty;
    private Party secondParty;

    public int startRound (int i ,int j){ // Los personajes atacan una y otra vez hasta que uno de ellos muere.

        int damage1;
        int damage2;
        int result=-1;

        Character characterFirstParty = (Character) this.firstParty.getCharacters().get(i);
        Character characterSecondParty = (Character) this.secondParty.getCharacters().get(j);

        do{

            damage1 = ((Atacker) characterFirstParty).attack();

            damage2 = ((Atacker) characterSecondParty).attack();

            characterFirstParty.setHp(characterFirstParty.getHp() - damage2);
            characterSecondParty.setHp(characterSecondParty.getHp() - damage1);

        }while (characterFirstParty.getHp() > 0 || characterSecondParty.getHp() > 0);

        if (characterFirstParty.getHp() == 0)  {

            graveyard.add(characterFirstParty); // añade el characterFirstParty al graveyard
            firstParty.removeCharacter(characterFirstParty);// Saca del firstParty al characterFirstParty
            characterFirstParty.setAlive(false);
            result = 1; // Devuelve 1 cuando muere el characterFirstParty
        }

        if (characterSecondParty.getHp() == 0) {

            graveyard.add (characterSecondParty); // añade el characterSecondParty al graveyard
            secondParty.removeCharacter(characterSecondParty); //Saca del secondParty al characterSecondParty
            characterSecondParty.setAlive(false);
            result = 2; //  Devuelve 2 cuando muere el characterSecondParty
        }

        if (characterFirstParty.getHp() == 0 && characterSecondParty.getHp() == 0) {

            graveyard.add (characterFirstParty); // Si los dos characters mueren deben ir al graveyard y salir de sus respectivos Parties
            graveyard.add(characterSecondParty);
            firstParty.removeCharacter(characterFirstParty);
            secondParty.removeCharacter(characterSecondParty);
            characterFirstParty.setAlive(false);
            characterSecondParty.setAlive(false);
            result = 0; // Devuelve 0 cuando los dos personajes han muerto y los manda al graveyard
        }

        return result;
    }

    public Battle(Party firstParty, Party secondParty) {

        this.firstParty = firstParty;
        this.secondParty = secondParty;
    }

    public ArrayList<Object> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Object> graveyard) {
        this.graveyard = graveyard;
    }

    public Party getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(Party firstParty) {
        this.firstParty = firstParty;
    }

    public Party getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(Party secondParty) {
        this.secondParty = secondParty;
    }

    @Override
    public int attack() {
        return 0;
    }
}
