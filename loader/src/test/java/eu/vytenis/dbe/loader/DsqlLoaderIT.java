package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.dsql.model.Complex;

class DsqlLoaderIT {
    private DsqlSession session = DsqlSession.vertica();

    @AfterEach
    void after() {
        session.rollback();
    }

    @Test
    void deleteAll() {
        session.deleteAll();
    }
    
    @Test
    void insert() {
        session.deleteAll();
        Complex c = new Complex();
        c.setId(1);
        c.setName("Complex 1");
        session.complexes.insert(c);
    }
}
