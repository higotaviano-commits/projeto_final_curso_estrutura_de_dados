package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private final String nome;
    private final Map<String, Conta> contas = new HashMap<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Conta buscarOuCriarConta(String banco, String agencia, String numero) {
        String chave = banco + "|" + agencia + "|" + numero;
        Conta conta = contas.get(chave);
        if (conta == null) {
            conta = new Conta(banco, agencia, numero, this);
            contas.put(chave, conta);
        }
        return conta;
    }


    public String getNome() {
        return nome;
    }

    public Collection<Conta> getContas() {
        return contas.values();
    }
}