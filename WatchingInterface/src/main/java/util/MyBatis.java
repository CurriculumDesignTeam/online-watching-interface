package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatis {

    public static SqlSession getSession(){
//        InputStream in = Resources.class.getResourceAsStream("/mybatis-config.xml");
        InputStream in = MyBatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        System.out.println("#"+in);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        return factory.openSession();

    }

}
