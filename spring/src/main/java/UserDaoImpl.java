public class UserDaoImpl implements  UserDao {
    @Override
    public void delete(String id) {
        System.out.println("删除成功"+id);
    }

    @Override
    public void save() {
        System.out.println("成功保存！");
    }
}
