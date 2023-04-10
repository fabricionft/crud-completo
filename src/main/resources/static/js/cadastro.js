function verificar(){
    var erros = [];
    var numeroErros = 0;

    var email = $("#email").val();
    var idade = $("#idade").val()

    if(idade < 0 || idade >= 110){
        erros.push("<br><br>- A idade digitada é impossível");
        numeroErros++;
        $("#idade").val(" ")
    }

    if(email.substring(email.length - 10) != "@gmail.com"){
        erros.push("<br><br>- É necessário que seu email possua o prefixo '@gmail.com'");
        numeroErros++;
        $("#email").val(" ")
    }

    if(numeroErros > 0) gerarMessageBox(2, "Erro(s):"+erros, "Tentar novamente");
    else salvar();
}

function salvar(){
    $.ajax({
        method: "POST",
        url: "/pessoa",
        data: JSON.stringify(
        {
            codigo: $('#codigo').val(),
            nome: $("#nome").val(),
            idade: $("#idade").val(),
            email: $("#email").val()
        }),
        contentType: "application/json; charset-utf8",
        success: function (dados){
            gerarMessageBox(1, dados, "Prosseguir");
        }
    }).fail(function(err){
        tratarErro(err);
    });
}