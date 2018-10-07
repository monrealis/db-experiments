package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.mybatis.model.Apartment;
import eu.vytenis.dbe.mybatis.model.ApartmentTenantKey;
import eu.vytenis.dbe.mybatis.model.Building;
import eu.vytenis.dbe.mybatis.model.Complex;
import eu.vytenis.dbe.mybatis.model.Request;
import eu.vytenis.dbe.mybatis.model.Tenant;

class MyBatisLoaderIT {
    private MyBatisSession session = MyBatisSession.postgres();

    @AfterEach
    public void after() {
        session.rollback();
    }

    @Test
    void deleteAll() {
        session.deleteAll();
    }

    @Test
    public void insert() {
        deleteAll();
        int nComplexes = 100;
        int nBuildings = 500;
        int nApartments = 1000;
        int nRequests = 500;
        int nTenants = 100;
        int nApartmentTenants = 1000;
        for (int i = 0; i < nComplexes; ++i)
            session.complexes.insert(complex(i));
        for (int i = 0; i < nBuildings; ++i)
            session.buildings.insert(building(i, i % nComplexes));
        for (int i = 0; i < nApartments; ++i)
            session.apartments.insert(apartment(i, i % nBuildings));
        for (int i = 0; i < nRequests; ++i)
            session.requests.insert(request(i, i % nApartments));
        for (int i = 0; i < nTenants; ++i)
            session.tenants.insert(tenant(i));
        for (int i = 0; i < nApartmentTenants; ++i)
            session.apartmentTenants.insert(apartmentTenant(i % nApartments, i % nTenants));
        session.commit();
    }

    private Apartment apartment(int id, int buildingId) {
        Apartment a = new Apartment();
        a.setId(id);
        a.setUnitNumber("UN" + id);
        a.setBuildingId(buildingId);
        return a;
    }

    private Building building(int id, int complexId) {
        Building b = new Building();
        b.setId(id);
        b.setComplexId(complexId);
        b.setName("Name " + id);
        b.setAddress("Address " + id);
        return b;
    }

    private Complex complex(int id) {
        Complex c = new Complex();
        c.setId(id);
        c.setName("Complex" + id);
        return c;
    }

    private Tenant tenant(int id) {
        Tenant t = new Tenant();
        t.setId(id);
        t.setName("Name " + id);
        return t;
    }

    private Request request(int id, int apartmentId) {
        Request r = new Request();
        r.setId(id);
        r.setApartmentId(apartmentId);
        r.setStatus("NONE");
        return r;
    }

    private ApartmentTenantKey apartmentTenant(int apartmentId, int tenantId) {
        ApartmentTenantKey at = new ApartmentTenantKey();
        at.setApartmentId(apartmentId);
        at.setTenantId(tenantId);
        return at;
    }

}
