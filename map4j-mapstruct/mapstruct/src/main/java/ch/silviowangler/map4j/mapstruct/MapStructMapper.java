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

    /**
     * Maps an object to another object with the registered MapStruct Mapper.
     * The return object will be created within this method
     * @param source source map object instance
     * @param targetClass target class
     * @param <T> the type of the return instance object
     * @return the mapped object
     */
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
        if(function != null) {
            return (T) function.apply(source, null);
        }
        throw new NoSuchMappingException ("No such mapping for source class " + source.getClass().getSimpleName () + " and target class "
                + targetClass.getSimpleName (), source.getClass(), targetClass);
    }

    /**
     * Maps an object to another object with the registered MapStruct Mapper.
     * The target object will be update by the source objects attributes
     * @param source source map object instance
     * @param target target class
     * @param <T> the type of the target object
     */
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
        if(function != null) {
            function.apply(source, target);
            return;
        }
        throw new NoSuchMappingException ("No such mapping for source class " + source.getClass().getSimpleName () + " and target class "
                + target.getClass().getSimpleName (), source.getClass(), target.getClass());

    }
}
