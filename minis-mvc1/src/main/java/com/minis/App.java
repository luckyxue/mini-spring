//package com.minis;
//
//import java.io.File;
//
//public class App
//{
//    public static void main( String[] args ) throws LifecycleException {
//        System.out.println( "Hello World!" );
//        Tomcat tomcat = new Tomcat();
//        String webappDirLocation = "WebContent";
//        StandardContext context = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//        Connector connector = new Connector();
//        connector.setPort(8080);
//        tomcat.setConnector(connector);
//        tomcat.start();
//        tomcat.getServer().await();
//    }
//}