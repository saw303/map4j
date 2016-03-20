package ch.silviowangler.map4j;

import ma.glasnost.orika.MapperFacade;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public class OrikaMapper implements Mapper
{

   private MapperFacade mapperFacade;

   public OrikaMapper (MapperFacade mapperFacade)
   {
      this.mapperFacade = mapperFacade;
   }

   @Override
   public <T> T map (Object source, Class<T> targetClass)
   {
      return mapperFacade.map (source, targetClass);
   }
}
