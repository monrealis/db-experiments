package eu.vytenis.dbe.dsql.client;

import static eu.vytenis.dbe.dsql.client.RequestDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import eu.vytenis.dbe.dsql.model.Request;
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
public interface RequestMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Request> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RequestResult")
    Request selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RequestResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="apartment_id", property="apartmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<Request> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(request);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, request);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, request)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Request record) {
        return insert(SqlBuilder.insert(record)
                .into(request)
                .map(id).toProperty("id")
                .map(status).toProperty("status")
                .map(apartmentId).toProperty("apartmentId")
                .map(description).toProperty("description")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Request record) {
        return insert(SqlBuilder.insert(record)
                .into(request)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(status).toPropertyWhenPresent("status", record::getStatus)
                .map(apartmentId).toPropertyWhenPresent("apartmentId", record::getApartmentId)
                .map(description).toPropertyWhenPresent("description", record::getDescription)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Request>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, status, apartmentId, description)
                .from(request);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Request>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, status, apartmentId, description)
                .from(request);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Request selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, status, apartmentId, description)
                .from(request)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Request record) {
        return UpdateDSL.updateWithMapper(this::update, request)
                .set(id).equalTo(record::getId)
                .set(status).equalTo(record::getStatus)
                .set(apartmentId).equalTo(record::getApartmentId)
                .set(description).equalTo(record::getDescription);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Request record) {
        return UpdateDSL.updateWithMapper(this::update, request)
                .set(id).equalToWhenPresent(record::getId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(apartmentId).equalToWhenPresent(record::getApartmentId)
                .set(description).equalToWhenPresent(record::getDescription);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Request record) {
        return UpdateDSL.updateWithMapper(this::update, request)
                .set(status).equalTo(record::getStatus)
                .set(apartmentId).equalTo(record::getApartmentId)
                .set(description).equalTo(record::getDescription)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Request record) {
        return UpdateDSL.updateWithMapper(this::update, request)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(apartmentId).equalToWhenPresent(record::getApartmentId)
                .set(description).equalToWhenPresent(record::getDescription)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}