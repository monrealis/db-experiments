package eu.vytenis.dbe.dsql.client;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ApartmentsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Apartments apartments = new Apartments();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = apartments.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Apartments extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public Apartments() {
            super("apartments");
        }
    }
}