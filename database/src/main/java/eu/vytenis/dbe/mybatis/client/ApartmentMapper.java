package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.Apartment;
import eu.vytenis.dbe.mybatis.model.ApartmentExample;
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

public interface ApartmentMapper {
    @SelectProvider(type=ApartmentSqlProvider.class, method="countByExample")
    long countByExample(ApartmentExample example);

    @DeleteProvider(type=ApartmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(ApartmentExample example);

    @Delete({
        "delete from apartments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into apartments (id, unit_number, ",
        "building_id)",
        "values (#{id,jdbcType=INTEGER}, #{unitNumber,jdbcType=VARCHAR}, ",
        "#{buildingId,jdbcType=INTEGER})"
    })
    int insert(Apartment record);

    @InsertProvider(type=ApartmentSqlProvider.class, method="insertSelective")
    int insertSelective(Apartment record);

    @SelectProvider(type=ApartmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unit_number", property="unitNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER)
    })
    List<Apartment> selectByExample(ApartmentExample example);

    @Select({
        "select",
        "id, unit_number, building_id",
        "from apartments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unit_number", property="unitNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER)
    })
    Apartment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ApartmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Apartment record, @Param("example") ApartmentExample example);

    @UpdateProvider(type=ApartmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Apartment record, @Param("example") ApartmentExample example);

    @UpdateProvider(type=ApartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Apartment record);

    @Update({
        "update apartments",
        "set unit_number = #{unitNumber,jdbcType=VARCHAR},",
          "building_id = #{buildingId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Apartment record);
}