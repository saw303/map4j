package ch.silviowangler.map4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public class NoOpMapper implements Mapper
{

   private static final Logger logger = LoggerFactory.getLogger(NoOpMapper.class);

   @Override
   public <T> T map (Object source, Class<T> targetClass)
   {
      try
      {
         return targetClass.newInstance ();
      }
      catch (InstantiationException | IllegalAccessException e)
      {
         logger.error("Exception occurred while mapping", e);
         throw new RuntimeException(e);
      }
   }

   @Override
   public <T> void map (Object source, T target)
   {
      // do nothing
   }
}
