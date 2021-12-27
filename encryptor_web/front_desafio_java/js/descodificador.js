function descodificar_texto(){

    var codigo = document.getElementById("input2").value;
   
    const url_api_codificar= "http://localhost:8080/Decodificador/generarTexto";

     //Codificar   
    var xmlHttp = new XMLHttpRequest(); 
    xmlHttp.addEventListener("load",onRequest_descodificar)
    xmlHttp.open("POST", url_api_codificar, true); 
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xmlHttp.send(JSON.stringify({ "codigo": codigo } ));
    

}

function onRequest_descodificar(){
    if(this.readyState=== 4 && this.status===200){
        alert('Texto descodificado con exito');
        document.getElementById("input1").value = this.response;

    }
}
