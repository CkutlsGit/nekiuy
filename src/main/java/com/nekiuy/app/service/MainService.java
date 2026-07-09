package com.nekiuy.app.service;

import com.nekiuy.app.model.People;
import com.nekiuy.app.model.Regiment;
import com.nekiuy.app.repository.PeopleRepository;
import com.nekiuy.app.repository.RegimentRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class MainService {

    private final Map<Class<?>, Function<Object, Object>> saveFunctions = new HashMap<>();
    private final Map<Class<?>, Function<Object, Object>> findFunctions = new HashMap<>();
    private final Map<Class<?>, Supplier<Iterable<?>>> findAllFunctions = new HashMap<>();

    public MainService(RegimentRepository regimentRepository, PeopleRepository peopleRepository) {
        saveFunctions.put(Regiment.class, entity -> regimentRepository.save((Regiment) entity));
        saveFunctions.put(People.class, entity -> peopleRepository.save((People) entity));

        findFunctions.put(Regiment.class, id -> regimentRepository.findById((Integer) id));

        findAllFunctions.put(Regiment.class, regimentRepository::findAll);
    }

    @SuppressWarnings("unchecked")
    public <T> T saveEntity(T entity, Class<T> entityClass) {
        return (T) saveFunctions.get(entityClass).apply(entity);
    }

    @SuppressWarnings("unchecked")
    public <T, ID extends Number> Optional<T> findEntity(ID id, Class<T> entityClass) {
        Function<Object, Object> findFunction = findFunctions.get(entityClass);

        if (findFunction == null) {
            return Optional.empty();
        }

        Object result = findFunction.apply(id);

        if (result instanceof Optional) {
            return (Optional<T>) result;
        }

        return Optional.ofNullable((T) result);
    }

    @SuppressWarnings("unchecked")
    public <T> Iterable<T> getAllEntity(Class<T> entityClass) {
        return (Iterable<T>) findAllFunctions.get(entityClass).get();
    }
}
