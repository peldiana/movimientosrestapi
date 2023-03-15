package com.company.movimientosrestapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="cliente")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id_Cliente")),
})
public class Cliente extends Persona {

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "estado")
    private Boolean estado;
}