import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testEmp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//        EmpService empservice = (EmpService) context.getBean("empService");
//        List<Emp> all = empservice.findAll();
//        System.out.println(all);
//        for (Emp emp : all) {
//            System.out.println(emp);
//        }
        EmpDao empDao = (EmpDao) context.getBean("empDao");
        List<Emp> all = empDao.findByPage(0,3);

        for (Emp emp : all) {
            System.out.println(emp);
        }
    }
}
