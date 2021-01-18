package com.nexosprueba.pruebaeduardosuarez.service;


import com.google.gson.Gson;
import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;
import com.nexosprueba.pruebaeduardosuarez.constantes.EMensajesError;
import com.nexosprueba.pruebaeduardosuarez.entity.Auditoria;
import com.nexosprueba.pruebaeduardosuarez.entity.Persona;
import com.nexosprueba.pruebaeduardosuarez.entity.Profesion;
import com.nexosprueba.pruebaeduardosuarez.repository.AuditoriaRepository;
import com.nexosprueba.pruebaeduardosuarez.repository.ProfesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfesionServiceImpl implements ProfesionService, AuditoriaService {


    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private ProfesionRepository profesionRepository;
    static final Logger logger = Logger.getLogger(ProfesionServiceImpl.class);

    @Override
    public List<Profesion> listAllProfesion() throws AplicacionExcepcion {
        List<Profesion> listaProfesion = profesionRepository.findAll();
        if (listaProfesion == null){
            throw new AplicacionExcepcion(EMensajesError.NO_RESULTADOS);
        }
        return profesionRepository.findAll();
    }

    @Override
    public Profesion getProfesion(Long id) throws AplicacionExcepcion {
        Optional<Profesion> resultProfesion = profesionRepository.findById(id);
        if (resultProfesion.isEmpty()) {
            throw new AplicacionExcepcion(EMensajesError.NO_RESULTADOS);
        }
        return resultProfesion.get();
    }

    @Override
    public Profesion createProfesion(Profesion profesion)
            throws AplicacionExcepcion {
        if (profesion.getNombre() == null || profesion.getNombre().isEmpty()) {
            throw new AplicacionExcepcion(EMensajesError.ERROR_PARAMETRO_VACIO, "");
        }
        profesion.setCreado(new Date());
        profesion.setEstado("Activado");
        createAuditoria(profesion, null);
        logMessage("Paso correcto verificar");
        return profesionRepository.save(profesion);
    }

    @Override
    public Profesion updateProfesion(Profesion profesion)
            throws AplicacionExcepcion {
        Profesion profesionDB = getProfesion(profesion.getId());
        Object infoAnti = profesionDB.toString();
        profesionDB.setNombre(profesion.getNombre());
        profesionDB.setCiudad(profesion.getCiudad());
        profesionDB.setEstado(profesion.getEstado());
        profesionDB.setEmpresa(profesion.getEmpresa());
        profesionDB.setDireccion(profesion.getDireccion());
        profesionDB.setSalario(profesion.getSalario());
        profesionDB.setTelefono(profesion.getTelefono());
        profesionDB.setPersona(profesion.getPersona());
        createAuditoria(profesionDB, infoAnti);
        return profesionRepository.save(profesionDB);
    }

    @Override
    public Profesion deleteProfesion(Long id) throws AplicacionExcepcion {
        Profesion profesionDB = getProfesion(id);
        if (profesionDB == null) {
            return null;
        }
        profesionDB.setCreado(new Date());
        profesionDB.setEstado("Inactivo");
        return profesionRepository.save(profesionDB);
    }

    @Override
    public List<Profesion> findByProfesion(Persona persona) {
        return profesionRepository.findByPersona(persona);
    }

    @Override
    public Profesion updateEmpresa(Long id, String nombre)
            throws AplicacionExcepcion {
        Profesion profesionDB = getProfesion(id);
        if (profesionDB == null) {
            return null;
        }
        profesionDB.setEmpresa(nombre);
        return profesionRepository.save(profesionDB);
    }

    public void logMessage(String mensajeLog) {
        BasicConfigurator.configure();
        logger.debug(mensajeLog);
    }


    @Async
    @Override
    public void createAuditoria(Object entidadInfoNueva, Object entidadInfoAnt)
            throws AplicacionExcepcion {
        Gson gson = new Gson();
        Auditoria auditoria = new Auditoria();
        logMessage("ingreso al metodo de sincronico Auditoria para la entidad " + entidadInfoNueva);
        try {
            Thread.sleep(5000);
            auditoria.setFechaCreacion(new Date());
            auditoria.setUsuario("Eduardo");
            auditoria.setTablaAfectada(entidadInfoNueva.getClass().getName());
            if (entidadInfoAnt != null) {
                auditoria.setInfoAnterior(entidadInfoAnt.toString());
            }
            auditoria.setInfoNueva(entidadInfoNueva.toString());
            logMessage("Se guardaran los siguientes datos {}" + gson.toJson(auditoria));
            auditoriaRepository.save(auditoria);

        } catch (InterruptedException e) {
            throw new AplicacionExcepcion(EMensajesError.ERROR_VALIDACION_MENSAJE, e.toString());
        }
        logMessage("salio sincronico");
    }


}
