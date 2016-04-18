package ch.silviowangler.map4j;

import java.util.concurrent.Callable;

/**
 * Created by Silvio Wangler on 18/04/16.
 */
public abstract class MapperWrapper implements Callable
{

   private Object source;
   private Object target;

   public void setSource (Object source)
   {
      this.source = source;
   }

   public void setTarget (Object target)
   {
      this.target = target;
   }

    public Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }
}
