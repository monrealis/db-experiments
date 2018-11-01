package eu.vytenis.dbe.loader;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import eu.vytenis.dbe.mybatis.model.Complex;
import eu.vytenis.dbe.mybatis.model.ComplexExample;

public class DataLoaderIT {
    private MyBatisSession session = MyBatisSession.postgres();

    @AfterEach
    public void after() {
        session.rollback();
    }

    @Test
    void batchLoader() {
        prepare();
        DataLoader<Integer, Complex> dataLoader = createDataLoader();
        load(dataLoader);
    }

    private DataLoader<Integer, Complex> createDataLoader() {
        BatchLoader<Integer, Complex> batchLoader = ids -> supplyAsync(() -> selectByIds(ids));
        DataLoader<Integer, Complex> dataLoader = DataLoader.newDataLoader(batchLoader);
        return dataLoader;
    }

    private void load(DataLoader<Integer, Complex> dataLoader) {
        for (int i = 0; i < 2; ++i)
            load(dataLoader, i);
        List<Complex> complexes = dataLoader.dispatchAndJoin();
        System.out.println(complexes.size());
    }

    private void prepare() {
        session.deleteAll();
        for (int i = 0; i < 10; ++i)
            session.complexes().insert(complex(i));
    }

    private CompletableFuture<Void> load(DataLoader<Integer, Complex> dataLoader, int id) {
        return dataLoader.load(id).thenAccept(c -> System.out.println(id + ":" + c.getName()));
    }

    private List<Complex> selectByIds(List<Integer> ids) {
        ComplexExample e = exampleByIds(ids);
        List<Complex> c = session.complexes().selectByExample(e);
        return c;
    }

    private ComplexExample exampleByIds(List<Integer> ids) {
        ComplexExample e = new ComplexExample();
        e.createCriteria().andIdIn(ids);
        return e;
    }

    private Complex complex(int id) {
        Complex c = new Complex();
        c.setId(id);
        c.setName("Complex" + id);
        return c;
    }
}
