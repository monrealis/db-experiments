package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.Building;
import eu.vytenis.dbe.mybatis.model.BuildingExample;
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

public interface BuildingMapper {
    @SelectProvider(type=BuildingSqlProvider.class, method="countByExample")
    long countByExample(BuildingExample example);

    @DeleteProvider(type=BuildingSqlProvider.class, method="deleteByExample")
    int deleteByExample(BuildingExample example);

    @Delete({
        "delete from buildings",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into buildings (id)",
        "values (#{id,jdbcType=INTEGER})"
    })
    int insert(Building record);

    @InsertProvider(type=BuildingSqlProvider.class, method="insertSelective")
    int insertSelective(Building record);

    @SelectProvider(type=BuildingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<Building> selectByExample(BuildingExample example);

    @UpdateProvider(type=BuildingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    @UpdateProvider(type=BuildingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);
}