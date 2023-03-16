package com.ecommerce.microservices;

import com.ecommerce.microservices.dto.CheckStockCommand;
import com.ecommerce.microservices.dto.InventoryResponse;
import com.ecommerce.microservices.ports.InventoryAppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryAppServiceImpl implements InventoryAppService {
    @Override
    public List<InventoryResponse> isInStock(CheckStockCommand checkStockCommand) {
        return null;
    }
}
