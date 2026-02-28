package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Conta {

    private final String banco;
    private final String agencia;
    private final String numero;
    private final Usuario usuario;
    private final List<Transacao> transacoes = new ArrayList<>();
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(String banco, String agencia, String numero, Usuario usuario) {
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.usuario = usuario;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
        saldo = saldo.add(transacao.valorComSinal());
    }

    public void ordenarTransacoes() {
        transacoes.sort(Comparator.comparing(Transacao::getDataHora));
    }

    public BigDecimal getSaldo() {
        ordenarTransacoes();
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
