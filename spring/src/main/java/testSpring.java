import com.baizhi.service.CLazzService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        CLazzService cs = (CLazzService) context.getBean("clazzService");
        System.out.println(cs.getClass());
        cs.find("321");
    }
}
