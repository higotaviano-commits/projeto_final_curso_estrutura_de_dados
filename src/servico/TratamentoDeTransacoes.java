package servico;

import infraestrutura.RegistroPorLinhaCSV;
import modelo.Conta;
import modelo.Transacao;
import modelo.Usuario;

import java.util.*;

public class TratamentoDeTransacoes {

    public Map<String, Usuario> criarRepositorioUsuarios(List<RegistroPorLinhaCSV> registros) {
        List<RegistroPorLinhaCSV> registrosUnicos = desduplicar(registros);
        Map<String, Usuario> repositorioUsuarios = new HashMap<>();

        for (RegistroPorLinhaCSV registro : registrosUnicos) {
            Usuario usuario = criarOuBuscarUsuario(registro, repositorioUsuarios);
            Conta conta = criarOuBuscarConta(registro, usuario);
            Transacao transacao = criarTransacao(registro);
            conta.adicionarTransacao(transacao);
        }
        return repositorioUsuarios;
    }


    private List<RegistroPorLinhaCSV> desduplicar(List<RegistroPorLinhaCSV> registros) {
        return new ArrayList<>(new HashSet<>(registros));
    }


    private Usuario criarOuBuscarUsuario(RegistroPorLinhaCSV registroPorLinhaCSV, Map<String, Usuario> usuarios) {
        Usuario usuario = usuarios.get(registroPorLinhaCSV.nome());
        if (usuario == null) {
            usuario = new Usuario(registroPorLinhaCSV.nome());
            usuarios.put(registroPorLinhaCSV.nome(), usuario);
        }
        return usuario;
    }



    private Conta criarOuBuscarConta(RegistroPorLinhaCSV registro, Usuario usuario) {
        return usuario.buscarOuCriarConta(
                registro.banco(),
                registro.agencia(),
                registro.conta()
        );
    }

    private Transacao criarTransacao(RegistroPorLinhaCSV registro) {
        return new Transacao(
                registro.tipo(),
                registro.valor(),
                registro.dataHora()
        );
    }


}