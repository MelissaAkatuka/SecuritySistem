//Ambiente
const formulario = document.querySelector("form");
const InomeAmbiente = document.querySelector(".nomeAmbiente");
const IportaArduino = document.querySelector(".portaArduino");

function cadastrarAmbiente(){
    fetch("http://localhost:8081/ambiente",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nomeAmbiente: InomeAmbiente.value,
            portaArduino: IportaArduino.value
        })
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};

function limpar(){ 
    InomeAmbiente.value = "";
    IportaArduino.value = "";
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrarAmbiente();
    limpar()
});