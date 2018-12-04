package io.github.jamesdbaker.javadoc9.example;

/**
 * Example class that's very friendly and says hello to everyone in French!
 *
 * @author James Baker
 * @coder James
 * @coder Bob
 *
 * @languages
 */
public class BonjourWorld extends AbstractHelloWorld{

  /**
   * The message to use when greeting someone
   *
   * @language French
   */
  public static final String MESSAGE_FR = "Bonjour";

  /**
   * Main entry point into application
   *
   * @param args
   *    The list of names to say hello to, optional. If omitted, will
   *    default to <em>World</em>
   */
  public static void main(String[] args){
    HelloWorld hw = new HelloWorld();

    if(args.length == 0){
      hw.sayHello("World");
    }else{
      for(String name : args){
        hw.sayHello(name);
      }
    }
  }

  @Override
  public String getGreeting() {
    return MESSAGE_FR;
  }

}
