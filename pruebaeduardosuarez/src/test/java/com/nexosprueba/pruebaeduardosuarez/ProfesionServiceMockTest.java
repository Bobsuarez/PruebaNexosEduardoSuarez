package com.nexosprueba.pruebaeduardosuarez;


import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;
import com.nexosprueba.pruebaeduardosuarez.repository.ProfesionRepository;
import com.nexosprueba.pruebaeduardosuarez.service.ProfesionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Clase Tests en la cual ya no se valida la BD en memoria sino por MOCK antes de realizar el test
 * se requiere cambiar la inyeccion de dependiencias por constructor @RequiredArgsConstructor
 */
@SpringBootTest
public class ProfesionServiceMockTest {

    @Mock
    private ProfesionRepository profesionRepository;

    private ProfesionService profesionService;

    /**
     * Metodo en la cual pre-carga un resgitro al constructor ProfesionService
     * para su verificacion de procedimiento
     */
    @BeforeEach
    public void setup(){
//        MockitoAnnotations.initMocks(this);
//        profesionService = new ProfesionServiceImpl(profesionRepository);
//        Profesion computer = Profesion.builder()
//                .nombre("Programador")
//                .empresa("Google")
//                .ciudad("")
//                .telefono(789582L)
//                .direccion("calle 85 - 28 -58")
//                .salario(Double.parseDouble("1000000.0"))
//                .estado("Activo")
//                .persona(Persona.builder().id(1L).build())
//                .creado(new Date())
//                .build();
//        Mockito.when(profesionRepository.findById(1L))
//                .thenReturn(Optional.of(computer));
    }

    /**
     * Test que permite verificar si el Service de
     * profesion esta funcionando correctamente
     */
    @Test
    public void whenValideGetID_ThenReturnProfesion() throws AplicacionExcepcion {
        Profesion found = profesionService.getProfesion(1L);
        profesionService.deleteProfesion(found.getId());
        Assertions.assertThat(found.getEmpresa()).isEqualTo("Google");
    }

}
