package com.ecommerce.microservices.ports;

import com.ecommerce.microservices.dto.CheckStockCommand;
import com.ecommerce.microservices.dto.InventoryResponse;

import java.util.List;

public interface InventoryAppService {
    List<InventoryResponse> isInStock(CheckStockCommand checkStockCommand);
}
