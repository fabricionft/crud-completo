window.onload = () => listar();

function listar(){
    $.ajax({
        method: "GET",
        url: "listar",
        success: function (dados){
            dados.forEach(dados => criaLinha(dados));
            localStorage.setItem('quantidade', dados.length);
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao excluir: " +xhr.responseText);
    });
}

function criaLinha(dados){
    $("#dados").append(
        '<div class="linha" id="linha">'+
            '<div class="coluna-1"><p class="texto">'+dados.nome.split(" ")[0]+'</p></div>'+
            '<div class="coluna-2"><p class="texto">'+dados.idade+'</p></div>'+
            '<div class="coluna-3"><p class="texto">'+dados.email+'</p></div>'+
            '<div class="coluna-4">'+
                '<button class="editar"  onclick="editar('+dados.codigo+')">Editar</button>'+
                '<button class="excluir" onclick="deletar('+dados.codigo+')">Excluir</button>'+
            '</div>'+
        '</div>'
    );
}

function editar(codigo){
    $.ajax({
        method: "GET",
        url: "buscarPorID",
        data: "codigo="+codigo,
        success: function (dados){
            $("#codigo").val(dados.codigo);
            $("#nome").val(dados.nome);
            $("#idade").val(dados.idade);
            $("#email").val(dados.email);
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao salvar: " +xhr.responseText);
    });
}

function deletar(codigo){
    $.ajax({
        method: "DELETE",
        url: "deletar",
        data: "codigo="+codigo,
        success: function (dados){
            alert("Registro deletado com suesso!");
            for(var i = 1; i <= localStorage.getItem('quantidade'); i++) $("#linha").remove();
            listar();
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao salvar: " +xhr.responseText);
    });
}

var a = true
function ordenar(){
    if(a) a = false;
    else{
        for(var i = 1; i <= localStorage.getItem('quantidade'); i++) $("#linha").remove();
        if($("#ordenar").val() == "nome"){
            $.ajax({
                method: "GET",
                url: "listarPorOrdemAlfabetica",
                success: function (dados){
                    dados.forEach(dados => criaLinha(dados));
                }
            }).fail(function(xhr, status, errorThrown){
                alert("Erro ao excluir: " +xhr.responseText);
            });
        }else if($("#ordenar").val() == "idade"){
            $.ajax({
                method: "GET",
                url: "listarPorIdade",
                success: function (dados){
                    dados.forEach(dados => criaLinha(dados));
                }
            }).fail(function(xhr, status, errorThrown){
                alert("Erro ao excluir: " +xhr.responseText);
            });
        }

        a = true;
    }
}

function pesquisar(){
    for(var i = 1; i <= localStorage.getItem('quantidade'); i++) $("#linha").remove();
    $.ajax({
        method: "GET",
        url: "buscarPorParte",
        data: "nome="+$("#pesquisar").val(),
        success: function (dados){
            dados.forEach(dados => criaLinha(dados));
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao salvar: " +xhr.responseText);
    });
}