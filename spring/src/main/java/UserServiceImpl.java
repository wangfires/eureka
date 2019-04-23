import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserServiceImpl implements UserService{
    private UserDao userDao ;
    private String name;
    private Integer a;
    private Double price;
    private List<UserDao> userDaos;
    private Map<String,UserDao> map;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<String, UserDao> map) {
        this.map = map;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUserDaos(List<UserDao> userDaos) {
        this.userDaos = userDaos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void delete(String id) {
        System.out.println("service删除成功"+id);
        userDao.delete(id);
        System.out.println("name:"+name);
        System.out.println("a :"+a);
        System.out.println("price :"+price);
        for (UserDao dao : userDaos) {
            System.out.println(dao);
        }
        for (Map.Entry<String, UserDao> entry : map.entrySet()) {
            System.out.println("key :"+entry.getKey()+"value :"+entry.getValue());
        }
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println("key :"+entry.getKey()+"value :"+entry.getValue());
        }
    }

    @Override
    public void save() {
        System.out.println("service成功保存！");
        userDao.save();
    }


}
