package ch.silviowangler.map4j.mapstruct;

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

   public void addMapping (Class aClass, Class bClass, BiFunction function)
   {
      mappers.put (new CombinedClassKey (aClass, bClass), function);
   }

   public <T> BiFunction resolveConsumer (Class<?> sourceClass, Class<T> targetClass)
   {

      NoSuchMappingException ex = new NoSuchMappingException ("No such mapping for source class " + sourceClass.getSimpleName () + " and target class " + targetClass.getSimpleName (),
                                                              sourceClass,
                                                              targetClass);

      BiFunction c = Optional.of (mappers.get (new CombinedClassKey(sourceClass, targetClass))).orElseThrow ( () -> ex);

      return c;
   }
}
