//package com.spring_boot.order.order_crud.actuatorEndpoint;
//
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//import org.springframework.boot.actuate.endpoint.annotation.Selector;
//import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Endpoint(id="/versionControl")
//public class VersionControl {
//
//    private Map<String, String> versions = new HashMap<>();
//
//    @PostConstruct
//    public void init(){
//        versions.put("v1.0.0", "Prepared project with crud operation");
//    }
//
//    @ReadOperation
//    public Map<String,String> getVersions(){
//        return versions;
//    }
//
//    @ReadOperation
//    public String getVesionBy(@Selector String version){
//        return versions.get(version);
//    }
//    @WriteOperation
//    public Map<String,String> addVersion(@Selector String version){
//
//    }
//}
