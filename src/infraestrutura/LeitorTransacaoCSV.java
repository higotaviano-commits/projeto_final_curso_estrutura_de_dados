package infraestrutura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoOperacao;

public class LeitorTransacaoCSV {

    public List<RegistroPorLinhaCSV> ler(String caminho) throws Exception {

        List<RegistroPorLinhaCSV> registrosPorLinhaCSV = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] campos = linha.split(",");

                registrosPorLinhaCSV.add(new RegistroPorLinhaCSV(
                        campos[0],
                        campos[1],
                        campos[2],
                        campos[3],
                        TipoOperacao.valueOf(campos[4]),
                        LocalDateTime.parse(campos[5]),
                        new BigDecimal(campos[6])
                ));
            }
        }

        return registrosPorLinhaCSV;
    }
}