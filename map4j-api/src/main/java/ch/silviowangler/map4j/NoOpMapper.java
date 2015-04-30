package ch.silviowangler.map4j;

/**
 * Created by Silvio Wangler on 30.04.15.
 *
 * @author Silvio Wangler
 */
public class NoOpMapper implements Mapper {

    @Override
    public <T> T map(Object source, Class<T> targetClass) {
        return null;
    }
}
