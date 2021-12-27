package com.kiber.encryptor.controlador;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiber.encryptor.model.CodificadorModel;
import com.kiber.encryptor.model.DecodificadorModel;
import com.kiber.encryptor.servicio.DecodificarServicio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
@RequestMapping("/Decodificador")
public class DecodificadorController {
	@PostMapping("/generarTexto")
	public String GenerarTexto(@RequestBody DecodificadorModel decodificadorModel){
		
	DecodificarServicio servicio = new DecodificarServicio();
	
	if(decodificadorModel.getCodigo()!= null) {
		return servicio.DecodificarCodigo(decodificadorModel.getCodigo());
	}else {
		return "El código enviado es invalido";
	}
	
}
	

}
