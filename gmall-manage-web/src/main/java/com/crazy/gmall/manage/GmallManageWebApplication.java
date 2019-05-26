package com.crazy.gmall.manage;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = "com.crazy.gmall")
public class GmallManageWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(GmallManageWebApplication.class, args);
  }

  @Test
  public void textFileUpload() throws IOException, MyException {
    String file = this.getClass().getResource("/tracker.conf").getFile();
    ClientGlobal.init(file);
    TrackerClient trackerClient=new TrackerClient();
    TrackerServer trackerServer=trackerClient.getConnection();
    StorageClient storageClient=new StorageClient(trackerServer,null);
    String orginalFilename="o://2.png";
    String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
    for (int i = 0; i < upload_file.length; i++) {
      String s = upload_file[i];
      System.out.println("s = " + s);
    }

  }


}
