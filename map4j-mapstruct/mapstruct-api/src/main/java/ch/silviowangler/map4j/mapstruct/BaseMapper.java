package ch.silviowangler.map4j.mapstruct;

/**
 * Created by Silvio Wangler on 18/04/16.
 */
public interface BaseMapper<S, T> {

    T createFromSource(S source);

    void updateFromSource(S source, T target);
}
