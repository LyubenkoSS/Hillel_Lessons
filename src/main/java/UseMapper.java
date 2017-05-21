import entity.Person;
import entity.User;
import mapper.MyMapper;

/**
 * Created by Admin on 21.05.2017.
 */
public class UseMapper {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("iam", 111);
        Person person = new Person();
        MyMapper.map(user, person);
    }
}
