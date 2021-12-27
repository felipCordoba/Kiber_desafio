package com.kiber.encryptor.controlador;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kiber.encryptor.model.CodificadorModel;
import com.kiber.encryptor.servicio.CodificarServicio;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/Codificador")
public class CodificadorController {
	@PostMapping("/generarCodigo")
	public String GenerarCodigo(@RequestBody CodificadorModel codificadorModel){
		CodificarServicio servicio = new CodificarServicio();
		
		if(codificadorModel.getTexto()!= null) {
			return servicio.CodificarTexto(codificadorModel.getTexto());
		}else {
			return "El texto enviado es invalido";
		}
		
	}

}
