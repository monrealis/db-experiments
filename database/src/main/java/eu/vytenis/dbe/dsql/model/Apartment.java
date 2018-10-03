package eu.vytenis.dbe.dsql.model;

import javax.annotation.Generated;

public class Apartment {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String unitNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer buildingId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUnitNumber() {
        return unitNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getBuildingId() {
        return buildingId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}