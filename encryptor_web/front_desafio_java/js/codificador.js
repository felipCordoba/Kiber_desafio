function codificar_texto(){

    var input_texto = document.getElementById("input1").value;
   
    const url_api_codificar= "http://localhost:8080/Codificador/generarCodigo";

     //Codificar   
    var xmlHttp = new XMLHttpRequest(); 
    xmlHttp.addEventListener("load",onRequest_codificar)
    xmlHttp.open("POST", url_api_codificar, true); 
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xmlHttp.send(JSON.stringify({ "texto": input_texto } ));
    

}

function onRequest_codificar(){
    if(this.readyState=== 4 && this.status===200){
        alert('Texto codificado con exito');
        document.getElementById("input2").innerHTML = this.response;

    }
}
