package com.nexosprueba.pruebaeduardosuarez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_profesion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
public class Profesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String empresa;
    private String ciudad;
    private String direccion;
    private Long telefono;
    private Double salario;

    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;
}
