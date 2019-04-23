import com.baizhi.util.MybatisUtil;

public class testConnection {
    public static void main(String[] args) {
        MybatisUtil.getSqlSession().getConnection();
    }
}
