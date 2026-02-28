package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private final TipoOperacao tipo;
    private final BigDecimal valor;
    private final LocalDateTime dataHora;

    public Transacao(TipoOperacao tipo, BigDecimal valor, LocalDateTime dataHora) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public BigDecimal valorComSinal() {
        return tipo == TipoOperacao.DEPOSITO
                ? valor
                : valor.negate();
    }
}