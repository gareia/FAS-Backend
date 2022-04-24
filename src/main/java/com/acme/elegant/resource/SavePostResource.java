package com.acme.elegant.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavePostResource {

    private String description;
    private boolean sellable = false;
    private double price = 0;
    private int stock = 1;
    private String size;

}
