package com.example.employee_api.dto.response;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

}
