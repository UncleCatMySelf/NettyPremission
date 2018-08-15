package com.myself.nettypermiss;

import com.myself.nettypermiss.config.NettyConfig;
import com.myself.nettypermiss.config.TCPServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NettypermissApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext context = SpringApplication.run(NettypermissApplication.class, args);
		NettyConfig nettyConfig = context.getBean(NettyConfig.class);
		TCPServer tcpServer = context.getBean(TCPServer.class);
		tcpServer.start();
	}
}
