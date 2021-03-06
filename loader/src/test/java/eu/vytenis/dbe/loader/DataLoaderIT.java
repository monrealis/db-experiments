package eu.vytenis.dbe.loader;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import static java.util.function.Function.identity;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.MappedBatchLoader;
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

    @Test
    void mappedBatchLoader() {
        prepare();
        DataLoader<Integer, Complex> dataLoader = createMappedDataLoader();
        load(dataLoader);
    }

    private DataLoader<Integer, Complex> createDataLoader() {
        BatchLoader<Integer, Complex> batchLoader = ids -> supplyAsync(() -> selectByIds(ids));
        DataLoader<Integer, Complex> dataLoader = DataLoader.newDataLoader(batchLoader);
        return dataLoader;
    }

    private DataLoader<Integer, Complex> createMappedDataLoader() {
        MappedBatchLoader<Integer, Complex> batchLoader = ids -> supplyAsync(() -> selectComplexesByIds(ids));
        DataLoader<Integer, Complex> dataLoader = DataLoader.newMappedDataLoader(batchLoader);
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
        return dataLoader.load(id).thenAccept(c -> System.out.println(id + ":" + c.getName()))
                .thenAccept(c -> dataLoader.load(id + 100));
    }

    private List<Complex> selectByIds(List<Integer> ids) {
        Map<Integer, Complex> byId = selectComplexesByIds(new HashSet<>(ids));
        return ids.stream().map(byId::get).collect(toList());
    }

    private Map<Integer, Complex> selectComplexesByIds(Set<Integer> ids) {
        ComplexExample example = exampleByIds(ids);
        List<Complex> complexes = session.complexes().selectByExample(example);
        Map<Integer, Complex> byId = complexes.stream().collect(toMap(Complex::getId, identity()));
        return byId;
    }

    private ComplexExample exampleByIds(Collection<Integer> ids) {
        ComplexExample e = new ComplexExample();
        e.createCriteria().andIdIn(new ArrayList<>(ids));
        return e;
    }

    private Complex complex(int id) {
        Complex c = new Complex();
        c.setId(id);
        c.setName("Complex" + id);
        return c;
    }
}
