package com.ayoh.coreshop.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDto {

    private Long id;
    private String name;
    private Long price;
    private String details;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
