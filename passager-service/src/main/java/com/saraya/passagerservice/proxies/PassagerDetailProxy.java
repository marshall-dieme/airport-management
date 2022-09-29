package com.saraya.passagerservice.proxies;

import com.saraya.passagerservice.model.PassagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "passager-details-service", url = "localhost:8088/passagers-details")
public interface PassagerDetailProxy {
    @PostMapping
    PassagerDTO create(@RequestBody PassagerDTO passagerDetails);
}
