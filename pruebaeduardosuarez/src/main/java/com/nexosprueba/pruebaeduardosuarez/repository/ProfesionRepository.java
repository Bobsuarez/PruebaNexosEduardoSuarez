package com.nexosprueba.pruebaeduardosuarez.repository;



import com.nexosprueba.pruebaeduardosuarez.entity.Persona;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionRepository extends
        JpaRepository<Profesion, Long> {

    public List<Profesion> findByPersona(Persona persona);


}
