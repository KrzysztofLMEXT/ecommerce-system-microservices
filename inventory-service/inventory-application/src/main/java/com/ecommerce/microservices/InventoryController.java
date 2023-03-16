package com.ecommerce.microservices;

import com.ecommerce.microservices.dto.InventoryResponse;
import com.ecommerce.microservices.ports.InventoryAppService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryAppService inventoryAppService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return Arrays.asList(InventoryResponse.builder().isInStock(true).skuCode("12345").build());
    }
}
