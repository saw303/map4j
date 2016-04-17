package ch.silviowangler.map4j;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public interface Mapper
{
   /**
    * Maps the source object onto a new instance of the target class
    * @param source source object instance
    * @param targetClass target class
    * @param <T> target class type
    * @return a new instance of the target class
    * @throws NoMapperRegisteredException
    */
   <T> T map (Object source, Class<T> targetClass) throws NoMapperRegisteredException;

   /**
    * Maps the source object onto a given target instance
    * @param source source object instance
    * @param target target object instance
    * @return the target instance
    * @throws NoMapperRegisteredException
    */
   <T> void map (Object source, T target) throws NoMapperRegisteredException;
}
