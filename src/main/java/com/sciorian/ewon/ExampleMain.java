package com.sciorian.ewon;

import com.hms_networks.americas.sc.extensions.mqtt.MqttManager;

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
  public static void main(String[] args) {
    // Try to output application name from Maven
    System.out.println("App name: " + ExampleMain.class.getPackage().getImplementationTitle());

    // Try to output application version from Maven
    System.out.println("App version: " + ExampleMain.class.getPackage().getImplementationVersion());

    System.out.println("Hello world from my ewon :p");

    // TODO add mqtt client code
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
