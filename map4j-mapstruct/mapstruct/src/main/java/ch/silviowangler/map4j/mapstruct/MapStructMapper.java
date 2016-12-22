package ch.silviowangler.map4j.mapstruct;

import java.util.function.BiFunction;

import ch.silviowangler.map4j.Mapper;
import org.mapstruct.factory.Mappers;

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
        BaseMapper baseMapper = registry.resolveBaseMapper(source.getClass(), targetClass);
        if(baseMapper != null) {
            return (T) baseMapper.createFromSource(source);
        }
        InverseBaseMapper inverseBaseMapper = registry.resolveInverseMapper(source.getClass(), targetClass);
        if(inverseBaseMapper != null) {
            return (T) inverseBaseMapper.createFromSourceInverse(source);
        }
        BiFunction function = registry.resolveConsumer(source.getClass(), targetClass);
        return (T) function.apply(source, null);
    }

    @Override
    public <T> void map(Object source, T target) {
        BaseMapper baseMapper = registry.resolveBaseMapper(source.getClass(), target.getClass());
        if(baseMapper != null) {
            baseMapper.updateFromSource(source, target);
            return;
        }
        InverseBaseMapper inverseBaseMapper = registry.resolveInverseMapper(source.getClass(), target.getClass());
        if(inverseBaseMapper != null) {
            inverseBaseMapper.updateFromSourceInverse(source, target);
            return;
        }
        BiFunction function = registry.resolveConsumer(source.getClass(), target.getClass());
        function.apply(source, target);
    }
}
