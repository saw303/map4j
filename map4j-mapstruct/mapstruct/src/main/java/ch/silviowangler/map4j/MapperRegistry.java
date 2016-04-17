package ch.silviowangler.map4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Silvio Wangler on 16/04/16.
 */
public final class MapperRegistry {

    private Map<CombinedClassKey, BiFunction> mappers = new HashMap<>();

    public void addMapping(Class aClass, Class bClass, BiFunction function) {
        mappers.put(new CombinedClassKey(aClass, bClass), function);
    }

    public <T> BiFunction resolveConsumer(Class<?> sourceClass, Class<T> targetClass) {

        BiFunction c =  Optional.of(mappers.get(new CombinedClassKey(sourceClass, targetClass)))
                .orElseThrow(() -> new RuntimeException());

        return c;
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
