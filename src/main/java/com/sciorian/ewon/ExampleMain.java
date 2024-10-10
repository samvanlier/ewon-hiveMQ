package com.sciorian.ewon;

/**
 * Example main class for Solution Center Java Starter Project. This class includes a basic main
 * method with sample code to begin with.
 *
 * @author HMS Networks, MU Americas Solution Center
 */
public class ExampleMain {

  /**
   * Example main method for Solution Center Java Starter Project.
   *
   * @param args project arguments
   */
  public static void main(String[] args) throws InterruptedException {
    // Try to output application name from Maven
    System.out.println("App name: " + ExampleMain.class.getPackage().getImplementationTitle());

    // Try to output application version from Maven
    System.out.println("App version: " + ExampleMain.class.getPackage().getImplementationVersion());

    System.out.println("Hello world from my ewon :p");

    // // TODO connect to hiveMq
    // HiveMQClient client = new HiveMQClient(
    //     "hivemq.webclient.1727866192045",
    //     "&SCKfkNb;5prD8?>z12O",
    //     "4c4aca1744ed4d35bb0f1141772d9731.s1.eu.hivemq.cloud"
    // );
    //
    // Thread.sleep(100);
    //
    // while (true) {
    //   client.send("hello/world", "test1");
    //
    //   Thread.sleep(1000); // sleep
    // }
  }

  /**
   * Returns an example value which is used in the example test class.
   *
   * @return example integer
   */
  public static int getExampleValue() {
    return 10;
  }
}
