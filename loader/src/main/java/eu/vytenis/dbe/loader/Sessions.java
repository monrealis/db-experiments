package eu.vytenis.dbe.loader;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import eu.vytenis.dbe.mybatis.client.BuildingMapper;
import eu.vytenis.dbe.mybatis.client.ComplexMapper;
import eu.vytenis.dbe.mybatis.client.RequestMapper;
import eu.vytenis.dbe.mybatis.client.ApartmentMapper;
import eu.vytenis.dbe.mybatis.client.ApartmentTenantMapper;
import eu.vytenis.dbe.mybatis.client.TenantMapper;

public class Sessions {

    public SqlSession postgres() {
        return session(postgresDataSource());
    }

    public SqlSession mysql() {
        return session(mysqlDataSource());
    }

    public SqlSession vertica() {
        return session(verticaDataSource());
    }

    private SqlSession session(UnpooledDataSource dataSource) {
        SqlSessionFactoryBuilder b = new SqlSessionFactoryBuilder();
        Configuration c = createConfiguration();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        c.setEnvironment(new Environment("dev", transactionFactory, dataSource));
        SqlSessionFactory s = b.build(c);
        SqlSession session = s.openSession();
        return session;
    }

    private Configuration createConfiguration() {
        Configuration c = new Configuration();
        c.addMapper(ApartmentMapper.class);
        c.addMapper(ApartmentTenantMapper.class);
        c.addMapper(TenantMapper.class);
        c.addMapper(BuildingMapper.class);
        c.addMapper(ComplexMapper.class);
        c.addMapper(RequestMapper.class);
        return c;
    }

    public UnpooledDataSource postgresDataSource() {
        return new UnpooledDataSource("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres",
                "");
    }

    public UnpooledDataSource mysqlDataSource() {
        return new UnpooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/docker?useSSL=false",
                "root", "p");
    }

    public UnpooledDataSource verticaDataSource() {
        return new UnpooledDataSource("com.vertica.jdbc.Driver", "jdbc:vertica://localhost:5433/docker", "dbadmin", "");
    }

    static {
        configureLogging();
    }

    private static void configureLogging() {
        LogFactory.useJdkLogging();
        Logger logger = Logger.getLogger("eu.vytenis");
        Level level = Level.FINE;
        logger.setLevel(level);
        ConsoleHandler h = new ConsoleHandler();
        h.setFormatter(new SimpleFormatter());
        h.setLevel(level);
        logger.addHandler(h);
    }

    private static final class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + "\n";
        }
    }
}