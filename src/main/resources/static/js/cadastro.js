function verificar(){
    var erros = [];
    var numeroErros = 0;

    var email = $("#email").val();
    var idade = $("#idade").val()

    if(idade < 0 || idade >= 110){
        erros.push("\n- Idade impossível");
        numeroErros++;
        $("#idade").val(" ")
    }

    if(email.substring(email.length - 10) != "@gmail.com"){
        erros.push("\n- Falta o prefixo '@gmail.com'");
        numeroErros++;
        $("#email").val(" ")
    }

    if(numeroErros > 0){
        alert("Erro(s): \n"+erros);
    }else salvar();
}

function salvar(){
    $.ajax({
        method: "POST",
        url: "salvar",
        data: JSON.stringify(
        {
            codigo: $('#codigo').val(),
            nome: $("#nome").val(),
            idade: $("#idade").val(),
            email: $("#email").val()
        }),
        contentType: "application/json; charset-utf8",
        success: function (response){
            alert("Registro salvo com suesso!");
            for(var i = 1; i <= localStorage.getItem('quantidade'); i++) $("#linha").remove();
            listar();
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao salvar: " +xhr.responseText);
    });
}