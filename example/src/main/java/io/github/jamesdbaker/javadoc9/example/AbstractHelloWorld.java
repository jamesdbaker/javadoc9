package io.github.jamesdbaker.javadoc9.example;

public abstract class AbstractHelloWorld {

  /**
   * Default greeting message
   *
   * @language English
   */
  public static String MESSAGE_DEFAULT = "Hello";

  public abstract String getGreeting();

  /**
   * Prints a hello message to the names provided
   *
   * @param names
   *    The names to say hello to
   */
  protected void sayHello(String[] names){
    if(names.length == 0){
      sayHello("World");
    }else{
      for(String name : names){
        sayHello(name);
      }
    }
  }

  /**
   * Prints a hello message to the name provided
   *
   * @param name
   *    The name to say hello to
   */
  protected void sayHello(String name){
    System.out.println(getGreeting() + " "+name);
  }
}
