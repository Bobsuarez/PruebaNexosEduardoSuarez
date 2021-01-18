package com.nexosprueba.pruebaeduardosuarez.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auditoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String tablaAfectada;
    @Column(name = "info_anterior", length = 500)
    private String infoAnterior;
    @Column(name = "info_nueva", length = 500)
    private String infoNueva;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String usuario;


}
