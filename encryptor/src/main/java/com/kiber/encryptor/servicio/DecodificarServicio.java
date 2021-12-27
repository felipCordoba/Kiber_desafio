package com.kiber.encryptor.servicio;

import com.kiber.encryptor.utilitario.Util;

public class DecodificarServicio {

	/**
	 * De acuerdo al parametro de codigo enviado se ingresara la informacion en una matriz que sera leida de izquierda a derecha de arriba hacia abajo
	 * para obtener el texto 
	 * @param codigo
	 * @return
	 */
	public String DecodificarCodigo(String codigo) {
		String respuesta = "";
		
		//Generar array del codigo enviado por cada SALTO DE LINEA 
		String array[] = codigo.split(Util.SALTO_LINEA);
		char matriz[][]=new char[array.length][Util.COLUMNA_MATRICES];
		//Recorremos array e ingresamos en la los valores en la matriz
		for(int j=0;j<array.length;j++){
        	String valor=array[j];  
            for(int h=0;h<array[j].length();h++){
            	matriz[j][h]=valor.charAt(h);
            }
        }
		
		//Recorremos la Matriz generada leyendo por Columna por Filas de izquierda a Derecha
		for(int a = 0;a<Util.COLUMNA_MATRICES;a++) {
        	for(int b = 0;b<array.length;b++) {
            	//Se realiza la validacion de que el caracter que viene en la matriz pertenezca al alfabeto o que tenga espacio en blanco 
            	if(Character.isAlphabetic(matriz[b][a]) || Character.isWhitespace(matriz[b][a])){
            		respuesta+=matriz[b][a];
            	}
            }
        }
		
		return respuesta;
	}
}
