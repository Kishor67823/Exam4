public class Player {
    String name;
    Die die;

    public Player(String name, Die die) {
        this.name = name;
        this.die = die;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDie(Die die) {
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public Die getDie() {
        return die;
    }


}

