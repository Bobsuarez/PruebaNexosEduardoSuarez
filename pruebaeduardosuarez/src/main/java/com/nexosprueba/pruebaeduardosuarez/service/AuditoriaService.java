package com.nexosprueba.pruebaeduardosuarez.service;

import com.nexosprueba.pruebaeduardosuarez.excepcion.AplicacionExcepcion;

public interface AuditoriaService {
    void createAuditoria(Object entidadInfoNueva, Object entidadInfoAnt)
            throws AplicacionExcepcion;
}
