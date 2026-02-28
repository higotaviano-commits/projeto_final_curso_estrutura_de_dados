package infraestrutura;


import modelo.TipoOperacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroPorLinhaCSV(
        String agencia,
        String conta,
        String banco,
        String nome,
        TipoOperacao tipo,
        LocalDateTime dataHora,
        BigDecimal valor
) {}
