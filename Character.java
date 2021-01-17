public abstract class Character {

    protected String id;
    protected String name;
    protected int hp;
    protected boolean isAlive;

    public Character(String id, String name, int hp) {

        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
