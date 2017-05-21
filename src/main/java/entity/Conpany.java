package entity;

/**
 * Created by Admin on 21.05.2017.
 */
public class Conpany {
    private String name;

    @Override
    public String toString() {
        return "Conpany{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Conpany(String name) {

        this.name = name;
    }
}
