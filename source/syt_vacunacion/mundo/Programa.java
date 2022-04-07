// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Mariana (San Juan de Pasto - Colombia)
 * Programa Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Análisis y modelamiento de software
 * Caso de estudio: Trazabilidad a la vacunación
 * Autor: Giovanni Hernández P. - 18-noviembre-2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package syt_vacunacion.mundo;

import java.util.ArrayList;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad XX (San Juan de Pasto - Colombia)
 * Programa Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Caso de estudio: Seguimiento y trazabilidad a la vacunación
 * Autor: Giovanni Hernández P. - 19-febrero-2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Programa {
	
	// - - - - - - - - - - - - - - - - - - - - - -
	// Atributos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * El nombre del programa
	 */
	private String nombre;
	
	/**
	 * Los estudiantes del programa
	 */
	private ArrayList<Estudiante> estudiantes;
	
	// - - - - - - - - - - - - - - - - - - - - - -
	// Métodos
	// - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * Constructor de la clase Programa
	 * @param nombre El nombre del programa
	 */
	public Programa(String nombre) {
		this.nombre = nombre;
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	/**
	 * Busca un estudiante de la lista de estudiante
	 * @param pId La identificación del estudiante
	 * @return Devuelve el estudiante encontrado, de lo contrario retorna null
	 */
	public Estudiante buscarEstudiante(String pId)
	{
		Estudiante estudianteBuscado=null;
		boolean encontrado=false;
		for (int indice = 0; indice < estudiantes.size() && !encontrado ; indice++) 
		{
			Estudiante miEstudiante = (Estudiante) estudiantes.get(indice);
			if(miEstudiante.darId().equals(pId))
			{
				encontrado = true;
				estudianteBuscado = miEstudiante;
			}
		}
		return estudianteBuscado;
	}
	
	/**
	 * Agrega un nuevo estudiante a la lista de estudiantes del programa
	 * @param pId La identificación del estudiante pId!=""
	 * @param pNombre El nombre del estudiante pNombre!=""
	 * @param pEstado El estado de matrícula del estudiante pEstado=true || pEstado=false
	 * @throws Exception Lanza una excepción si el estudainte con el pId ya se encuentra en la lista estudiantes.
	 */
	public void agregarEstudiante(String pId, String pNombre, boolean pEstado) throws Exception
	{
		Estudiante miEstudiante = buscarEstudiante(pId);
		if(miEstudiante==null)
		{
			miEstudiante = new Estudiante(pId, pNombre, pEstado);
			estudiantes.add(miEstudiante);
		}
		else
		{
			throw new Exception("El estudiante con el " + pId + " ya se encuentra registrado para este programa");
		}
	}

	/**
	 * Devuelve el nombre del programa
	 * @return El nombre del programa
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del programa
	 * @param nombre El nombre del programa a modificar
	 */
	public void modificarNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la lista de estudiantes
	 * @return the estudiantes
	 */
	public ArrayList<Estudiante> darEstudiantes() {
		return estudiantes;
	}

	/**
	 * Modifica la lista de estudiantes
	 * @param estudiantes Los estudiantes a modificar
	 */
	public void modificarEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


};
