import java.time.LocalDate;
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
                                menuFuncionario(u);
                            }
                            else {
                                //menu do adm
                                menuAdministrador(u);
                            }
                        }
                    }
                }
            }else{
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

        public void menuAdministrador (Usuario administrador){
            while (true){
                System.out.println(administrador.getNome() + ", o que você deseja fazer? ");
                System.out.println("1 - Solicitar uma aquisição");
                System.out.println("2 - Avaliar solicitações");
                System.out.println("3 - Listar pedidos entre datas");
                System.out.println("4 - Buscar pedidos por funcionário");
                System.out.println("5 - Buscar pedidos por descrição de itens");
                System.out.println("6 - Analisar estatísticas dos pedidos");
                System.out.println("7 - Sair");
                int n = entrada.nextInt();
                if (n == 1) {
                    solicitarPedido(administrador);
                }
                else if (n == 2) {
                    //avaliar solicitações
                }else if (n == 3) {
                    //listar todos os pedidos entre 2 datas
                }else if (n == 4) {
                    //buscar pedidos por funcionário solicitante 
                }else if (n == 5) {
                    //buscar pedidos por descrição do item
                }else if (n == 6) {
                    menuEstatísticas(administrador, empresa.getPedidos());
                }else if (n == 7) {
                    break;
                }else {
                    System.out.println("Informe uma opção válida.");
                }
            }
        }

        public void menuEstatísticas (Usuario administrador, ArrayList<Pedido> arrayList) {
            while (true){
                System.out.println(administrador.getNome () + ", qual estatística você deseja ver?");
                System.out.println("1 - Número total de pedidos, dividos por status");
                System.out.println("2 - Número de pedidos nos últimos 30 dias, e seus valores médios");
                System.out.println("3 - Valor total de cada categoria nos últimos 3 dias");
                System.out.println("4 - Detalhes do pedido de maior valor em aberto");
                System.out.println("5 - Sair");
                int n = entrada.nextInt();
                if (n ==1){
                    menuTotalStatus(administrador);
                }else if (n == 2){

                }else if (n == 3){

                }else if (n == 4){

                }else if (n == 5){
                    break;
                }else{
                    System.out.println("Informe uma opção válida.");
                }
            }
        }

        public void menuTotalStatus (Usuario administrador){
            while (true){
                System.out.println("Você deseja ver qual o total de pedidos de qual status?");
                System.out.println("1 - Aprovados");
                System.out.println("2 - Reprovados");
                System.out.println("3 - Concluídos");
                System.out.println("4 - Sair");
                int n = entrada.nextInt();
                //cria pedido
                //set status
                //add na empresa

                Pedido pedido1 = new Pedido(administrador, empresa.getDepartamentos().get(0), LocalDate.now());
                pedido1.setStatus("Aprovado");
                empresa.adicionaPedido(pedido1);

                if(n == 1){
                    System.out.println("Total de pedidos aprovados e seu percentual:");
                    //for (Pedido p : empresa.getPedidos()){
                    for (int i = 0; i < empresa.getPedidos().size(); i++) {
                         if(pedido1.getStatus().equals("Aprovado")){
                        //System.out.println(p.toString());
                        System.out.println("Pedido " + i+1 + ": ");
                        System.out.println(pedido1);
                        System.out.println();
                        }
                    }
                    //}
                    
                }else if ( n== 2){
                    System.out.println("Total de pedidos reprovados seu percentual:");
                    //chamar método

                }else if (n == 3){
                    System.out.println("Total de pedidos concluídos e seu percentual:");
                    //chamar método

                }else if (n == 4){
                    break;
                }
            }
        }

        public void menuFuncionario (Usuario funcionario) {
            while (true) { 
            System.out.println(funcionario.getNome() + ", o que você deseja fazer? ");
            System.out.println("1 - Solicitar uma aquisição");
            System.out.println("2 - Ver o meu histórico de solicitações");
            System.out.println("3 - Sair");
            int n = entrada.nextInt();
            if (n == 1) {
                solicitarPedido(funcionario);
            }
            else if (n == 2) {
                System.out.println("Histórico de pedidos de " + funcionario.getNome() + ": ");
                ArrayList<Pedido> pedidosFuncionario = new ArrayList<>();
                for (Pedido p : empresa.getPedidos()) {
                    if (p.getUsuSolicitante() == funcionario) {
                        pedidosFuncionario.add(p);
                }
                }
                if (pedidosFuncionario.isEmpty()) {
                    System.out.println("Você não realizou nenhum pedido.");
                }
                else {
                    int c = 1;
                    for (Pedido x : pedidosFuncionario) {
                        System.out.println("Pedido " + c );
                        System.out.println(x.toString());
                        c++;
                    }
                    System.out.print("Deseja excluir algum pedido? [S/N] ");
                    entrada.nextLine();
                    String r = entrada.nextLine();
                    if (r.toUpperCase().equals("S")){
                        System.out.print("Qual o número do pedido? ");
                        int num = entrada.nextInt();
                        if (pedidosFuncionario.get(num-1).getStatus().equals("Aberto")) {
                             empresa.removePedido(pedidosFuncionario.get(num-1));
                             System.out.println("Pedido removido com sucesso");
                        }
                        else {
                            System.out.println("Houve uma falha: um pedido só pode ser removido se seu status estiver ABERTO");
                        }
                       
                }
                else {
                    break;
                }
            }
            }
            else if (n == 3) {
                break;
            }
            else {
                System.out.println("Informe uma opção válida.");
            }
            }
        } 

        public void solicitarPedido (Usuario usuario) {
            Produto p1 = new Produto("Caneta BIC cor azul", "Caneta", 2);
            Produto p2 = new Produto("Bloco de notas", "Bloco de notas", 10);
            Produto p3 = new Produto("Computador", "Computador", 3000);
            Produto p4 = new Produto("Café", "Café", 20);
            Produto p5 = new Produto("Mousepad", "Mousepad", 20);
            ArrayList<Produto> todosProdutos = new ArrayList<>();
            todosProdutos.add(p1);
            todosProdutos.add(p2);
            todosProdutos.add(p3);
            todosProdutos.add(p4);
            todosProdutos.add(p5);

            Departamento depPedido = new Departamento(null, null);
                for (Departamento d : empresa.getDepartamentos()) {
                    for (Usuario u : d.getUsuario()) {
                        if (u == usuario) {
                            depPedido = d;
                            break;
                    }
                }
            }

            ArrayList<Produto> compras = new ArrayList<>();
            
            while (true) {
                System.out.print("Informe o dia de hoje: ");
                int dia = entrada.nextInt();
                System.out.print("Informe o mês: ");
                int mes = entrada.nextInt();

                System.out.println(usuario.getNome() + " qual item abaixo você deseja adquirir? ");
                int contador = 1;
                for (Produto i : todosProdutos) {
                    System.out.println(contador + " - " + i.toString());
                    contador ++;
                }
                System.out.println("Qual desse você deseja adquirir? ");
                int c = entrada.nextInt();
                System.out.println("Quantas unidades? ");
                int qtd = entrada.nextInt();
                entrada.nextLine();
                for (int i = 1; i<=qtd; i++) {
                    compras.add(todosProdutos.get(c-1));
                } 
                System.out.println("Total desse item: R$ " +  todosProdutos.get(c-1).getValorUnitario() * qtd);
                System.out.println("Deseja adicionar mais um item? [S/N]");
                String resp = entrada.nextLine();
                if (resp.toUpperCase().equals("N")) {
                    System.out.println("Revisão do pedido: ");
                    Pedido p = new Pedido (usuario, depPedido, LocalDate.of(2024, mes,dia));
                    p.setProdutos(compras);
                    empresa.adicionaPedido(p);
                    System.out.println(p.toString());
                    break;
                }
            }
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