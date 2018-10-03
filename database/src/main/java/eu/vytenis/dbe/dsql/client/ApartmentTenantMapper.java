package eu.vytenis.dbe.dsql.client;

import static eu.vytenis.dbe.dsql.client.ApartmentTenantDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import eu.vytenis.dbe.dsql.model.ApartmentTenant;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
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
public interface ApartmentTenantMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ApartmentTenant> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApartmentTenantResult", value = {
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="apartment_id", property="apartmentId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<ApartmentTenant> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(apartmentTenant);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, apartmentTenant);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer tenantId_, Integer apartmentId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, apartmentTenant)
                .where(tenantId, isEqualTo(tenantId_))
                .and(apartmentId, isEqualTo(apartmentId_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ApartmentTenant record) {
        return insert(SqlBuilder.insert(record)
                .into(apartmentTenant)
                .map(tenantId).toProperty("tenantId")
                .map(apartmentId).toProperty("apartmentId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ApartmentTenant record) {
        return insert(SqlBuilder.insert(record)
                .into(apartmentTenant)
                .map(tenantId).toPropertyWhenPresent("tenantId", record::getTenantId)
                .map(apartmentId).toPropertyWhenPresent("apartmentId", record::getApartmentId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<ApartmentTenant>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, tenantId, apartmentId)
                .from(apartmentTenant);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<ApartmentTenant>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, tenantId, apartmentId)
                .from(apartmentTenant);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(ApartmentTenant record) {
        return UpdateDSL.updateWithMapper(this::update, apartmentTenant)
                .set(tenantId).equalTo(record::getTenantId)
                .set(apartmentId).equalTo(record::getApartmentId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(ApartmentTenant record) {
        return UpdateDSL.updateWithMapper(this::update, apartmentTenant)
                .set(tenantId).equalToWhenPresent(record::getTenantId)
                .set(apartmentId).equalToWhenPresent(record::getApartmentId);
    }
}