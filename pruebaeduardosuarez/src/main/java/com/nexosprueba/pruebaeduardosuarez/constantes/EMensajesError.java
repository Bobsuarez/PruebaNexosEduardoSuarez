package com.nexosprueba.pruebaeduardosuarez.constantes;


import com.nexosprueba.pruebaeduardosuarez.repository.MensajeGenericoRepository;

/**
 * Metodo que contiene los Mensajes Error
 */
public enum EMensajesError implements MensajeGenericoRepository {


    NO_RESULTADOS(0, "No se encontraron resultados"),
    OK(1, "Petición ejecutada correctamente"),
    ERROR_VALIDACION_MENSAJE(-2, "__COMPLEMENTO__"),
    ERROR_VALIDACION_NO_ENCONTRADA(-3, "Validación no encontrada"),
    ERROR_PARAMETRO_VACIO(-4, "Parameto vacio Por favor Revisar  __COMPLEMENTO__");


    private final int codigo;
    private final String mensaje;

    EMensajesError(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }
}
