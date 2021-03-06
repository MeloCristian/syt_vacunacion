package syt_vacunacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;
import syt_vacunacion.mundo.Dosis;
import syt_vacunacion.mundo.Horario;
import syt_vacunacion.mundo.Universidad;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * Universidad XX (San Juan de Pasto - Colombia) Programa Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Caso de estudio: Seguimiento y trazabilidad a la vacunaci�n Autor: Giovanni
 * Hern�ndez P. - 19-febrero-2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class UniversidadTest extends TestCase {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Clase a la que se le realizaran las pruebas
	 */
	public Universidad universidad;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva Universidad sin datos
	 * 
	 */
	public void setupEscenario1() {
		universidad = new Universidad();
	}

	/**
	 * Construye una nueva Universidad con 3 estudiantes
	 * 
	 */
	public void setupEscenario2() {
		universidad = new Universidad();
		try {
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "100", "Adriana", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "101", "Jeferson", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "102", "Samuel", false);
		} catch (Exception e) {
			fail("No deber�a pasar por ac�");
		}
	}

	public void setupEscenario3() {
		universidad = new Universidad();
		try {
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "100", "Adriana", true);
			Date pFecha = new Date();
			universidad.registrarDosis("100", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("100", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("100", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("100", pFecha, Dosis.PFIZER);
		} catch (Exception e) {
			fail("No deber�a pasar por ac�");
		}
	}

	public void setupEscenario4() {
		universidad = new Universidad();
		try {

			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date pFecha1 = format.parse("4/6/2023 12:00:00");
			Date pFecha2 = format.parse("4/6/2023 13:00:00");
			Date pFecha3 = format.parse("4/6/2023 14:00:00");

			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "100", "Adriana", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "101", "Jeferson", true);
			universidad.agregarEstudiante("Facultad de Ingenier�a", "Ingenier�a de Sistemas", "102", "Samuel", false);
			// HORARIO
			universidad.registrarhorario(pFecha1, false);
			universidad.registrarhorario(pFecha2, false);
			universidad.registrarhorario(pFecha3, true);

		} catch (Exception e) {
			fail("No deber�a pasar por ac�");
		}
	}

	/**
	 * Verificar que a un estudiante que no est� registrado, no se le puede
	 * registrar una dosis
	 */
	public void xtestRegistrarDosis1() {
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
	 * Verificar que a un estudiante que est� registrado pero no activo, no se le
	 * puede registrar una dosis
	 */
	public void xtestRegistrarDosis2() {

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
	 * Verificar que a un estudiante que est� registrado, se le puede registrar una
	 * dosis
	 */
	public void xtestRegistrarDosis3() {
		setupEscenario2();
		try {
			Date pFecha = new Date();
			universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
			assertEquals(1, universidad.darDosis().size());
		} catch (Exception e) {
			fail("No deber�a pasar por ac�");
		}
	}

	/**
	 * PRUEBAS REALIZADAS EN EL SPRINT 1
	 */

	/**
	 * REGISTRAR SOLO 3 DOSIS POR USUARIO
	 */
	public void xtestRegistrarDosis4() {
		setupEscenario2();
		try {
			Date pFecha = new Date();

			universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
			universidad.registrarDosis("101", pFecha, Dosis.PFIZER);
			assertEquals(4, universidad.darDosis().size());
			fail("Permitio registrar mas de 3 dosis a un usuario");
			assertEquals(1, universidad.darDosis().size());
		} catch (Exception e) {

			System.out.print("\n" + e.getMessage());
		}
	}

	// REGISTRAR UNA CITA CUANDO NO EXISTE EL ESTUDIANTE
	public void xtestRegistrarCita1() {

		setupEscenario1();
		try {
			Date pFecha = new Date();
			universidad.registrarCita("100", new Horario(new Date(), false));
			assertEquals(1, universidad.darCitas().size());
			fail("Permitio registrar una cita de un usuario que no existe");

		} catch (Exception e) {
			System.out.print("\n" + e.getMessage());
		}
	}

	// REGISTRAR UNA CITA, CUANDO EL ESTUDIANTE NO ESTE ACTIVO
	public void xtestRegistrarCita2() {

		setupEscenario4();
		try {
			Date pFecha = new Date();

			universidad.registrarCita("102", new Horario(pFecha, false));
			assertEquals(1, universidad.darCitas().size());
			fail("Permitio registrar una cita de un usuario que no esta activo");
		} catch (Exception e) {

			System.out.print("\n" + e.getMessage());
		}
	}

	// REGISTRAR UN HORARIO, EL CUAL SU FECHA ES INFERIOR A LA  FECHA ACTUAL
	public void xtestRegistrarCita3() {

		setupEscenario1();
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date pFecha = format.parse("4/6/2021 12:00:00 ");
			universidad.registrarhorario(pFecha, false);
			assertEquals(1, universidad.darHorarios().size());
			fail("Permitio registrar una cita la cual es enferior a la actual");
		} catch (Exception e) {

			System.out.print("\n" + e.getMessage());
		}
	}

//REGISTRAR CITA NO VALIDA
	public void xtestRegistrarCita4() {

		setupEscenario4();
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date pFecha1 = format.parse("4/6/2023 13:00:00");

			universidad.registrarCita("105", new Horario(pFecha1, false));
			
			assertEquals(1, universidad.darCitas().size());
			fail("Error la cita cita se registro");
		} catch (Exception e) {

			System.out.print("\n" + e.getMessage());
		}
	}

	// Disponibilidad de horario
	public void xtestRegistrarCita5() {

		setupEscenario4();
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date pFecha1 = format.parse("4/6/2023 14:00:00");

			universidad.registrarCita("100", new Horario(pFecha1, false));
			assertEquals(1, universidad.darCitas().size());
			fail("Permitio registrar una cita cuyo horario ya esta asignado");
			
		} catch (Exception e) {
			System.out.print("\n" + e.getMessage());
		}
	}
	
	
	// Horario no creado
	public void testRegistrarCita6() {

		setupEscenario4();
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date pFecha1 = format.parse("4/6/2025 14:00:00");

			universidad.registrarCita("100", new Horario(pFecha1, false));
			assertEquals(1, universidad.darCitas().size());
			fail("Permitio registrar una cita cuyo horario no esta creado");
			
		} catch (Exception e) {
			System.out.print("\n" + e.getMessage());
		}
	}
}
