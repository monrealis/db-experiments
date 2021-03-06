package eu.vytenis.dbe.dsql.client;

import static eu.vytenis.dbe.dsql.client.ApartmentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import eu.vytenis.dbe.dsql.model.Apartment;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface ApartmentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Apartment> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ApartmentResult")
    Apartment selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApartmentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unit_number", property="unitNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.INTEGER)
    })
    List<Apartment> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(apartment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, apartment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, apartment)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Apartment record) {
        return insert(SqlBuilder.insert(record)
                .into(apartment)
                .map(id).toProperty("id")
                .map(unitNumber).toProperty("unitNumber")
                .map(buildingId).toProperty("buildingId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Apartment record) {
        return insert(SqlBuilder.insert(record)
                .into(apartment)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(unitNumber).toPropertyWhenPresent("unitNumber", record::getUnitNumber)
                .map(buildingId).toPropertyWhenPresent("buildingId", record::getBuildingId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Apartment>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, unitNumber, buildingId)
                .from(apartment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Apartment>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, unitNumber, buildingId)
                .from(apartment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Apartment selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, unitNumber, buildingId)
                .from(apartment)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Apartment record) {
        return UpdateDSL.updateWithMapper(this::update, apartment)
                .set(id).equalTo(record::getId)
                .set(unitNumber).equalTo(record::getUnitNumber)
                .set(buildingId).equalTo(record::getBuildingId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Apartment record) {
        return UpdateDSL.updateWithMapper(this::update, apartment)
                .set(id).equalToWhenPresent(record::getId)
                .set(unitNumber).equalToWhenPresent(record::getUnitNumber)
                .set(buildingId).equalToWhenPresent(record::getBuildingId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Apartment record) {
        return UpdateDSL.updateWithMapper(this::update, apartment)
                .set(unitNumber).equalTo(record::getUnitNumber)
                .set(buildingId).equalTo(record::getBuildingId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Apartment record) {
        return UpdateDSL.updateWithMapper(this::update, apartment)
                .set(unitNumber).equalToWhenPresent(record::getUnitNumber)
                .set(buildingId).equalToWhenPresent(record::getBuildingId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}