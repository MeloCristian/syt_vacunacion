package syt_vacunacion.mundo;

import java.util.Date;

public class Cita {
	
	private Horario horario;
	private Estudiante estudiante;
	
	/**
	 * Constructor de la clase Cita
	 * @param estudiante El estudiante al que se le asigna la cita estudiante!=null
	 * @param fecha La fecha en la cual se agenda la cita, fecha!=null
	 */
	public Cita(Estudiante estudiante, Horario horario) {
		this.horario = horario;
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
	 * Devuelve la el horario de la cita
	 * @return El horario
	 */
	public Horario darHorario() {
		return this.horario;
	}
	
	/**
	 * Modifica el horario de la cita
	 * @param horario: le nuevo horario a asignar
	 */
	public void modificarHorario(Horario horario) {
		this.horario = horario;
	}

}
