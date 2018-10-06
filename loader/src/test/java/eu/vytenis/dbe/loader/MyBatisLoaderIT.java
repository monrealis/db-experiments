package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.mybatis.model.Apartment;
import eu.vytenis.dbe.mybatis.model.Building;

class MyBatisLoaderIT {
    private MyBatisSession session = MyBatisSession.vertica();

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
        Building b = new Building();
        for (int i = 0; i < 50; ++i) {
            b.setId(i);
            b.setComplexId(1);
            b.setName("Name " + i);
            b.setAddress("Address " + i);
            session.buildings.insert(b);
        }
        Apartment a = new Apartment();
        for (int i = 0; i < 100; ++i) {
            a.setId(i);
            a.setUnitNumber("UN" + i);
            a.setBuildingId(i / 2);
            session.apartments.insert(a);
        }

        session.commit();
    }
}
