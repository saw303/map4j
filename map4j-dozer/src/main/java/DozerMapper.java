import org.dozer.DozerBeanMapper;

import ch.silviowangler.map4j.Mapper;

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
}
