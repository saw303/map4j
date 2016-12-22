package ch.silviowangler.map4j.mapstruct;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Silvio Wangler on 18/04/16.
 */
public interface InverseBaseMapper<S, T> extends BaseMapper<S, T>{

    S createFromSourceInverse(T source);

    default void updateFromSourceInverse(T source, S target) {
        throw new NotImplementedException();
    }

}
