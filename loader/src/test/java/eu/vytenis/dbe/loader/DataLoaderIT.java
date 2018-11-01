package eu.vytenis.dbe.loader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.mybatis.model.Complex;

public class DataLoaderIT {
    private MyBatisSession session = MyBatisSession.postgres();

    @AfterEach
    public void after() {
        session.rollback();
    }

    @Test
    void run() {
        session.deleteAll();
        for (int i = 0; i < 2; ++i)
            session.complexes().insert(complex(i));
    }

    private Complex complex(int id) {
        Complex c = new Complex();
        c.setId(id);
        c.setName("Complex" + id);
        return c;
    }
}
