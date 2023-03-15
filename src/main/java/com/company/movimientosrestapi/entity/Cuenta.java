package com.company.movimientosrestapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuenta;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private Double saldoInicial;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne()
    @JoinColumn(name="id_Cliente")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name="id_movimiento")
    private Movimiento movimientos;

}
