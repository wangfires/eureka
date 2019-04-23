import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAction {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String check()throws Exception{

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Content-Type", "application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();

        if("张三".equals(username)){
            writer.write("该用户已存在");
        }else{
            writer.write("可以使用");
        }
        return Action.NONE;
    }
    public String findOne() throws IOException {
        User user = new User("1","wangwang",22,new Date());
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String s = JSONObject.toJSONStringWithDateFormat(user,"yyyy-MM-dd");
        writer.write(s);
        return Action.NONE;
    }
    public String findAll() throws IOException {
        List<User> list = new ArrayList<User>();
        list.add(new User("1","wangwang",11,new Date()));
        list.add(new User("2","wangwang1",12,new Date()));
        list.add(new User("3","wangwang2",13,new Date()));
        list.add(new User("4","wangwang3",14,new Date()));
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String s = JSONObject.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
        writer.write(s);
        return Action.NONE;


    }
}
