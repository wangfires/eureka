import com.baizhi.entity.Files;
import com.baizhi.service.FilesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class testFile {
    @Autowired
    private FilesService filesService;
    @Test
    public void aa(){
        Files files = new Files("1","1.springmvc诞生和引言.png","111","aaa","file/2019-03-12",9007l,"image/png",0,"111");
        //Files{id='null', oldname='1.springmvc诞生和引言.png', newname='null', suffix='aaa', path='file/2019-03-12', size=9007, type='image/png', num=0, userid='111'}

       // filesService.addFile(files);
        List<Files> all = filesService.findAll("111");
        System.out.println(all);


    }
}
