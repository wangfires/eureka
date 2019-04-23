import com.baizhi.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.delete("666");
    }
}
