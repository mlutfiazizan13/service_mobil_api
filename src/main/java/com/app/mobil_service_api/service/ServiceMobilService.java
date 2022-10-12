package com.app.mobil_service_api.service;

import com.app.mobil_service_api.model.ServiceMobil;
import com.app.mobil_service_api.repository.ServiceMobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMobilService {
    @Autowired
    ServiceMobilRepository serviceMobilRepository;

    public List<ServiceMobil> getByStatus(String status){
        List<ServiceMobil> get = serviceMobilRepository.findByStatus(status);
        return get;
    }

    public ServiceMobil store(ServiceMobil serviceMobil){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(date);

        serviceMobil.setCreated_at(currentDate);
        serviceMobil.setUpdated_at(currentDate);
        serviceMobil.setStatus("WAITING");
        serviceMobil.setIs_deleted(false);

        ServiceMobil store =serviceMobilRepository.save(serviceMobil);
        return store;
    }

    public ServiceMobil editStatus(int service_mobil_id, ServiceMobil serviceMobil){
        Optional<ServiceMobil> getId = serviceMobilRepository.findById(service_mobil_id);
        ServiceMobil editServiceMobil = getId.get();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(date);

        editServiceMobil.setStatus(serviceMobil.getStatus());
        editServiceMobil.setUpdated_at(currentDate);

        ServiceMobil editStatus = serviceMobilRepository.save(editServiceMobil);
        return editStatus;
    }
}
