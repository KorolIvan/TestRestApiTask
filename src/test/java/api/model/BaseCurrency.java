package api.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Model for base currency
 */

@Data
@Builder
public class BaseCurrency {
    private String base;
    private Map<String, Double> rates;
    private String date;
}
