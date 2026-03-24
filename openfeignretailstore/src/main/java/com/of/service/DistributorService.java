package com.of.service;

import com.of.dto.DistributorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DISTRIBUTOR-NETWORK")
public interface DistributorService {
    @GetMapping(value = "/distributors/{distributorCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    DistributorDto getDistributor(@PathVariable("distributorCode") String distributorCode);
}
