package eu.vytenis.dbe.loader;

import org.apache.ibatis.session.SqlSession;

public abstract class BaseSession {
    protected final SqlSession session;

    protected BaseSession(SqlSession session) {
        this.session = session;
    }

    public void commit() {
        session.commit();
    }

    public void rollback() {
        session.rollback();
    }

    public abstract void deleteAll();
}