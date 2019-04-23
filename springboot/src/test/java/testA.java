import com.baizhi.Application;
import com.baizhi.entity.Emp1;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class testA {
    @Autowired
    private EmpService empService;
    @Test
    public void aa(){
        List<Emp1> all = empService.findAll();
        System.out.println(all);
    }
}
