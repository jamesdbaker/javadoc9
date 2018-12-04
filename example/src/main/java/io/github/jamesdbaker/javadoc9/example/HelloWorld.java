package io.github.jamesdbaker.javadoc9.example;

/**
 * Example class that's very friendly and says hello to everyone in English!
 *
 * @author James Baker
 * @coder James
 * @coder Bob
 *
 * @languages
 */
public class HelloWorld extends AbstractHelloWorld{

  /**
   * The message to use when greeting someone
   *
   * @language English
   */
  public static final String MESSAGE_EN = "Howdy";

  public static final String GOODBYE = "See ya!";

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
    return MESSAGE_EN;
  }
}
