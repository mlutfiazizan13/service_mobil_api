package com.app.mobil_service_api.controller;

import com.app.mobil_service_api.model.ServiceMobil;
import com.app.mobil_service_api.repository.ServiceMobilRepository;
import com.app.mobil_service_api.service.ServiceMobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceMobilController {

    @Autowired
    ServiceMobilService serviceMobilService;
    @Autowired
    ServiceMobilRepository serviceMobilRepository;

    @GetMapping(path = "/service")
    public ResponseEntity<Object> getByStatus(String status){
        HashMap<String, Object> response= new HashMap<>();

        List<ServiceMobil> serviceMobils = serviceMobilService.getByStatus(status);
        System.out.println(status);
        response.put("message", "success");
        response.put("data",serviceMobils);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/service")
    public ResponseEntity<Object> store(@RequestBody ServiceMobil serviceMobil){
        HashMap<String, Object> response = new HashMap<>();
        ServiceMobil store = serviceMobilService.store(serviceMobil);
        response.put("message", "success");
        response.put("data", store);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/service/{id}/update_status")
    public ResponseEntity<Object> editStatus(@PathVariable("id") int service_mobil_id,
                                                @RequestBody ServiceMobil serviceMobil){
        HashMap<String, Object> response = new HashMap<>();
        ServiceMobil editStatus = serviceMobilService.editStatus(service_mobil_id, serviceMobil);
        response.put("message", "status");
        response.put("data", editStatus);
        return ResponseEntity.ok().body(response);
    }
}
