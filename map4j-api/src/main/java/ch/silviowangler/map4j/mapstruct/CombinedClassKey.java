package ch.silviowangler.map4j.mapstruct;

import java.util.Objects;

/**
 * Created by Silvio Wangler on 21/06/16.
 */
final class CombinedClassKey
{

   private Class a;
   private Class b;

   public CombinedClassKey (Class a, Class b)
   {
      this.a = removeProxyStuff (a);
      this.b = removeProxyStuff (b);
   }

   @Override
   public boolean equals (Object o)
   {
      if (this == o) return true;
      if (!(o instanceof CombinedClassKey)) return false;
      CombinedClassKey that = (CombinedClassKey) o;
      return Objects.equals (a, that.a) && Objects.equals (b, that.b);
   }

   @Override
   public int hashCode ()
   {
      return Objects.hash (a, b);
   }

   private Class removeProxyStuff (Class clazz)
   {

      if (clazz.getCanonicalName ().contains ("$$EnhancerByCGLIB"))
      {
          try {
              return Class.forName (clazz.getCanonicalName ().split ("\\$\\$")[0]);
          } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
          }
      }
      return clazz;
   }

   public Class getA() {
      return a;
   }

   public Class getB() {
      return b;
   }
}
