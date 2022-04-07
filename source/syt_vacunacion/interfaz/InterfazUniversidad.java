package syt_vacunacion.interfaz;

import java.util.Date;

import syt_vacunacion.mundo.Dosis;
import syt_vacunacion.mundo.Universidad;

public class InterfazUniversidad {
	
	private static Universidad principal;

	public static void main(String[] args) 
	{
		principal = new Universidad();
	}

}
