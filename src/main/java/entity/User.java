package entity;

/**
 * Created by Admin on 21.05.2017.
 */
public class User {
    private String name;
    private  int age;
    private Conpany company = new Conpany("yyy");
    // инициализировать лучше так или в констукторе?

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company=" + company +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Conpany getCompany() {
        return company;
    }

    public void setCompany(Conpany company) {
        this.company = company;
    }
}
