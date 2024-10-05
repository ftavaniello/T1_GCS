import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner entrada = new Scanner (System.in);
    private Empresa empresa;
    
    
    public App () {
        empresa = new Empresa();
    }

    public void executar() {
        dadosInicias();
        
        //menu inicial
        while (true) {
            int n;
            System.out.println("Bem-vindo ao sistema de pedidos de aquisição.");
            System.out.println("Insira o seu código identificador: [digite -1 para sair]");
            n = entrada.nextInt();
            if (n == -1) {
                break;
            }
            if (empresa.existeUsuario(n)) {
                for (Departamento d : empresa.getDepartamentos()) {
                    for (Usuario u : d.getUsuario()) {
                        if (u.getIdentificador() == n) {
                            if (u.getTipo().equals("Funcionario")) {
                                System.out.println("ENTREI FUN");
                                menuFuncionario(u);
                            }
                            else {
                                System.out.println("ENTREI ADM");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Usuário não encontrado, tente novamente.");

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
        }


        public void menuFuncionario (Usuario funcionario) {
            
        } 


        public void dadosInicias() {
        ArrayList <Usuario> usuariosDTI = new ArrayList<>();
        ArrayList <Usuario> usuariosDRH = new ArrayList<>();
        ArrayList <Usuario> usuariosDMarketing = new ArrayList<>();
        ArrayList <Usuario> usuariosDFinanceiro = new ArrayList<>();
        ArrayList <Usuario> usuariosDAdm = new ArrayList<>();

        ArrayList<Departamento> departamentos = new ArrayList<>();
        
        Usuario u1 = new Usuario(1101, "Flavia");
        Usuario u2 = new Usuario(1102, "Gustavo");
        Usuario u3 = new Usuario(1103, "Helena");
        usuariosDTI.add(u1);
        usuariosDTI.add(u2);
        usuariosDTI.add(u3);
        Departamento ti = new Departamento("TI", usuariosDTI);
        departamentos.add(ti);

        Usuario u4 = new Usuario(1104, "Rafaelo");
        Usuario u5 = new Usuario(1105, "Giancarlo");
        Usuario u6 = new Usuario(1106, "Pedro");
        usuariosDRH.add(u4);
        usuariosDRH.add(u5);
        usuariosDRH.add(u6);
        Departamento rh = new Departamento("RH", usuariosDRH);
        departamentos.add(rh);

        Usuario u7 = new Usuario(1107, "Arthur");
        Usuario u8 = new Usuario(1108, "Joao");
        Usuario u9 = new Usuario(1109, "Carlos");
        usuariosDMarketing.add (u7);
        usuariosDMarketing.add(u8);
        usuariosDMarketing.add(u9);
        Departamento marketing = new Departamento("Marketing", usuariosDMarketing);
        departamentos.add(marketing);

        Usuario u10 = new Usuario(1110, "Otavio");
        Usuario u11 = new Usuario(1111, "Marcelo");
        Usuario u12 = new Usuario(1112, "Henrique");
        usuariosDFinanceiro.add(u10);
        usuariosDFinanceiro.add(u11);
        usuariosDFinanceiro.add(u12);
        Departamento financeiro = new Departamento("Financeiro", usuariosDFinanceiro);
        departamentos.add(financeiro);

        Usuario u13 = new Usuario(1113, "Isabella");
        Usuario u14 = new Usuario(1114, "Miguel");
        Usuario u15 = new Usuario(1115, "Gustavo");
        Usuario u16 = new Usuario(3301, "Rogerio");
        usuariosDAdm.add(u13);
        usuariosDAdm.add(u14);
        usuariosDAdm.add(u15);
        usuariosDAdm.add(u16);
        Departamento administrativo = new Departamento("Administrativo", usuariosDAdm);
        departamentos.add(administrativo);

        empresa.setDepartamentos(departamentos);

        }
    }
