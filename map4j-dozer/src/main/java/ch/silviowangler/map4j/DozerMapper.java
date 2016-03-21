package ch.silviowangler.map4j;

import org.dozer.DozerBeanMapper;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public class DozerMapper implements Mapper
{

   private DozerBeanMapper dozerBeanMapper;

   public DozerMapper(DozerBeanMapper dozerBeanMapper) {
      this.dozerBeanMapper = dozerBeanMapper;
   }

   @Override
   public <T> T map (Object source, Class<T> targetClass)
   {
      return dozerBeanMapper.map (source, targetClass);
   }

   @Override
   public <T> void map(Object source, T target) {
      dozerBeanMapper.map(source, target);
   }
}
