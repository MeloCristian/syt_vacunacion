package syt_vacunacion;

import java.util.Date;

import junit.framework.TestCase;
import syt_vacunacion.mundo.Dosis;
import syt_vacunacion.mundo.Universidad;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad XX (San Juan de Pasto - Colombia)
 * Programa Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Caso de estudio: Seguimiento y trazabilidad a la vacunaci�n
 * Autor: Giovanni Hern�ndez P. - 19-febrero-2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class UniversidadTest extends TestCase
{
	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------
	/**
	 * Clase a la que se le realizaran las pruebas
	 */
	public Universidad universidad;

	//-----------------------------------------------------------------
	// M�todos
	//-----------------------------------------------------------------

	/**
	 * Construye una nueva Universidad sin datos
	 *  
	 */
	public void setupEscenario1( )
	{
	    universidad = new Universidad( );
	}
	
	/**
	 * Construye una nueva Universidad con 3 estudiantes
	 *  
	 */
	public void setupEscenario2( )
	{
	    universidad = new Universidad( );
	    try {
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "100", "Adriana", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "101", "Jeferson", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "102", "Samuel", false);
		} catch (Exception e) {
			fail("No deber�a pasar por ac�");
		}
	}
	
	/**
	 * Verificar que a un estudiante que no est� registrado, no se le puede registrar una dosis
	 */
	public void testRegistrarDosis1()
	{
		setupEscenario1();
	    try {
	    		Date pFecha = new Date();
				universidad.registrarDosis("200", pFecha, Dosis.PFIZER);
				assertEquals(1, universidad.darDosis().size());
				fail("Permiti� registrar una dosis a un estudiante que no est� registrado");
			} catch (Exception e) {
				System.out.print("\n" + e.getMessage());
			}
	}
	
	/**
	 * Verificar que a un estudiante que est� registrado pero no activo, no se le puede registrar una dosis
	 */
	public void testRegistrarDosis2()
	{
		setupEscenario2();
	    try {
	    		Date pFecha = new Date();
				universidad.registrarDosis("102", pFecha, Dosis.PFIZER);
				assertEquals(1, universidad.darDosis().size());
				fail("Permiti� registrar una dosis a un estudiante inactivo");
			} catch (Exception e) {
				System.out.print("\n" + e.getMessage());
			}
	}

	
	/**
	 * Verificar que a un estudiante que est� registrado, se le puede registrar una dosis
	 */
	public void testRegistrarDosis3()
	{
		setupEscenario2();
	    try {
	    		Date pFecha = new Date();
				universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
				assertEquals(1, universidad.darDosis().size());
			} catch (Exception e) {
				fail("No deber�a pasar por ac�");
			}
	}

}
