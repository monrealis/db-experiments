package eu.vytenis.dbe.loader;

import org.apache.ibatis.session.SqlSession;

import eu.vytenis.dbe.dsql.client.ApartmentMapper;
import eu.vytenis.dbe.dsql.client.ApartmentTenantMapper;
import eu.vytenis.dbe.dsql.client.BuildingMapper;
import eu.vytenis.dbe.dsql.client.ComplexMapper;
import eu.vytenis.dbe.dsql.client.RequestMapper;
import eu.vytenis.dbe.dsql.client.TenantMapper;

public class DsqlSession extends BaseSession {
    public final ApartmentMapper apartments;
    public final ApartmentTenantMapper apartmentTenants;
    public final TenantMapper tenants;
    public final BuildingMapper buildings;
    public final ComplexMapper complexes;
    public final RequestMapper requests;

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
        apartments.deleteByExample().build().execute();
        apartmentTenants.deleteByExample().build().execute();
        tenants.deleteByExample().build().execute();
        buildings.deleteByExample().build().execute();
        complexes.deleteByExample().build().execute();
        requests.deleteByExample().build().execute();
    }
}