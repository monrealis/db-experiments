package eu.vytenis.dbe.client;

import eu.vytenis.dbe.model.Apartments;
import eu.vytenis.dbe.model.ApartmentsExample;
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

public interface ApartmentsMapper {
    @SelectProvider(type=ApartmentsSqlProvider.class, method="countByExample")
    long countByExample(ApartmentsExample example);

    @DeleteProvider(type=ApartmentsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ApartmentsExample example);

    @Delete({
        "delete from apartments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into apartments (id)",
        "values (#{id,jdbcType=INTEGER})"
    })
    int insert(Apartments record);

    @InsertProvider(type=ApartmentsSqlProvider.class, method="insertSelective")
    int insertSelective(Apartments record);

    @SelectProvider(type=ApartmentsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<Apartments> selectByExample(ApartmentsExample example);

    @UpdateProvider(type=ApartmentsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Apartments record, @Param("example") ApartmentsExample example);

    @UpdateProvider(type=ApartmentsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Apartments record, @Param("example") ApartmentsExample example);
}