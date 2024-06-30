package com.sambot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {
    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;

}
