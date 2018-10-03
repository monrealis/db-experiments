package eu.vytenis.dbe.dsql.client;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BuildingDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Building building = new Building();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = building.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Building extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public Building() {
            super("buildings");
        }
    }
}