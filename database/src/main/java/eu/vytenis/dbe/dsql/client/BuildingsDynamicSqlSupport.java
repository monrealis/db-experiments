package eu.vytenis.dbe.dsql.client;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BuildingsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Buildings buildings = new Buildings();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = buildings.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Buildings extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public Buildings() {
            super("buildings");
        }
    }
}