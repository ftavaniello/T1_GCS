import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    Scanner entrada = new Scanner (System.in);
    private Empresa empresa;
    
    
    public App () {
        empresa = new Empresa();
    }

    public void executar() {
        Usuario u1 = new Usuario(1101, "Flavia Tavaniello");
        Usuario u2 = new Usuario(1102, "Gustavo Trevisol");
        Usuario u3 = new Usuario(1103, "Helena Pacheco");
        Usuario u4 = new Usuario(1104, "Rafaelo Mello");
        Usuario u5 = new Usuario(1105, "Giancarlo Silva");
        Usuario u6 = new Usuario(1106, "Pedro Reginato");
        Usuario u7 = new Usuario(1107, "Arthur Plenz");
        Usuario u8 = new Usuario(1108, "Pedro Favieiro");
        Usuario u9 = new Usuario(1109, "Carlos Ornél");
        Usuario u10 = new Usuario(1110, "Otavio Parraga");
        Usuario u11 = new Usuario(1111, "Marcelo Yamaguti");
        Usuario u12 = new Usuario(1112, "Brasil");
        Usuario u13 = new Usuario(1113, "Bella");
        Usuario u14 = new Usuario(1114, "Diaz com z");
        Usuario u15 = new Usuario(1115, "Dias Justin");
        Usuario u16 = new Usuario(3301, "Rogério");
        
        while (true) {
            System.out.println("Bem-vindo ao sistema de pedidos de aquisição.");
            System.out.println("Escolha o tipo de usuário:");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Administrador");
            System.out.println("0 - Sair");

            Usuario usuarioAtual = null;
            int opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
                break;
            }

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }


        // Pedido pedido1 = new Pedido(LocalDate.of(2024, 10, 4));
        // Pedido pedido2 = new Pedido(LocalDate.of(2024,3,26));

        // empresa.registrarPedidos(pedido1);
        // empresa.registrarPedidos(pedido2);

        // empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        // ArrayList<Pedido> p = empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        
        // for (Pedido pe : p) {
        //     System.out.println(pe.toString());
        // }
    }
}
