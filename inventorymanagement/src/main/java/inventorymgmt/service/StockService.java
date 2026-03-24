package inventorymgmt.service;

import inventorymgmt.dto.Stock;
import inventorymgmt.exception.NotFoundException;
import inventorymgmt.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    @Transactional(readOnly = true)
    public Stock getStock(String modelNo) {
        return stockRepository.findByModelNo(modelNo).stream().map(
                s -> Stock.of().stockName(s.getProductName())               //s is entity
                        .modelNo(s.getModelNo())
                        .quantity(s.getQuantity())
                        .price(s.getPrice()).build()
        ).findFirst().orElseThrow(() -> {
            throw new NotFoundException("Stock Not Available");
        });
    }
}
