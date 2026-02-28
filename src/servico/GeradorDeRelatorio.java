package servico;

import modelo.Usuario;
import modelo.Conta;

import java.math.BigDecimal;
import java.util.Map;

public class GeradorDeRelatorio {

    public void gerarDadosDeTodasAsContas(Map<String, Usuario> repositorioUsuarios) {

        System.out.println("\n=== RELATORIO FINAL ===\n");

        for (Map.Entry<String, Usuario> usuarioRepositorio : repositorioUsuarios.entrySet()) {

            String nomeUsuario = usuarioRepositorio.getKey();
            Usuario usuario = usuarioRepositorio.getValue();

            System.out.println("Titular: " + nomeUsuario);

            for (Conta conta : usuario.getContas()) {


                String identificadorConta =
                        conta.getBanco() + "|" +
                                conta.getAgencia() + "|" +
                                conta.getNumero();

                BigDecimal saldo = conta.getSaldo();

                System.out.println(
                        "   Conta: " + identificadorConta +
                                " | Saldo: " + saldo
                );
            }

            System.out.println();
        }
    }
}