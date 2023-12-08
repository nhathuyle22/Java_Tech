package com.example.lab09_10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResDTO {
    private String message;
    private boolean status;
    private Object data;
}
