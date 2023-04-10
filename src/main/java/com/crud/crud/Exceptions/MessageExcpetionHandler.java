package com.crud.crud.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageExcpetionHandler{

    private Integer status;
    private Date timestamp;
    private String error;
    private String message;
}
