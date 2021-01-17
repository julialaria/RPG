import java.util.ArrayList;
import java.util.List;

public class Party  {

    private String name;
    private ArrayList<Object> characters;


    public void removeCharacter(Character character){
        this.characters.remove(character);
    }

    public boolean hasRemainingCharacter (){
        return this.characters.size() > 0;
    }


    public Party(String name, ArrayList<Object> characters) {

        this.name = name;
        this.characters = characters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Object> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Object> characters) {
        this.characters = characters;
    }


}
