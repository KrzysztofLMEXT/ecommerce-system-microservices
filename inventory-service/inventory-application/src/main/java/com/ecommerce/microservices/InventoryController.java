package com.ecommerce.microservices;

import com.ecommerce.microservices.dto.InventoryResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/inventory")
@AllArgsConstructor
public class InventoryController {

    @GetMapping
    public List<InventoryResponse> isInStock(List<String> codes){
        return null;
    }
}
