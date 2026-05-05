package br.com.ifsc.lumina.luminaclothing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    private Double x;
    private Double y;
    private String label;
}
