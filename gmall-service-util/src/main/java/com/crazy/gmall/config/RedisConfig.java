package com.crazy.gmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// spring 中xxx.xml
@Configuration
public class RedisConfig {

  // 通过配置文件的形式将host，port，database 赋值 application.properties. disabled:表示一个默认值
  @Value("${spring.redis.host:disabled}")
  private String host; // 如果配置文件中没有spring.redis.host，则host为disabled

  @Value("${spring.redis.port:0}")
  private int port;

  @Value("${spring.redis.database:0}")
  private int database;

  // 在application.xml <bean class="com.crazy.gmall.config.RedisConfig">  </bean>
  @Bean//@Bean相当于xml中的<bean> 将另一个对象装配进来
  public RedisUtil getRedisUtil() {
    if ("disabled".equals(host)) {
      return null;
    }
    RedisUtil redisUtil = new RedisUtil();
    redisUtil.initJedisPool(host, port, database);
    return redisUtil;
  }


}
