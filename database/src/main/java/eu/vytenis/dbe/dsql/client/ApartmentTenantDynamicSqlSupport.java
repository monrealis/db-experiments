package eu.vytenis.dbe.dsql.client;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ApartmentTenantDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ApartmentTenant apartmentTenant = new ApartmentTenant();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> tenantId = apartmentTenant.tenantId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> apartmentId = apartmentTenant.apartmentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ApartmentTenant extends SqlTable {
        public final SqlColumn<Integer> tenantId = column("tenant_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> apartmentId = column("apartment_id", JDBCType.INTEGER);

        public ApartmentTenant() {
            super("apartment_tenants");
        }
    }
}