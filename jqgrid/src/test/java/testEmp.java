import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class testEmp {
    @Autowired
    private EmpService empService;
    @Test
    public void add(){

        Emp emp=new Emp("1112","ww",18,new Date(),1000.0,"1",new Dept("1","小卖铺"));
        empService.add(emp);
    }
    @Test
    public void delete(){
        empService.delete("1112");
    }
    @Test
    public void update(){
        Emp emp=new Emp("1112","萌萌萌",18,new Date(),1000.0,"1",new Dept("1","小卖铺"));
        empService.update(emp);
    }
    @Test
    public void page(){
        List<Emp> list = empService.findByPage(0,3);
        System.out.println(list);
    }
}
