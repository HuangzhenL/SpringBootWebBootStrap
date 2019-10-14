package com.hz.webnodatabase.entities;

import lombok.Data;

@Data
public class Department {
    private Integer id;
    private String dapartmentName;

    public Department() {
    }

    public Department(Integer id, String dapartmentName) {
        this.id = id;
        this.dapartmentName = dapartmentName;
    }
}
