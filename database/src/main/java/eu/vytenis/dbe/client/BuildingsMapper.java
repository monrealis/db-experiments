package eu.vytenis.dbe.client;

import eu.vytenis.dbe.model.Buildings;
import eu.vytenis.dbe.model.BuildingsExample;
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

public interface BuildingsMapper {
    @SelectProvider(type=BuildingsSqlProvider.class, method="countByExample")
    long countByExample(BuildingsExample example);

    @DeleteProvider(type=BuildingsSqlProvider.class, method="deleteByExample")
    int deleteByExample(BuildingsExample example);

    @Delete({
        "delete from buildings",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into buildings (id)",
        "values (#{id,jdbcType=INTEGER})"
    })
    int insert(Buildings record);

    @InsertProvider(type=BuildingsSqlProvider.class, method="insertSelective")
    int insertSelective(Buildings record);

    @SelectProvider(type=BuildingsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<Buildings> selectByExample(BuildingsExample example);

    @UpdateProvider(type=BuildingsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Buildings record, @Param("example") BuildingsExample example);

    @UpdateProvider(type=BuildingsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Buildings record, @Param("example") BuildingsExample example);
}