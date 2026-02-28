import infraestrutura.LeitorTransacaoCSV;
import infraestrutura.RegistroPorLinhaCSV;
import servico.TratamentoDeTransacoes;
import servico.GeradorDeRelatorio;
import modelo.Usuario;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o caminho completo do arquivo CSV:");
        String caminhoArquivo = scanner.nextLine();

        try {

            LeitorTransacaoCSV leitor = new LeitorTransacaoCSV();
            List<RegistroPorLinhaCSV> registros = leitor.ler(caminhoArquivo);

            TratamentoDeTransacoes tratamento = new TratamentoDeTransacoes();
            Map<String, Usuario> repositorioUsuarios =
                    tratamento.criarRepositorioUsuarios(registros);

            GeradorDeRelatorio geradorDeRelatorio = new GeradorDeRelatorio();
            geradorDeRelatorio.gerarDadosDeTodasAsContas(repositorioUsuarios);

        } catch (Exception e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}