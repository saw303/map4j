package ch.silviowangler.map4j.mapstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Created by Silvio Wangler on 16/04/16.
 */
public final class MapperRegistry {

    private Map<CombinedClassKey, Callable> mappers = new HashMap<>();

    public void addMapping(Class aClass, Class bClass, Callable callable) {
        mappers.put(new CombinedClassKey(aClass, bClass), callable);
    }

    public <T> Callable<MapperWrapper> resolveConsumer(Class<?> sourceClass, Class<T> targetClass) {

        CombinedClassKey key = new CombinedClassKey(sourceClass, targetClass);
        if (mappers.containsKey(key)) {

            Callable callable = mappers.get(key);
            return callable;
        }
        else {
            throw new NoSuchMappingException("No such mapping for source class " + sourceClass.getSimpleName() + " and target class " + targetClass.getSimpleName(), sourceClass, targetClass);
        }
    }

    private static class CombinedClassKey {

        private Class a;
        private Class b;

        public CombinedClassKey(Class a, Class b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CombinedClassKey)) return false;
            CombinedClassKey that = (CombinedClassKey) o;
            return Objects.equals(a, that.a) &&
                    Objects.equals(b, that.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
