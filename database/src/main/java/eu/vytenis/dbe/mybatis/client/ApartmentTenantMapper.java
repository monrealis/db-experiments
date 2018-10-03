package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.ApartmentTenantExample;
import eu.vytenis.dbe.mybatis.model.ApartmentTenantKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ApartmentTenantMapper {
    @SelectProvider(type=ApartmentTenantSqlProvider.class, method="countByExample")
    long countByExample(ApartmentTenantExample example);

    @DeleteProvider(type=ApartmentTenantSqlProvider.class, method="deleteByExample")
    int deleteByExample(ApartmentTenantExample example);

    @Delete({
        "delete from apartment_tenants",
        "where tenant_id = #{tenantId,jdbcType=INTEGER}",
          "and apartment_id = #{apartmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ApartmentTenantKey key);

    @Insert({
        "insert into apartment_tenants (tenant_id, apartment_id)",
        "values (#{tenantId,jdbcType=INTEGER}, #{apartmentId,jdbcType=INTEGER})"
    })
    int insert(ApartmentTenantKey record);

    @InsertProvider(type=ApartmentTenantSqlProvider.class, method="insertSelective")
    int insertSelective(ApartmentTenantKey record);

    @SelectProvider(type=ApartmentTenantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="apartment_id", property="apartmentId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<ApartmentTenantKey> selectByExample(ApartmentTenantExample example);

    @UpdateProvider(type=ApartmentTenantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApartmentTenantKey record, @Param("example") ApartmentTenantExample example);

    @UpdateProvider(type=ApartmentTenantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApartmentTenantKey record, @Param("example") ApartmentTenantExample example);
}