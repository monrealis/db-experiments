package eu.vytenis.dbe.loader;

import org.apache.ibatis.session.SqlSession;

import eu.vytenis.dbe.dsql.client.ApartmentMapper;
import eu.vytenis.dbe.dsql.client.ApartmentTenantMapper;
import eu.vytenis.dbe.dsql.client.BuildingMapper;
import eu.vytenis.dbe.dsql.client.ComplexMapper;
import eu.vytenis.dbe.dsql.client.RequestMapper;
import eu.vytenis.dbe.dsql.client.TenantMapper;

public class DsqlSession extends BaseSession {
    private final ApartmentMapper apartments;
    private final ApartmentTenantMapper apartmentTenants;
    private final TenantMapper tenants;
    private final BuildingMapper buildings;
    private final ComplexMapper complexes;
    private final RequestMapper requests;

    public static DsqlSession postgres() {
        return new DsqlSession(new Sessions().postgres());
    }

    public static DsqlSession mysql() {
        return new DsqlSession(new Sessions().mysql());
    }

    public static DsqlSession vertica() {
        return new DsqlSession(new Sessions().vertica());
    }

    public DsqlSession(SqlSession session) {
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
        apartments.deleteByExample();
        apartmentTenants.deleteByExample();
        tenants.deleteByExample();
        buildings.deleteByExample();
        complexes.deleteByExample();
        requests.deleteByExample();
    }
}