package syt_vacunacion.mundo;

import java.util.Date;

public class Cita {
	
	private Date fecha;
	private Estudiante estudiante;
	
	/**
	 * Constructor de la clase Cita
	 * @param estudiante El estudiante al que se le asigna la cita estudiante!=null
	 * @param fecha La fecha en la cual se agenda la cita, fecha!=null
	 */
	public Cita(Estudiante estudiante, Date fecha) {
		this.fecha = fecha;
		this.estudiante = estudiante;		
	}
	
	
	/**
	 * Retorna el estudiante
	 * @return Devuelve el estudiante 
	 */
	public Estudiante darEstudiante() {
		return this.estudiante;
	}
	
	/**
	 * Modifica el estudiante
	 * @param estudiante El estudiante a modificar estudainte!=null
	 */
	public void modificarEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	/**
	 * Devuelve la fecha
	 * @return La fecha
	 */
	public Date darFecha() {
		return this.fecha;
	}
	
	/**
	 * Modifica la fecha
	 * @param fecha La fecha a modificar
	 */
	public void modificarFecha(Date fecha) {
		this.fecha = fecha;
	}

}
