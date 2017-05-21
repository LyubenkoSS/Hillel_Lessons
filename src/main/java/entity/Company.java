package entity;

/**
 * Created by Admin on 21.05.2017.
 */
public class Company {
    private String name;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {

        this.name = name;
    }
}
