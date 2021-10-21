package org.r3.db.system.lut;

/**
 * The exception raised by classes of this package.
 * It usually refers to something unexpected happened
 * while trying to access a lookup table, to serialize
 * an entity to the DB and similar.
 *
 * @author GPA Gruppo Progetti Avanzati (2000)
 * @see java.lang.Exception
 *
 */
public class LUTException extends Exception
{
  /**
   * The default constructor.
   * Builds an empty LUTException exception.
   *
   */
  public LUTException()
  {
    super();
  }

  /**
   * Builds an EntityException using the provided error message.
   *
   * @param message The error message.
   *
   */
  public LUTException(String message)
  {
    super(message);
  }
}

