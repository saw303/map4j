package ch.silviowangler.map4j;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public interface Mapper {

    <T> T map(Object source, Class<T> targetClass);
}
