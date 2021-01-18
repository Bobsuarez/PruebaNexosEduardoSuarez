package com.nexosprueba.pruebaeduardosuarez.controller;


import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;
import com.nexosprueba.pruebaeduardosuarez.service.ProfesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profesion")
public class ProfesionController {

    @Autowired
    private ProfesionService profesionService;

    /**
     * Metodo que consulta la lista de profesiones
     *
     * @return Lista de la entidad Profesion
     */
    @GetMapping
    public ResponseEntity<List<Profesion>> listaProfesion() throws AplicacionExcepcion {
        List<Profesion> profesions = profesionService.listAllProfesion();
        return ResponseEntity.ok(profesions);
    }

    /**
     * Metodo de ejemplo para usar el PathVariable Rest
     *
     * @param id identificador de la profesion
     * @return Entidad
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Profesion> buscarProfesion(
            @PathVariable("id") Long id) throws AplicacionExcepcion {
        Profesion profesion = profesionService.getProfesion(id);
        if (profesion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesion);
    }

    /**
     * Metedo de crear utilizando POST
     *
     * @param profesion Entrada de datos de la Entidad
     * @return Entidad
     */
    @PostMapping
    public ResponseEntity<Profesion> crearProfesion(
            @RequestBody Profesion profesion) throws AplicacionExcepcion {
        Profesion crearProfesion = profesionService.createProfesion(profesion);
        profesionService.listAllProfesion();
        return ResponseEntity.status(HttpStatus.CREATED).body(crearProfesion);
    }


    /**
     * Metodo que actualiza registros de profesion
     *
     * @param id        Identificador de la profesion
     * @param profesion Entidad a actualizar
     * @return Registro actualizado
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Profesion> actualizarProfesion(
            @PathVariable("id") Long id,
            @RequestBody Profesion profesion) throws AplicacionExcepcion {
        profesion.setId(id);
        Profesion profesionDB = profesionService.
                updateProfesion(profesion);
        if (profesionDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesionDB);

    }

    /**
     * Metodo que elimina un registro
     *
     * @param id Identificador del registro a eliminar (Estado = Inactivo)
     * @return Registro que se Inactivo
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Profesion> eliminarProfesion(@PathVariable(value = "id") Long id) throws AplicacionExcepcion {
        System.out.println(id);
        Profesion eliminarProfesion = profesionService.deleteProfesion(id);
        if (eliminarProfesion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eliminarProfesion);

    }


}
