//Usuario
const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Isobrenome = document.querySelector(".sobrenome");
const Icelular = document.querySelector(".celular");
const InomeUsuario = document.querySelector(".nomeUsuario");
const Isenha = document.querySelector(".senha");

//SOS
const Imensagem = document.querySelector(".mensagem");
const Icel1 = document.querySelector(".cel1");
const Icel2 = document.querySelector(".cel2");
const Icel3 = document.querySelector(".cel3");

function cadastrarUsuario(){
    fetch("http://localhost:8081/usuario",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            sobrenome: Isobrenome.value,
            celular: Icelular.value,
            nomeUsuario: InomeUsuario.value,
            senha: Isenha.value
        })
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};

function cadastrarSOS(){
    fetch("http://localhost:8081/sos",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            mensagem: Imensagem.value,
            cel1: Icel1.value,
            cel2: Icel2.value,
            cel3: Icel3.value
        })
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};

function limpar(){
    Inome.value = "";
    Isobrenome.value = "";
    Icelular.value = "";
    InomeUsuario.value = "";
    Isenha.value = "";
    Imensagem.value = "";
    Icel1.value = "";
    Icel2.value = "";
    Icel3.value = "";
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrarUsuario();
    cadastrarSOS();
    limpar()
});