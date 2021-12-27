package com.kiber.encryptor.servicio;

import java.util.Random;

import com.kiber.encryptor.utilitario.Util;

public class CodificarServicio {

	/**
	 * De acuerdo al texto enviado se generara un codigo encriptado en forma de matriz
	 * @param texto
	 * @return
	 */
	public String CodificarTexto(String texto) {
		String respuesta ="";
		Random random = new Random();
		int size = texto.length();
		int filasAprox = 0;
		int columnas = Util.COLUMNA_MATRICES;
		char matriz[][]= null;
		
		
		if(texto.length()> 0 || !texto.equals("")) {
			
			for (int i = 0; i <size;i++) {
				//Generamos cadena con caracteres especiales definidos en la clase util en la variable CARACTERES INVALIDOS
		        int randomInt = random.nextInt(Util.CARACTERES_INVALIDOS.length());
		        char randomChar = Util.CARACTERES_INVALIDOS.charAt(randomInt);
				//Los caracteres se ingresan en la cadena en una posicion aleatorea de acuerdo a la longitud del parametro de entrada TEXTO 
				int valorEntero = (int) Math.floor(Math.random()*(0-texto.length()+1)+texto.length());
				texto = texto.substring(0, valorEntero) + randomChar +texto.substring(valorEntero);
			}
			//Calculamos dimensiones de la matriz resultado
			filasAprox = Math.round(texto.length()/5)+1;
			matriz = new char[filasAprox][columnas];
			
			int aux = 0;
			//Creamos la matriz y empezamos a recorrer cada caracter de la cadena TEXTO, se añaden en la matriz por filas
			for(int y = 0; y<columnas; y++) {
				for(int x = 0; x <filasAprox; x++) {
					try {
						matriz[x][y]=texto.charAt(aux);
					}catch(Exception ex) {
						//Si la posicion del texto no existe pero aun hay espacio en la matriz se generan caracteres aleatorios para llenar la matriz
						int randomInt = random.nextInt(Util.CARACTERES_INVALIDOS.length());
				        char randomChar = Util.CARACTERES_INVALIDOS.charAt(randomInt);
	            		matriz[x][y]=randomChar;
					}
					aux++;
				}
			}
			
			int aux1 = 0;
			//Al finalizar la creacion y el llenado de informacion a la matriz vamos a imprimirla en la variable respuesta recorriendo la matriz y agregando el salto de linea a los primeros 5 caracteres
			for(int i = 0; i<matriz.length;i++){
				for(int j= 0; j<columnas;j++) {
					aux1++;
					respuesta += matriz[i][j];
					if(aux1 ==columnas) {
						aux1=0;
						respuesta +="\r\n";
					}
				}
				
			}
			// Eliminamos el ultimo salto de linea a la respuesta 
			respuesta = respuesta.substring(0,respuesta.length()-3);
		}else {
			respuesta = "El texto ingresado no es valido";
		}
		
		
		return respuesta;
	}
}
