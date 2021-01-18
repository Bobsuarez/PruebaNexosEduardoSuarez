package com.nexosprueba.pruebaeduardosuarez.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tbl_persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Persona  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String tipodocumento;
    private Long numerodocumento;
    private String  genero;
    private String correo;
    private Long celular;
    private String ciudad;







}