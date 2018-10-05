package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.Request;
import eu.vytenis.dbe.mybatis.model.RequestExample;
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

public interface RequestMapper {
    @SelectProvider(type=RequestSqlProvider.class, method="countByExample")
    long countByExample(RequestExample example);

    @DeleteProvider(type=RequestSqlProvider.class, method="deleteByExample")
    int deleteByExample(RequestExample example);

    @Delete({
        "delete from requests",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into requests (id, status, ",
        "apartment_id, description)",
        "values (#{id,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR}, ",
        "#{apartmentId,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(Request record);

    @InsertProvider(type=RequestSqlProvider.class, method="insertSelective")
    int insertSelective(Request record);

    @SelectProvider(type=RequestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="apartment_id", property="apartmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<Request> selectByExample(RequestExample example);

    @Select({
        "select",
        "id, status, apartment_id, description",
        "from requests",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="apartment_id", property="apartmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Request selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RequestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Request record, @Param("example") RequestExample example);

    @UpdateProvider(type=RequestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Request record, @Param("example") RequestExample example);

    @UpdateProvider(type=RequestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Request record);

    @Update({
        "update requests",
        "set status = #{status,jdbcType=VARCHAR},",
          "apartment_id = #{apartmentId,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Request record);
}