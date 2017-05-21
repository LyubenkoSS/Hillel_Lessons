package mapper;

import entity.Person;
import entity.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by Admin on 21.05.2017.
 */
public class DozerMapp {
    public static void main(String[] args) {
        User user = new User("I Am", 33);
        Mapper mapper = new DozerBeanMapper();
        Person person = mapper.map(user, Person.class);
        System.out.println(person);


    }
}
