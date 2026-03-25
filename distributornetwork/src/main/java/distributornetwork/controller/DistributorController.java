package distributornetwork.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import distributornetwork.bean.NetworkSettings;
import distributornetwork.dto.Distributor;
import distributornetwork.exception.NotFoundException;
import distributornetwork.service.DistributorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributors")
@AllArgsConstructor
public class DistributorController {
    private final DistributorService distributorService;
    private final NetworkSettings networkSettings;

    @GetMapping(value = "/{distributorCode}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Distributor getDistributor(@PathVariable("distributorCode") String distributorCode, HttpServletRequest httpServletRequest) throws JsonProcessingException {
        httpServletRequest.getHeaderNames().asIterator().forEachRemaining(s -> {
            System.out.println(s + ":" + httpServletRequest.getHeader(s));
        });
        return distributorService.findDistributorByDistributorCode(distributorCode);
    }

    @GetMapping("/networksettings")
    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), "distributor not found")).build();
    }
}
