package com.nexosprueba.pruebaeduardosuarez.service;

import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;
import com.nexosprueba.pruebaeduardosuarez.entity.Persona;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;

import java.util.List;


public interface ProfesionService {


    public List<Profesion> listAllProfesion() throws AplicacionExcepcion;
    public Profesion getProfesion(Long id) throws AplicacionExcepcion;
    public  Profesion createProfesion(Profesion profesion) throws AplicacionExcepcion;
    public  Profesion updateProfesion(Profesion profesion) throws AplicacionExcepcion;
    public Profesion deleteProfesion(Long id) throws AplicacionExcepcion;
    public List<Profesion> findByProfesion(Persona persona);
    public Profesion updateEmpresa(Long id, String nombre) throws AplicacionExcepcion;




}

