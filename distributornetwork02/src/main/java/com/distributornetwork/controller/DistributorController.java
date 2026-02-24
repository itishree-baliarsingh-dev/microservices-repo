package com.distributornetwork.controller;

import com.distributornetwork.dto.Distributor;
import com.distributornetwork.exception.NotFoundException;
import com.distributornetwork.service.DistributorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributor")
@AllArgsConstructor
public class DistributorController {
    private final DistributorService distributorService;

    @GetMapping(value = "/{distributorCode}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Distributor getDistributor(@PathVariable("distributorCode") String distributorCode, HttpServletRequest httpServletRequest) {
        httpServletRequest.getHeaderNames().asIterator().forEachRemaining(s -> {
            System.out.println(s + ":" + httpServletRequest.getHeader(s));
        });
        return distributorService.findDistributorByDistributorCode(distributorCode);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), "distributor not found")).build();
    }
}
