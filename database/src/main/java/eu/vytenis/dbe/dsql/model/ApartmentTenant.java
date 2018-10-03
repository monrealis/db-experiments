package eu.vytenis.dbe.dsql.model;

import javax.annotation.Generated;

public class ApartmentTenant {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer tenantId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer apartmentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTenantId() {
        return tenantId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getApartmentId() {
        return apartmentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }
}