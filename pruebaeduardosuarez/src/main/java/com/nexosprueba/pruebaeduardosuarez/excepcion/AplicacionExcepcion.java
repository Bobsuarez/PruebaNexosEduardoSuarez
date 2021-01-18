/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexosprueba.pruebaeduardosuarez.excepcion;


import com.nexosprueba.pruebaeduardosuarez.repository.MensajeGenericoRepository;

/**
 * Clase de error que se va a devolver a la presentación
 */
@SuppressWarnings("OverridableMethodCallInConstructor")
public class AplicacionExcepcion extends Exception {

    /**
     * Código de respuesta que se envía a la presentación del sistema
     */
    protected int codigo;

    /**
     * Descripción del error
     */
    protected String mensaje;

    /**
     * Información adicional del error
     */
    protected Object datos;

    /**
     * Constructor de la clase
     *
     * @param mensaje Constante del error que está orriendo
     */
    public AplicacionExcepcion(MensajeGenericoRepository mensaje) {
        super(mensaje.getMensaje());
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getMensaje();
    }

    public AplicacionExcepcion(MensajeGenericoRepository mensaje, Object datos) {
        super(mensaje.getMensaje());
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getMensaje();
        this.datos = datos;
    }

    public AplicacionExcepcion(int codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public AplicacionExcepcion(MensajeGenericoRepository eMensaje, String complemento) {
        super(eMensaje.getMensaje().replaceAll("__COMPLEMENTO__", complemento));
        this.codigo = eMensaje.getCodigo();
        this.mensaje = getMessage();

    }
}
