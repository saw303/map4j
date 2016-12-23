package ch.silviowangler.map4j.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Created by Silvio Wangler on 16/04/16.
 */
public final class MapperRegistry
{

   private Map<CombinedClassKey, BiFunction> mappers = new HashMap<> ();
   private Map<CombinedClassKey, Class<? extends  BaseMapper>> baseMappers = new HashMap<> ();
   private Map<CombinedClassKey, Class<? extends  InverseBaseMapper>> inverseBaseMappers = new HashMap<> ();

   /**
    * Add a mappingfunction to the registry for a mapping from aClass to bClass.
    * Your have to define the BiFunction by your own.
    * @param aClass the source object to map from
    * @param bClass the target object to map to
    * @param function this function will be called for mapping
    */
   public void addMapping (Class aClass, Class bClass, BiFunction function) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (aClass, bClass);
      checkAlreadyMappingDefined(combinedClassKey);
      mappers.put (new CombinedClassKey (aClass, bClass), function);
   }

   /**
    * Resolve the mapping function to map from sourceClass to targetClass
    * @param sourceClass to map from
    * @param targetClass to map to
    * @return the function for the specific mapping
    */
   public BiFunction resolveConsumer (Class sourceClass, Class targetClass) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (sourceClass, targetClass);
      return mappers.get (combinedClassKey);
   }

   /**
    * Adds a BaseMapper to map from source to target. It is not possible to map from target back to source.
    * Use an InverseBaseMapper instead in this case.
    * @param source to map from
    * @param target to map to
    * @param baseMapper the mapper for this two objects to map
    */
   public void addBaseMapping(Class source, Class target, Class<? extends BaseMapper> baseMapper) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (source, target);
      checkAlreadyMappingDefined(combinedClassKey);
      baseMapper.getInterfaces();
      baseMappers.put (combinedClassKey, baseMapper);
   }

   /**
    * Adds a InverseBaseMapper to map from source to target and also a inverse mapping back form target to source.
    *
    * @param source to map from
    * @param target to map to
    * @param inverseBaseMapper the mapper for this two objects to map forward and inverse
    */
   public void addInverseBaseMapping(Class source, Class target, Class<? extends InverseBaseMapper> inverseBaseMapper) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (source, target);
      checkAlreadyMappingDefined(combinedClassKey);
      baseMappers.put (combinedClassKey, inverseBaseMapper);
      final CombinedClassKey combinedClassKeyInverse = new CombinedClassKey (target, source);
      checkAlreadyMappingDefined(combinedClassKeyInverse);
      inverseBaseMappers.put (combinedClassKeyInverse, inverseBaseMapper);
   }

   public BaseMapper resolveBaseMapper(Class sourceClass, Class targetClass) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (sourceClass, targetClass);
      Class<? extends BaseMapper> basemapperClass = baseMappers.get(combinedClassKey);
      if(basemapperClass != null) {
         return Mappers.getMapper(basemapperClass);
      }
      return null;
   }

   public InverseBaseMapper resolveInverseMapper(Class<?> sourceClass, Class targetClass) {
      final CombinedClassKey combinedClassKey = new CombinedClassKey (sourceClass, targetClass);
      Class<? extends InverseBaseMapper> inverseBasemapperClass = inverseBaseMappers.get(combinedClassKey);
      if(inverseBasemapperClass != null) {
         return Mappers.getMapper(inverseBasemapperClass);
      }
      return null;
   }

   private <S, T> void checkAlreadyMappingDefined(CombinedClassKey combinedClassKey) {
      if(mappers.containsKey(combinedClassKey) || baseMappers.containsKey(combinedClassKey) || inverseBaseMappers.containsKey(combinedClassKey)) {
         throw new IllegalArgumentException("Mapping is already defined for source class " + combinedClassKey.getA ().getSimpleName () + " and target class "
                 + combinedClassKey.getB ().getSimpleName ());
      }
   }


}
