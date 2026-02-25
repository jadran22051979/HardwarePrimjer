package com.example.HardwarePrimjer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    @NotBlank(message = "Hardware name can not be blank")
    private String hardwareName;
    @NotBlank(message = "Hardware Code name can not be blank")
    private String hardwareCode;
    @PositiveOrZero(message = "Article price must be positive")
    private BigDecimal hardwarePrice;

//    @NotBlank(message = "Quantity name can not be blank")
    @PositiveOrZero(message = "Quantity price must be positive")
    private Integer quantity;
    @NotBlank(message = "Category  name can not be blank")
    private String categoryName;
}
