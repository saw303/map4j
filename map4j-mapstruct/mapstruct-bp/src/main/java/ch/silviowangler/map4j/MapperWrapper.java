package ch.silviowangler.map4j;

import java.util.concurrent.Callable;

/**
 * Created by Silvio Wangler on 18/04/16.
 */
public abstract class MapperWrapper<S, T> implements Callable
{

   private S source;
   private T target;

   public void setSource (S source)
   {
      this.source = source;
   }

   public void setTarget (T target)
   {
      this.target = target;
   }

   public abstract T createInstance(S source);

   public abstract void updateInstance(S source, T target);

   @Override
   public Object call () throws Exception
   {

      if (this.target == null)
      {
         return createInstance(this.source);
      }
      updateInstance(this.source, this.target);
      return this.target;
   }
}
