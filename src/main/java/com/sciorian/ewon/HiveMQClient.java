package com.sciorian.ewon;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5AsyncClient;
import java.util.concurrent.atomic.AtomicReference;

public class HiveMQClient {
  private final String username;
  private final String clientId;
  private final String password;
  private final String brokerUrl;
  private final Mqtt5AsyncClient client;

  public HiveMQClient(String username, String password, String url) {
    this.username = username;
    this.clientId = username;
    this.password = password;
    this.brokerUrl = url;

    this.client = MqttClient.builder()
        .useMqttVersion5()
        .identifier(clientId)
        .serverHost(brokerUrl)
        .serverPort(8883)
        .buildAsync();

    // connect the client to the broker
    connect();
  }

  public void connect() {
    client.connectWith()
        .simpleAuth()
        .username(username)
        .password(password.getBytes())
        .applySimpleAuth()
        .send()
        .whenComplete((connAck, throwable) -> {
          if (throwable == null) {
            return;
          }
          System.out.println("Something went wrong: ");
          System.out.println(connAck.getReasonCode() + " : " + connAck.getReasonString());
        });
  }

  public boolean send(String topic, String message) {
    AtomicReference<Boolean> success = new AtomicReference<>(false);

    client.publishWith()
        .topic(topic)
        .payload(message.getBytes())
        .qos(MqttQos.EXACTLY_ONCE)
        // keep the message in-memory until next one is send
        .retain(true)
        .send()
        .whenComplete((result, throwable) -> {
          if (throwable == null) {
            // success?
            success.set(true);
            return;
          }
          System.out.println("something went wrong while publishing a message");
          throwable.printStackTrace();
        });

    return success.get();
  }
}
