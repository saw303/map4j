package ch.silviowangler.map4j.mapstruct;

/**
 * Created by Silvio Wangler on 20/06/16.
 */
public final class NoSuchMappingException extends RuntimeException {

    private final Class source;
    private final Class target;

    public NoSuchMappingException(String message, Class source, Class target) {
        super(message);
        this.source = source;
        this.target = target;
    }

    public NoSuchMappingException(String message, Throwable cause, Class source, Class target) {
        super(message, cause);
        this.source = source;
        this.target = target;
    }

    public Class getSource() {
        return source;
    }

    public Class getTarget() {
        return target;
    }
}
