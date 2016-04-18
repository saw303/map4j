package ch.silviowangler.map4j.mapstruct;

import ch.silviowangler.map4j.Mapper;

/**
 * Created by Silvio Wangler on 14/04/16.
 */
public class MapStructMapper implements Mapper
{

   private final MapperRegistry registry;

   public MapStructMapper (MapperRegistry registry)
   {
      this.registry = registry;
   }

   @Override
   public <T> T map (Object source, Class<T> targetClass)
   {
      MapperWrapper callable = (MapperWrapper) registry.resolveConsumer (source.getClass (), targetClass);

      callable.setSource (source);
      try
      {
         return (T) callable.call ();
      }
      catch (Exception e)
      {
         throw new RuntimeException (e);
      }
   }

   @Override
   public <T> void map (Object source, T target)
   {
      MapperWrapper callable = (MapperWrapper) registry.resolveConsumer (source.getClass (), target.getClass ());

      callable.setSource (source);
      callable.setTarget (target);

      try
      {
         callable.call ();
      }
      catch (Exception e)
      {
         throw new RuntimeException (e);
      }
   }
}
