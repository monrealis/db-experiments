package eu.vytenis.dbe.mybatis.client;

import eu.vytenis.dbe.mybatis.model.Complex;
import eu.vytenis.dbe.mybatis.model.ComplexExample;
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

public interface ComplexMapper {
    @SelectProvider(type=ComplexSqlProvider.class, method="countByExample")
    long countByExample(ComplexExample example);

    @DeleteProvider(type=ComplexSqlProvider.class, method="deleteByExample")
    int deleteByExample(ComplexExample example);

    @Delete({
        "delete from complexes",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into complexes (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Complex record);

    @InsertProvider(type=ComplexSqlProvider.class, method="insertSelective")
    int insertSelective(Complex record);

    @SelectProvider(type=ComplexSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Complex> selectByExample(ComplexExample example);

    @Select({
        "select",
        "id, name",
        "from complexes",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Complex selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ComplexSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Complex record, @Param("example") ComplexExample example);

    @UpdateProvider(type=ComplexSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Complex record, @Param("example") ComplexExample example);

    @UpdateProvider(type=ComplexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Complex record);

    @Update({
        "update complexes",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Complex record);
}