package eu.vytenis.dbe.loader;

import org.apache.ibatis.session.SqlSession;

import eu.vytenis.dbe.mybatis.client.ApartmentMapper;
import eu.vytenis.dbe.mybatis.client.ApartmentTenantMapper;
import eu.vytenis.dbe.mybatis.client.BuildingMapper;
import eu.vytenis.dbe.mybatis.client.ComplexMapper;
import eu.vytenis.dbe.mybatis.client.RequestMapper;
import eu.vytenis.dbe.mybatis.client.TenantMapper;
import eu.vytenis.dbe.mybatis.model.ApartmentExample;
import eu.vytenis.dbe.mybatis.model.ApartmentTenantExample;
import eu.vytenis.dbe.mybatis.model.BuildingExample;
import eu.vytenis.dbe.mybatis.model.ComplexExample;
import eu.vytenis.dbe.mybatis.model.RequestExample;
import eu.vytenis.dbe.mybatis.model.TenantExample;

public class MyBatisSession extends BaseSession {
    private final ApartmentMapper apartments;
    private final ApartmentTenantMapper apartmentTenants;
    private final TenantMapper tenants;
    private final BuildingMapper buildings;
    private final ComplexMapper complexes;
    private final RequestMapper requests;

    public static MyBatisSession postgres() {
        return new MyBatisSession(new Sessions().postgres());
    }

    public static MyBatisSession mysql() {
        return new MyBatisSession(new Sessions().mysql());
    }

    public static MyBatisSession vertica() {
        return new MyBatisSession(new Sessions().vertica());
    }

    public MyBatisSession(SqlSession session) {
        super(session);
        this.apartments = session.getMapper(ApartmentMapper.class);
        this.apartmentTenants = session.getMapper(ApartmentTenantMapper.class);
        this.tenants = session.getMapper(TenantMapper.class);
        this.buildings = session.getMapper(BuildingMapper.class);
        this.complexes = session.getMapper(ComplexMapper.class);
        this.requests = session.getMapper(RequestMapper.class);

    }

    @Override
    public void deleteAll() {
        apartmentTenants.deleteByExample(new ApartmentTenantExample());
        requests.deleteByExample(new RequestExample());
        apartments.deleteByExample(new ApartmentExample());
        tenants.deleteByExample(new TenantExample());
        buildings.deleteByExample(new BuildingExample());
        complexes.deleteByExample(new ComplexExample());
    }

    public ApartmentMapper apartments() {
        return apartments;
    }

    public ApartmentTenantMapper apartmentTenants() {
        return apartmentTenants;
    }

    public TenantMapper tenants() {
        return tenants;
    }

    public BuildingMapper buildings() {
        return buildings;
    }

    public ComplexMapper complexes() {
        return complexes;
    }

    public RequestMapper requests() {
        return requests;
    }
}