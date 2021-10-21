package org.r3.system.util;

import java.util.ArrayList;

public class Queue extends ArrayList
{
  private static final int DEFAULT_QUEUE_CAPACITY = 64;

  public Queue()
  {
    super(DEFAULT_QUEUE_CAPACITY);
  }


  public Queue(int capacity)
  {
    super(capacity);
  }

  public void insert(Object object)
  {
    add(object);
  }


  public Object get()
  {
    if(isEmpty())
      return null;

    return this.get(0);
  }


  public Object remove()
  {
    if(isEmpty())
      return null;

    Object ret = get(0);
    this.remove(0);

    return ret;
  }
}
