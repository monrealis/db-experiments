package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.dsql.model.Complex;
import static eu.vytenis.dbe.dsql.client.ComplexDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

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
    }

    @Test
    void update() {
        session.deleteAll();
        session.complexes().insert(complex(1));
        updateOne(1);
    }

    @Test
    void delete() {
        session.deleteAll();
        session.complexes().insert(complex(1));
        deleteOne(1);
    }

    private void updateOne(int complexId) {
        Complex c = new Complex();
        c.setId(1);
        session.complexes().updateByExampleSelective(c).where(id, isEqualTo(complexId)).build().execute();
    }

    private void deleteOne(int complexId) {
        session.complexes().deleteByExample().where(id, isEqualTo(complexId)).build().execute();
    }

    private Complex complex(int id) {
        Complex c = new Complex();
        c.setId(id);
        c.setName("Complex " + id);
        return c;
    }
}
