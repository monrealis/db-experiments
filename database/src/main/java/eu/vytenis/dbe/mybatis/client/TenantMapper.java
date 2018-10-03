package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.Tenant;
import eu.vytenis.dbe.mybatis.model.TenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TenantMapper {
    @SelectProvider(type=TenantSqlProvider.class, method="countByExample")
    long countByExample(TenantExample example);

    @DeleteProvider(type=TenantSqlProvider.class, method="deleteByExample")
    int deleteByExample(TenantExample example);

    @Delete({
        "delete from tenants",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tenants (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Tenant record);

    @InsertProvider(type=TenantSqlProvider.class, method="insertSelective")
    int insertSelective(Tenant record);

    @SelectProvider(type=TenantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Tenant> selectByExample(TenantExample example);

    @Select({
        "select",
        "id, name",
        "from tenants",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Tenant selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TenantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Tenant record, @Param("example") TenantExample example);

    @UpdateProvider(type=TenantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Tenant record, @Param("example") TenantExample example);

    @UpdateProvider(type=TenantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Tenant record);

    @Update({
        "update tenants",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tenant record);
}