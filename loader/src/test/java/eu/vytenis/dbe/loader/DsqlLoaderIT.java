package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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
}
