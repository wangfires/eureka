import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user= new User();
        userService.save(user);
    }
}
