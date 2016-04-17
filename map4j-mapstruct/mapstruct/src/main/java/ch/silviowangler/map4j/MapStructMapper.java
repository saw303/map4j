package ch.silviowangler.map4j;

import java.util.function.BiFunction;

/**
 * Created by Silvio Wangler on 14/04/16.
 */
public class MapStructMapper implements Mapper {


    private final MapperRegistry registry;

    public MapStructMapper(MapperRegistry registry) {
        this.registry = registry;
    }

    @Override
    public <T> T map(Object source, Class<T> targetClass) {
        BiFunction function = registry.resolveConsumer(source.getClass(), targetClass);
        return (T) function.apply(source, null);
    }

    @Override
    public <T> void map(Object source, T target) {
        BiFunction function = registry.resolveConsumer(source.getClass(), target.getClass());
        function.apply(source, target);
    }
}
