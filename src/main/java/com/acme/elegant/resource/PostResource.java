package com.acme.elegant.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResource {

    private Long id;
    private String description;
    private boolean sellable;
    private double price;
    private int stock;
    private String size;
    private Long userId;

}
