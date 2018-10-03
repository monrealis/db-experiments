package eu.vytenis.dbe.dsql.client;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ApartmentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Apartment apartment = new Apartment();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = apartment.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> unitNumber = apartment.unitNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> buildingId = apartment.buildingId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Apartment extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> unitNumber = column("unit_number", JDBCType.VARCHAR);

        public final SqlColumn<Integer> buildingId = column("building_id", JDBCType.INTEGER);

        public Apartment() {
            super("apartments");
        }
    }
}