package com.example.bookmyshow_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends BaseModel{
    private String name;

}
