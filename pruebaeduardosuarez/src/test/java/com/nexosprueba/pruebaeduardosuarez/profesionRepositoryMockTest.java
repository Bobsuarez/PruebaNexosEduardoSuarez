package com.nexosprueba.pruebaeduardosuarez;



import com.nexosprueba.pruebaeduardosuarez.entity.Persona;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;
import com.nexosprueba.pruebaeduardosuarez.repository.ProfesionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

/**
 * Clase test en la cual se valida contra la DB en memoria y se procede a una validacion
 */

@DataJpaTest
public class profesionRepositoryMockTest {

    @Autowired
    private ProfesionRepository profesionRepository;

    /**
     * Metodo que carga un dato a la DB
     */
    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Profesion profesion01 = Profesion.builder()
                .nombre("Programador")
                .empresa("Google")
                .ciudad("")
                .telefono(789582L)
                .direccion("calle 85 - 28 -58")
                .salario(Double.parseDouble("1000000.0"))
                .estado("Activo")
                .persona(Persona.builder().id(1L).build())
                .creado(new Date()).build();
        profesionRepository.save(profesion01);

        // se busca los registros de las personas con id = 1
        List<Profesion> founds= profesionRepository.findByPersona(profesion01.getPersona());
        //Se compara si existen mas a 3
        Assertions.assertThat(founds.size()).isEqualTo(3);


    }
}