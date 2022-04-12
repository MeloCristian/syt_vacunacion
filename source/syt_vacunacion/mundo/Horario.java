package syt_vacunacion.mundo;

import java.util.Date;
import java.util.Objects;

public class Horario {
	
	private Date fecha;
	private boolean estado;
	
	
	/**
	 * Constructor de la clase Horario
	 * @param fecha: fecha del horario fecha!=null
	 * @param estado: indica si el horario ya fue asignado
	 */
	public Horario(Date fecha, boolean estado) {
		this.fecha = fecha;
		this.estado = estado;
	}
	
	/**
	 * Retorna la fecha del horario
	 * @return la fecha del horario
	 */
	public Date darFecha() {
		return fecha;
	}
	
	
	/**
	 * Mofica la fecha del horario
	 * @param fecha: nueva fecha a asignar al horario
	 */
	public void modifficarFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Retorna el estado del horario
	 * @return el estado del horario
	 */
	public boolean darEstado() {
		return estado;
	}

	/**
	 * Mofica el estado del horario
	 * @param estado: nuevo estado a asignar al horario
	 */
	public void modificarEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Horario horario = (Horario) o;
		return fecha.equals(horario.darFecha());
		
	}
	
    @Override
    public int hashCode() {
        return Objects.hash(fecha, estado);
    }
	
	
	

}
