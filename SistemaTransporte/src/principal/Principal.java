package principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import controlador.*;
import modelo.*;
import modelo.enums.MetodoPagamento;
import modelo.enums.TipoAssento;
import modelo.constantes.Constantes;


public class Principal {
    static Scanner scan = new Scanner(System.in);
    String nome, cpf, endereco, telefone, senha;
    static SistemaTransporte sis = SistemaTransporte.getInstance();

    public Principal(){
    }

    public static void alimentarSistema(){

        //Criacao de 5 Motoristas com dados ficticios e variados
        sis.addMotorista("Maria", 45, "98765432100", "5678", "654321", 10, "Sou", "Jardim Europa/Santa Clara");
        sis.addMotorista("Carlos", 28, "12312312312", "8765", "789456", 3, "Sou", "Vila Nova/Centro");
        sis.addMotorista("Ana", 35, "32132132132", "4321", "147258", 7, "Jandaia", "Alvorada/Parque das Flores");
        sis.addMotorista("Pedro", 50, "45645645645", "9101", "369258", 15, "Jandaia", "Jardim Bela Vista/Planalto");
        sis.addMotorista("Fernanda", 32, "78978978978", "6543", "852741", 8, "Andorinha", "Santa Mônica/São Cristóvão");
        sis.addMotorista("Luis", 40, "11223344556", "2109", "963852", 6, "Andorinha", "Centro/Nova Cidade");
        sis.addMotorista("Bruna", 29, "99887766554", "3456", "159753", 4, "Andorinha", "Alameda/Vila Nova");

        //Criação de 20 Paradas com endereços ficticios e variados
        sis.addParada("Rua 1, 123");
        sis.addParada("Rua 2, 456");
        sis.addParada("Rua 3, 789");
        sis.addParada("Rua 4, 101");
        sis.addParada("Rua 5, 112");
        sis.addParada("Rua 6, 131");
        sis.addParada("Rua 7, 415");
        sis.addParada("Rua 8, 161");
        sis.addParada("Rua 9, 171");
        sis.addParada("Rua 10, 181");
        sis.addParada("Rua 11, 191");
        sis.addParada("Rua 12, 201");
        sis.addParada("Rua 13, 211");
        sis.addParada("Rua 14, 221");
        sis.addParada("Rua 15, 231");
        sis.addParada("Rua 16, 241");
        sis.addParada("Rua 17, 251");
        sis.addParada("Rua 18, 261");
        sis.addParada("Rua 19, 271");
        sis.addParada("Rua 20, 281");
        //Array de endereços acima
        String[] enderecos = {"Rua 1, 123", "Rua 2, 456", "Rua 3, 789", "Rua 4, 101", "Rua 5, 112", "Rua 6, 131", "Rua 7, 415", "Rua 8, 161", "Rua 9, 171", "Rua 10, 181", "Rua 11, 191", "Rua 12, 201", "Rua 13, 211", "Rua 14, 221", "Rua 15, 231", "Rua 16, 241", "Rua 17, 251", "Rua 18, 261", "Rua 19, 271", "Rua 20, 281"};

        //criar Paradas Decorator
        ArrayList<Parada> paradas = sis.getParadas();
        int i = 0;
        for(i=0; i<paradas.size(); i++){
            LocalDateTime horario = LocalDateTime.now().plusMinutes(i * 10);
            sis.addParadaDecorator(enderecos[i++], horario);
        }

        //Exibir todas as paradas decoradas
        ArrayList<ParadaDecorator> paradasDec = sis.getDecParadas();
        for(ParadaDecorator parada: paradasDec){
            System.out.println(parada.toString());
            System.out.println("\n==============================\n");
        }

        

        //Criação de 6 Onibus
        sis.addOnibus(26, 5, 2, 3, sis.getMotoristas().get(0), 1, 1);    
        sis.addOnibus(15, 6, 3, 3, sis.getMotoristas().get(1), 2, 2);
        sis.addOnibus(20, 7, 4, 4, sis.getMotoristas().get(2), 3, 3);
        sis.addOnibus(25, 8, 5, 5, sis.getMotoristas().get(3), 4, 4);
        sis.addOnibus(30, 9, 6, 6, sis.getMotoristas().get(4), 5, 5);
        sis.addOnibus(35, 10, 7, 7, sis.getMotoristas().get(5), 6, 6);

        //Criação de 35 Passageiros com dados ficticios e variados, dependendo da idade, o tipo de assento é definido se é COMUM ou IDOSO. 
        //Além disso, há assentos para CADEIRANTE e PLUS_SIZE. CRIE TODOS OS TIPOS DE ASSENTO
        //Telefone deve seguir o padrão (XX)XXXXX-XXXX

        sis.addPassageiro("João", 25, "12345678900", "1234", "Rua 1, 123", "(12)3456-7890", TipoAssento.COMUM);
        sis.addPassageiro("Maria", 65, "98765432100", "5678", "Rua 2, 456", "(98)7654-3210", TipoAssento.IDOSO);
        sis.addPassageiro("Carlos", 30, "12312312312", "8765", "Rua 3, 789", "(12)3123-1231", TipoAssento.COMUM);
        sis.addPassageiro("Ana", 70, "32132132132", "4321", "Rua 4, 101", "(32)1321-3213", TipoAssento.IDOSO);
        sis.addPassageiro("Pedro", 35, "45645645645", "9101", "Rua 5, 112", "(45)6456-4564", TipoAssento.COMUM);
        sis.addPassageiro("Fernanda", 75, "78978978978", "6543", "Rua 6, 131", "(78)9789-8978", TipoAssento.IDOSO);
        sis.addPassageiro("Luis", 40, "11223344556", "2109", "Rua 7, 415", "(11)2233-4455", TipoAssento.COMUM);
        sis.addPassageiro("Bruna", 80, "99887766554", "3456", "Rua 8, 161", "(99)8877-6655", TipoAssento.IDOSO);
        sis.addPassageiro("Mariana Cardoso", 45, "12345678901", "1235", "Rua 9, 171", "(12)3456-7890", TipoAssento.COMUM);
        sis.addPassageiro("Marcos", 85, "98765432101", "5679", "Rua 10, 181", "(98)7654-3210", TipoAssento.IDOSO);
        sis.addPassageiro("Carla", 50, "12312312313", "8766", "Rua 11, 191", "(12)3123-1231", TipoAssento.COMUM);
        sis.addPassageiro("Antonio", 90, "32132132133", "4322", "Rua 12, 201", "(32)1321-3213", TipoAssento.IDOSO);
        sis.addPassageiro("Paulo", 55, "45645645646", "9102", "Rua 13, 211", "(45)6456-4564", TipoAssento.COMUM);
        sis.addPassageiro("Fernanda", 95, "78978978979", "6544", "Rua 14, 221", "(78)9789-8978", TipoAssento.IDOSO);
        sis.addPassageiro("Luiz", 60, "11223344557", "2110", "Rua 15, 231", "(11)2233-4455", TipoAssento.COMUM);
        sis.addPassageiro("Bruno", 100, "99887766555", "3457", "Rua 16, 241", "(99)8877-6655", TipoAssento.IDOSO);
        sis.addPassageiro("Mariana", 65, "12345678902", "1236", "Rua 17, 251", "(12)3456-7890", TipoAssento.COMUM);
        sis.addPassageiro("Marcos", 105, "98765432102", "5680", "Rua 18, 261", "(98)7654-3210", TipoAssento.IDOSO);
        sis.addPassageiro("Carla", 70, "12312312314", "8767", "Rua 19, 271", "(12)3123-1231", TipoAssento.COMUM);
        sis.addPassageiro("Antonio", 110, "32132132134", "4323", "Rua 20, 281", "(32)1321-3213", TipoAssento.IDOSO);
        sis.addPassageiro("Paulo", 75, "45645645647", "9103", "Rua 21, 291", "(45)6456-4564", TipoAssento.IDOSO);
        sis.addPassageiro("Fernanda", 120, "78978978980", "6545", "Rua 22, 301", "(78)9789-8978", TipoAssento.IDOSO);
        sis.addPassageiro("Luiz", 80, "11223344558", "2111", "Rua 23, 311", "(11)2233-4455", TipoAssento.IDOSO);

        //Crie assentos para CADEIRANTE e PLUS_SIZE
        sis.addPassageiro("Paulo", 75, "45645645648", "9104", "Rua 21, 291", "(45)6456-4564", TipoAssento.CADEIRANTE);
        sis.addPassageiro("Fernanda", 120, "78978978981", "6546", "Rua 22, 301", "(78)9789-8978", TipoAssento.PLUS_SIZE);
        sis.addPassageiro("Luiz", 80, "11223344559", "2112", "Rua 23, 311", "(11)2233-4455", TipoAssento.CADEIRANTE);
        sis.addPassageiro("Bruno", 125, "99887766556", "3458", "Rua 24, 321", "(99)8877-6655", TipoAssento.PLUS_SIZE);
        sis.addPassageiro("Mariana", 85, "12345678903", "1237", "Rua 25, 331", "(12)3456-7890", TipoAssento.CADEIRANTE);

        //Alocar passageiros em assentos de onibus variados dos criados anteriormente

        //Onibus 1
        
        //Adicionar passageiros no onibus 1
        sis.addPassageiroOnibus(1, "12345678900");
        sis.addPassageiroOnibus(1, "98765432100");
        sis.addPassageiroOnibus(1, "12312312312");
        sis.addPassageiroOnibus(1, "32132132132");
        sis.addPassageiroOnibus(1, "45645645645");

        
        //Adicionar passageiros no onibus 2
        sis.addPassageiroOnibus(2, "78978978978");
        sis.addPassageiroOnibus(2, "11223344556");
        sis.addPassageiroOnibus(2, "99887766554");
        sis.addPassageiroOnibus(2, "12345678900");
        sis.addPassageiroOnibus(2, "98765432100");

        //Adicionar passageiros no onibus 3
        sis.addPassageiroOnibus(3, "12312312312");
        sis.addPassageiroOnibus(3, "32132132132");
        sis.addPassageiroOnibus(3, "45645645645");
        sis.addPassageiroOnibus(3, "78978978978");
        sis.addPassageiroOnibus(3, "11223344556");

        //Adicionar passageiros no onibus 4
        sis.addPassageiroOnibus(4, "99887766554");
        sis.addPassageiroOnibus(4, "12345678900");
        sis.addPassageiroOnibus(4, "98765432100");
        sis.addPassageiroOnibus(4, "12312312312");
        sis.addPassageiroOnibus(4, "32132132132");

        //Adicionar passageiros no onibus 5
        sis.addPassageiroOnibus(5, "45645645645");
        sis.addPassageiroOnibus(5, "78978978978");
        sis.addPassageiroOnibus(5, "11223344556");
        sis.addPassageiroOnibus(5, "99887766554");
        sis.addPassageiroOnibus(5, "12345678900");
        
        //criar viagens Onibus com veiculo null
        ArrayList<ParadaDecorator> parada1 = sis.getDecParadas();
        Onibus onibus1 = sis.getOnibusNumero(4);
        sis.addViagemOnibus(onibus1, parada1); 


        // //Exibi Todos os Motoristas
        // ArrayList<Motorista> motoristas = sis.getMotoristas();
        // for(Motorista motorista: motoristas){
        //     System.out.println(motorista.toString());
        //     System.out.println("\n==============================\n");
        // }
    }

    /**
     * Método de teste
     */
    public void Teste1(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        sis.addPassageiro("Marcos", 42, "123456789", "4321", "outro endereço", "123321",
                TipoAssento.COMUM);
        // Criação de um passageiro
        Passageiro passageiroComum = sis.getPassageiroCPF("123456789");
        // Criação de um motorista
        //Motorista motorista = sis.createMotorista("João", 30, "123456789", "1234", "123456", 5, "Empresa", "Linha");

        // Criação de um ônibus
        //Onibus onibus = sis.createOnibus(7, 3, 1, 2, motorista, 1, 1);

        // Criação de uma parada
        // Parada local1 = sis.createParada("endereco de teste1");
        // Parada local2 = sis.createParada("endereco de teste2");
        // Parada local3 = sis.createParada("endereco de teste3");

        // Criação de uma array de paradas com horários
        // ParadaDecorator parada1 = sis.createParadaDecorator(local1, LocalDateTime.parse("2024-11-10T10:15:30"));
        // ParadaDecorator parada2 = sis.createParadaDecorator(local2, LocalDateTime.parse("2024-11-10T10:35:30"));
        // ParadaDecorator parada3 = sis.createParadaDecorator(local3, LocalDateTime.parse("2024-11-10T10:45:30"));

        ArrayList<ParadaDecorator> paradas = new ArrayList<ParadaDecorator>();
        // paradas.add(parada1);
        // paradas.add(parada2);
        // paradas.add(parada3);

        // Criação de uma viagem
        //sis.createViagemOnibus(onibus, paradas);

        /*
         * A criação da viagem do passageiro seguiria o seguinte fluxo:
         * - Passageiro (usuário) seleciona a parada de destino
         * - Abre tela de exibição das ViagensOnibus que tem essa parada no trajeto e de
         * onde elas saem
         * - Passageiro seleciona a viagem que ele quer
         * 
         * Tendo em vista que esse fluxo foi seguido, ocorreriam as seguintes chamadas
         */

        // ParadaDecorator destinoSelecionado = parada2;

        // var tipoAssentoPassageiro1 = passageiroComum.getTipoAssento();

        // ArrayList<Viagem> viagensDisponiveis = sis.getAllViagensOnibusByDestino(destinoSelecionado, tipoAssentoPassageiro1);
        // Viagem viagemSelecionada = viagensDisponiveis.get(0);
        // ArrayList<Number> posicoesDisponiveis = viagemSelecionada.getVeiculo().getPosicoesDisponiveis(tipoAssentoPassageiro1);
        // Number posicaoSelecionada = posicoesDisponiveis.get(0);
        // ParadaDecorator embarqueSelecionado = viagemSelecionada.getParadas().get(0);

        // // Gera um bilhete para a viagem
        // sis.createBilhete(passageiroComum, viagemSelecionada, embarqueSelecionado, destinoSelecionado, posicaoSelecionada.intValue(), LocalDateTime.now());

        // System.out.println("Viagem do passageiro criada com sucesso!");

        /*
         * Quando uma um veiculo passar por uma de suas paradas,
         * o método visitarParada da viagem em questão é invocado
         * e a parada em questão é passada por parâmentro, assim 
         * finalizando a viagem do passageiro e atualizando o 
         * bilhete eletrônico.
         */
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());
        // viagemSelecionada.visitarParada(destinoSelecionado.parada);
        System.out.println("Onibus passou pela parada.");
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());
    }


    /**
     * Menu de inicialização
     */
    public static void menuInicializacao(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO SISTEMA DE TRANSPORTE             |");
        System.out.println("=================================================");
        System.out.println("|1 - Modo Administrador                         |");
        System.out.println("|2 - Modo Cliente                               |");
        System.out.println("|0 - Sair                                       |");
        System.out.println("=================================================");
        System.out.println("Digite a opção desejada: ");
    }

    /**
     * Menu do Administrador
     */
    public static void menuAdministrador(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO ADMINISTRADOR                 |");
        System.out.println("=================================================");
        System.out.println("|1 - Cadastrar:                                  |");
        System.out.println("|2 - Definir Motorista do Onibus                 |");
        System.out.println("|3 - Definir Paradas da Viagem                   |");
        System.out.println("|4 - Definir viagem a um Onibus                  |");
        System.out.println("|5 - Excluir:                                    |");
        System.out.println("|6 - Buscar:                                     |");
        System.out.println("|7 - Alterar:                                    |");
        System.out.println("|8 - Exibir:                                     |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
    }

    public static String selecionarBilhete(){
        String id;
        System.out.println("Digite o ID do Bilhete selecionado: ");
        ArrayList<BilheteEletronico> bilhetes = sis.getBilhetesEletronicos();
        System.out.println("======================================================");
        for(BilheteEletronico bilhete: bilhetes){
            System.out.println(bilhete.toString());
            System.out.println("\n==============================\n");
        }
        id = scan.nextLine();
        BilheteEletronico bilhete = sis.getBilheteId(id);
        if(bilhete == null){
            System.out.println("Bilhete não encontrado");
        }else{
            System.out.println("Bilhete selecionado: ");
            System.out.println(bilhete.toString());
        }
        return id;
    }
    /**
     * Menu de seleção de onibus
     * @return {@code int} numOnibus
     */
    public static int selecionarOnibus(){
        int numOnibus;
        ArrayList<Onibus> onibus = sis.getOnibus();
        System.out.println("======================================================");
        for(Onibus onibus1: onibus){
            System.out.println(onibus1.toString());
            System.out.println("\n==============================\n");
        }
        System.out.println("Digite o número do ônibus: ");
        numOnibus = scan.nextInt();
        return numOnibus;
    }

    /**
     * Menu de seleção de motorista
     * @param paradas
     * @return {@code Motorista} motorista
     */
    public static String selecionarParada(ArrayList<Parada> paradas){
        String endereco;
        System.out.println("======================================================");
        for(Parada parada: paradas){
            System.out.println(parada.getEndereco());
            System.out.println("\n==============================\n");
        }
        System.out.println("Digite o endereço da Parada: ");
        endereco = scan.nextLine();
        return endereco;
    }
    /**
     * Menu de seleção de parada
     * @return {@link Parada} parada
     */
    public static Parada selecionarParada(){
        String id;

        System.out.println("Digite o ID da Parada selecionada: ");
        ArrayList<Parada> paradas = sis.getParadas();
        System.out.println("======================================================");
        for(Parada parada: paradas){
            System.out.println(parada.toString());
            System.out.println("\n==============================\n");
        }
        id = scan.nextLine();
        Parada parada = sis.getParadaId(id);
        if(parada == null){
            System.out.println("Parada não encontrada");
        }else{
            System.out.println("Parada selecionada: ");
            System.out.println(parada.toString());
        }

        return parada;
    }

    /**
     * Menu de seleção de ParadaDecorator
     * @return {@code String} endereco
     */
    public static String selecionarParadaDecorator(ArrayList<ParadaDecorator> paradas){
        String id;
        System.out.println("======================================================");
        for(ParadaDecorator parada: paradas){
            System.out.println(parada.toString());
            System.out.println("\n==============================\n");
        }
        System.out.println("Digite o id da Parada: ");
        id = scan.nextLine();
        return id;
    }


    /**
     * Menu de seleção de parada decorator
     * @return {@link ParadaDecorator} parada
     */
    public static ParadaDecorator selecionarParadaDecorator(){
        String id;

        System.out.println("Digite o ID da Parada selecionada: ");
        ArrayList<ParadaDecorator> paradas = sis.getDecParadas();
        System.out.println("======================================================");
        for(ParadaDecorator parada: paradas){
            System.out.println(parada.toString());
            System.out.println("\n==============================\n");
        }
        id = scan.nextLine();
        ParadaDecorator parada = sis.getParadaDecoratorId(id);
        if(parada == null){
            System.out.println("Parada não encontrada");
        }else{
            System.out.println("Parada selecionada: ");
            System.out.println(parada.toString());
        }

        return parada;
    }

    /**
     * menu de seleção de Passageiro
     * @return
     */
    public static String selecionarPassageiro(Assento[] assentos){
        String cpf;
        System.out.println("======================================================");
        for(Assento a: assentos){
            if(a.getPassageiro() != null){
                System.out.println(a.toString());
                System.out.println("\n==============================\n");
            }
        }
        System.out.println("Digite o CPF do Passageiro selecionado: ");
        cpf = scan.nextLine();
        return cpf;

    }

    /**
     * Menu de seleção de passageiro
     * @return {@code String} cpf
     */
    public static String selecionarPassageiro(){
        String cpf;
        System.out.println("Digite o CPF do Passageiro selecionado: ");
        ArrayList<Passageiro> passageiros = sis.getPassageiros();
        System.out.println("======================================================");
        for(Passageiro passageiro: passageiros){
            System.out.println(passageiro.toString());
            System.out.println("\n==============================\n");
        }
        cpf = scan.nextLine();
        Passageiro passageiro = sis.getPassageiroCPF(cpf);
        if(passageiro == null){
            System.out.println("Passageiro não encontrado");
        }else{
            System.out.println("Passageiro selecionado: ");
            System.out.println(passageiro.toString());
        }
        return cpf;

    }

    /**
     * Menu de seleção de motorista
     * @return
     */
    public static Motorista selecionarMotoristaOnibus(){
        String cpfMotorista;
        System.out.println("Digite o CPF do Motorista selecionado: ");
        ArrayList<Motorista> motoristas = sis.getMotoristas();
        System.out.println("======================================================");
        for(Motorista motorista: motoristas){
            System.out.println(motorista.toString());
            System.out.println("\n==============================\n");
        }
        cpfMotorista = scan.nextLine();
        Motorista motorista = sis.getMotoristaCPF(cpfMotorista);
        if(motorista == null){
            System.out.println("Motorista não encontrado");
        }else{
            System.out.println("Motorista selecionado: ");
            System.out.println(motorista.toString());
        }
        return motorista;
    }



    /**
     * Menu de seleção de viagem
     * @return
     */
    public static String selecionarViagem(){
        String id;
        System.out.println("Digite o ID da Viagem selecionada: ");
        ArrayList<Viagem> viagens = sis.getViagens();
        System.out.println("======================================================");
        for(Viagem viagem: viagens){
            System.out.println(viagem.toString());
            System.out.println("\n==============================\n");
        }
        id = scan.nextLine();
        Viagem viagem = sis.getViagemId(id);
        if(viagem == null){
            System.out.println("Viagem não encontrada");
        }else{
            System.out.println("Viagem selecionada: ");
            System.out.println(viagem.toString());
        }
        return id;
    }

    /**
     * Menu de seleção de pagamento de passagem
     * @return
     */
    public static PagamentoPassagem selecionarPagamentoPassagem(){
        String id;
        System.out.println("Digite o ID do Pagamento selecionado: ");
        ArrayList<PagamentoPassagem> pagamentos = sis.getPagamentosPassagem();
        System.out.println("======================================================");
        for(PagamentoPassagem pagamento: pagamentos){
            System.out.println(pagamento.toString());
            System.out.println("\n==============================\n");
        }
        id = scan.nextLine();
        PagamentoPassagem pagamento = sis.getPagamentoPassagemId(id);
        if(pagamento == null){
            System.out.println("Pagamento não encontrado");
        }else{
            System.out.println("Pagamento selecionado: ");
            System.out.println(pagamento.toString());
        }
        return pagamento;
    }
    

    /**
     * Menu de seleção de tipo de assento
     * @return {@code TipoAssento} tipoAssento
     */
    public static TipoAssento selecionarTipoAssento(){
        int tipoAssento;
        System.out.println("Selecione o tipo de assento: ");
        System.out.println("1 - Comum");
        System.out.println("2 - Idoso");
        System.out.println("3 - Cadeirante");
        System.out.println("4 - Plus Size");
        tipoAssento = scan.nextInt();
        switch(tipoAssento){
            case 1:
                return TipoAssento.COMUM;
            case 2:
                return TipoAssento.IDOSO;
            case 3:
                return TipoAssento.CADEIRANTE;
            case 4:
                return TipoAssento.PLUS_SIZE;
            default:
                return TipoAssento.COMUM;
        }
    }

    /**
     * Menu de seleção de método de pagamento
     * @return {@code MetodoPagamento} metodoPagamento
     */
    public static MetodoPagamento selecionarMetodoPagamento(){
        int metodoPagamento;
        System.out.println("Selecione o método de pagamento: ");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão de crédito");
        System.out.println("3 - Cartão de débito");
        System.out.println("4 - PIX");
        metodoPagamento = scan.nextInt();
        switch(metodoPagamento){
            case 1:
                return MetodoPagamento.DINHEIRO;
            case 2:
                return MetodoPagamento.CARTAO_CREDITO;
            case 3:
                return MetodoPagamento.CARTAO_DEBITO;
            case 4:
                return MetodoPagamento.PIX;
            default:
                return MetodoPagamento.DINHEIRO;
        }
    }

    /**
     * Menu de cadastro
     */
    public static void menuCadastrar(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        String nome, cpf, endereco, telefone, senha, viagemId;
        int opcaoCadastrar;
        System.out.println("\n\n=================================================");
        System.out.println("|BEM-VINDO AO MODO DE CADASTRO DO ADMINISTRADOR  |");
        System.out.println("=================================================");
        System.out.println("|1 - Cadastrar Motorista                         |");
        System.out.println("|2 - Cadastrar Passageiro                        |");
        System.out.println("|3 - Cadastrar Onibus                            |");
        System.out.println("|4 - Cadastrar Parada                            |");
        System.out.println("|5 - Cadastrar Viagem                            |");
        System.out.println("|6 - Cadastrar Bilhete                           |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoCadastrar = scan.nextInt();


        switch(opcaoCadastrar){
            case 0: 
                return;
            case 1: 
                System.out.println("======================================================");
                scan.nextLine();
                System.out.println("Digite o nome do Motorista: ");
                nome = scan.nextLine();
                System.out.println("Digite a idade do Motorista: ");
                int idade = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o CPF do Motorista: ");
                cpf = scan.nextLine();
                System.out.println("Digite a senha do Motorista: ");
                senha = scan.nextLine();
                System.out.println("Digite a CNH do Motorista: ");
                String cnh = scan.nextLine();
                System.out.println("Digite a experiência do Motorista: ");
                int experiencia = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite a empresa do Motorista: ");
                String empresa = scan.nextLine();
                System.out.println("Digite a linha de ônibus do Motorista: ");
                String linhaOnibus = scan.nextLine();
                sis.addMotorista(nome, idade, cpf,senha, cnh, experiencia, empresa, linhaOnibus);
                System.out.println("Motorista cadastrado com sucesso!");
                System.out.println("======================================================");
                break;
        
            case 2:
                System.out.println("======================================================");
                scan.nextLine();
                System.out.println("Digite o nome do Passageiro: ");
                nome = scan.nextLine();
                System.out.println("Digite a idade do Passageiro: ");
                idade = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o CPF do Passageiro: ");
                cpf = scan.nextLine();
                System.out.println("Digite a senha do Passageiro: ");
                senha = scan.nextLine();
                System.out.println("Digite o endereço do Passageiro: ");
                endereco = scan.nextLine();
                System.out.println("Digite o telefone do Passageiro: ");
                telefone = scan.nextLine();
                TipoAssento tipoAssento = selecionarTipoAssento();
                sis.addPassageiro(nome, idade, cpf, senha, endereco, telefone, tipoAssento);
                System.out.println("Passageiro cadastrado com sucesso!");
                System.out.println("======================================================");
                break;

            case 3:
                System.out.println("======================================================");
                scan.nextLine();
                System.out.println("Digite a capacidade do ônibus: ");
                int capacidade = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite a quantidade de assentos para idosos: ");
                int assentosIdosos = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite a quantidade de assentos para cadeirantes: ");
                int assentosCadeirantes = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite a quantidade de assentos Plus Size: ");
                int assentosPlusSize = scan.nextInt();
                scan.nextLine();

                Motorista motorista = selecionarMotoristaOnibus();
                System.out.println("\n\nDigite o número do ônibus: ");
                int numOnibus = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o número da linha do ônibus: ");
                int numLinha = scan.nextInt();
                scan.nextLine();
                sis.addOnibus(capacidade, assentosPlusSize, assentosCadeirantes, assentosIdosos,  motorista, numOnibus, numLinha);
                System.out.println("Ônibus cadastrado com sucesso!");
                System.out.println("======================================================");
                break;

            case 4:
                System.out.println("======================================================");
                System.out.println("Digite o endereço da Parada: ");
                endereco = scan.nextLine();
                sis.addParada(endereco);
                System.out.println("Digite o Horario Previsto da Parada: ");
                LocalDateTime horarioPrevisto  = LocalDateTime.parse(scan.nextLine());
                sis.addParadaDecorator(endereco, horarioPrevisto);
                System.out.println("Parada cadastrada com sucesso!");
                System.out.println("======================================================");
                break;

            case 5:
                ArrayList<ParadaDecorator> paradas = new ArrayList<ParadaDecorator>();
                System.out.println("======================================================");
                System.out.println("Digite o numero do Ônibus: ");
                numOnibus = scan.nextInt();
                Onibus onibus = sis.getOnibusNumero(numOnibus);
                System.out.println("Seleção de Paradas: ");
                while(true){
                    System.out.println("1 - Adicionar Parada");
                    System.out.println("0 - Finalizar");
                    int opcao = scan.nextInt();

                    if(opcao == 0){
                        break;
                    }
                    ParadaDecorator parada = selecionarParadaDecorator();
                    paradas.add(parada);

                }                
                sis.addViagemOnibus(onibus, paradas);
                break;

            case 6:
                System.out.println("======================================================");
                scan.nextLine();
                cpf = selecionarPassageiro();
                viagemId = selecionarViagem();
                Viagem viagem = sis.getViagemId(viagemId);
                String idEmbarque = selecionarParadaDecorator(viagem.getParadas());
                String idDesembarque = selecionarParadaDecorator(viagem.getParadas());
                sis.addBilhete(cpf, viagem, idEmbarque, idDesembarque);
                System.out.println("Bilhete cadastrado com sucesso!");
                System.out.println("======================================================");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }


    }

    /**
     * Menu de busca
     */
    public static void buscarAdm(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        int opcaoBuscar;
        Parada parada;
        Onibus onibus;
        ParadaDecorator paradaDecorator;
        int numVeiculo;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE BUSCA DO ADMINISTRADOR     |");
        System.out.println("=================================================");
        System.out.println("|1 - Buscar Motorista                            |");
        System.out.println("|2 - Buscar Passageiro                           |");
        System.out.println("|3 - Buscar Onibus                               |");
        System.out.println("|4 - Buscar Parada                               |");
        System.out.println("|5 - Buscar Viagem                               |");
        System.out.println("|6 - Buscar ParadaDecorator                      |");
        System.out.println("|7 - Buscar Bilhete                              |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoBuscar = scan.nextInt();

        if(opcaoBuscar == 0){
            return;
        }

        switch(opcaoBuscar){
            
            case 1: 
                scan.nextLine();
                System.out.println("======================================================");
                numVeiculo = selecionarOnibus();
                Motorista motorista = sis.getMotorista(numVeiculo);
                if(motorista == null){
                    System.out.println("Motorista não encontrado");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Motorista selecionado: ");
                    System.out.println(motorista.toString());
                }
                System.out.println("======================================================");
                break;
            
        
            case 2:
                scan.nextLine();
                System.out.println("======================================================");
                String cpfPassageiro;
                numVeiculo = selecionarOnibus();
                onibus = sis.getOnibusNumero(numVeiculo);
                scan.nextLine();
                cpfPassageiro = selecionarPassageiro(onibus.getAssentos());
                Passageiro passageiro = sis.getPassageiro(numVeiculo, cpfPassageiro);
                if(passageiro == null){
                    System.out.println("======================================================");
                    System.out.println("Passageiro não encontrado");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Passageiro selecionado: ");
                    System.out.println("Nome: "+ passageiro.getNome());
                    System.out.println("Idade: " + passageiro.getIdade());
                    System.out.println("CPF: " + passageiro.getCpf());
                    System.out.println("ID: " + passageiro.getUUID());
                    System.out.println("Telefone: " + passageiro.getTelefone());
                }
                System.out.println("======================================================");
                break;

            case 3:
                scan.nextLine();
                System.out.println("======================================================");
                numVeiculo = selecionarOnibus();
                onibus = sis.getOnibusNumero(numVeiculo);
                if(onibus == null){
                    System.out.println("======================================================");
                    System.out.println("Ônibus não encontrado");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Ônibus selecionado: ");
                    System.out.println(onibus.toString());
                }
                System.out.println("======================================================");
                break;

            case 4:
                scan.nextLine();
                System.out.println("======================================================");
                String endereco = selecionarParada(sis.getParadas());
                parada = sis.getParadaEndereco(endereco);
                if(parada == null){
                    System.out.println("======================================================");
                    System.out.println("Parada não encontrada");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Parada selecionada: ");
                    System.out.println(parada.toString());
                }
                System.out.println("======================================================");
                break;

            case 5:
                scan.nextLine();
                System.out.println("======================================================");
                String id = selecionarViagem();
                Viagem viagem = sis.getViagemId(id);
                if(viagem == null){
                    System.out.println("======================================================");
                    System.out.println("Viagem não encontrada");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Viagem selecionada: ");
                    System.out.println(viagem.toString());
                }
                System.out.println("======================================================");
                break;

            case 6:
                
                scan.nextLine();
                System.out.println("======================================================");
                String idParada = selecionarParadaDecorator(sis.getDecParadas());
                paradaDecorator = sis.getParadaDecoratorId(idParada);
                if(paradaDecorator == null){
                    System.out.println("======================================================");
                    System.out.println("Parada Decorator não encontrada");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Parada Decorator selecionada: ");
                    System.out.println(paradaDecorator.toString());
                }
                System.out.println("======================================================");
                break;

            case 7:
                scan.nextLine();
                System.out.println("======================================================");
                String idBilhete = selecionarBilhete();
                BilheteEletronico bilhete = sis.getBilheteId(idBilhete);
                if(bilhete == null){
                    System.out.println("======================================================");
                    System.out.println("Bilhete não encontrado");
                }else{
                    System.out.println("======================================================");
                    System.out.println("Bilhete selecionado: ");
                    System.out.println(bilhete.toString());
                }
                System.out.println("======================================================");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

    }

   
    /**
     * Exibir dados do sistema
     */
    public static void exibirAdm(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        ArrayList<Onibus> onibus;
        ArrayList<Motorista> motoristas;
        ArrayList<Viagem> viagens;
        int numOnibus;
        int opcaoExibir;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE EXIBIÇÃO DO ADMINISTRADOR  |");
        System.out.println("=================================================");
        System.out.println("|1 - Exibir Motoristas                           |");
        System.out.println("|2 - Exibir Assentos de um Ônibus                |");
        System.out.println("|3 - Exibir Onibus                               |");
        System.out.println("|4 - Exibir Paradas                              |");
        System.out.println("|5 - Exibir Viagens                              |");
        System.out.println("|6 - Exibir Bilhetes                             |");
        System.out.println("|7 - Exibir Passageiros cadastrados              |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoExibir = scan.nextInt();

        if(opcaoExibir == 0){
            return;
        }

        switch(opcaoExibir){
            case 0: 
                return;
            case 1: 
                motoristas = sis.getMotoristas();
                System.out.println("======================================================");
                for(Motorista motorista: motoristas){
                    System.out.println(motorista.toString());
                    System.out.println("==============================");
                }
                break;
        
            case 2:
                int count = 1;
                onibus = sis.getOnibus();
                scan.nextLine();
                System.out.println("======================================================");
                for(Onibus onib: onibus){
                    System.out.println(onib.toString());
                    System.out.println("==============================");
                }
                System.out.println("Digite o Número do Ônibus: ");
                numOnibus = scan.nextInt();
                Assento[] assentos = sis.getAssentos(numOnibus);
                System.out.println("======================================================");
                for(Assento assento: assentos){
                    System.out.println(count++ + "\n" + assento.toString());;
                    System.out.println("==============================");
                }
                break;

            case 3:
                onibus = sis.getOnibus();
                System.out.println("======================================================");
                for(Onibus onib: onibus){
                    System.out.println(onib.toString());
                    System.out.println("==============================");
                }
                break;

            case 4:
                ArrayList<ParadaDecorator> paradas = sis.getDecParadas();
                System.out.println("======================================================");
                for(ParadaDecorator parada: paradas){
                    System.out.println(parada.toString());
                    System.out.println("==============================");
                }
                System.out.println("======================================================");
                break;

            case 5:
                viagens = sis.getViagens();
                System.out.println("======================================================");
                for(Viagem v: viagens){
                    System.out.println(v.toString());
                    System.out.println("==============================");
                }
                break;

            case 6:
                ArrayList<BilheteEletronico> bilhetes = sis.getBilhetesEletronicos();
                System.out.println("======================================================");
                for(BilheteEletronico bilhete: bilhetes){
                    System.out.println(bilhete.toString());
                    System.out.println("==============================");
                }
                break;

            case 7:
                ArrayList<Passageiro> passageiros = sis.getPassageiros();
                System.out.println("======================================================");
                for(Passageiro passageiro: passageiros){
                    System.out.println(passageiro.toString());
                    System.out.println("==============================");
                }
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    /**
     * Excluir dados do sistema
     */
    public static void excluirAdm(){
        int opcaoExcluir, numOnibus;
        String endereco;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE EXCLUSÃO                   |");
        System.out.println("=================================================");
        System.out.println("|1 - Excluir Motorista                           |");
        System.out.println("|2 - Excluir Passageiro                          |");
        System.out.println("|3 - Excluir Onibus                              |");
        System.out.println("|4 - Excluir Parada Decorator                    |");
        System.out.println("|5 - Excluir Viagem                              |");
        System.out.println("|6 - Excluir Bilhete                             |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoExcluir = scan.nextInt();

        if(opcaoExcluir == 0){
            return;
        }

        switch(opcaoExcluir){
            case 1: 
                scan.nextLine();
                System.out.println("==================================================");
                Motorista motorista = selecionarMotoristaOnibus();
                sis.removerMotorista(motorista);
                System.out.println("Motorista removido com sucesso!");
                System.out.println("==================================================");
                break;
        
            case 2:
                System.out.println("==================================================");
                scan.nextLine();
                String cpf = selecionarPassageiro();
                numOnibus = selecionarOnibus();
                sis.removerPassageiro(numOnibus, cpf);
                System.out.println("Passageiro removido com sucesso!");
                System.out.println("==================================================");
                break;

            case 3:
                System.out.println("==================================================");
                numOnibus = selecionarOnibus();
                sis.removerOnibus(numOnibus);
                System.out.println("Ônibus removido com sucesso!");
                System.out.println("==================================================");
                break;

            case 4:
                System.out.println("==================================================");
                String viagemId = selecionarViagem();
                Viagem viagem = sis.getViagemId(viagemId);
                endereco = selecionarParadaDecorator(viagem.getParadas());
                sis.removerParadaViagem(viagemId, endereco);
                System.out.println("Parada removida com sucesso!");
                System.out.println("==================================================");

                break;

            case 5:

                System.out.println("==================================================");
                viagemId = selecionarViagem();
                sis.removerViagem(viagemId);
                System.out.println("Viagem removida com sucesso!");
                System.out.println("==================================================");
                break;

            case 6:
                System.out.println("==================================================");
                scan.nextLine();
                String id = selecionarBilhete();
                sis.removerBilhete(id);
                System.out.println("Bilhete removido com sucesso!");
                System.out.println("==================================================");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    /**
     * Alterar dados do sistema
     */
    public static void alterarAdm(){
        int opcaoAlterar;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE ALTERAÇÃO                   |");
        System.out.println("=================================================");
        System.out.println("|1 - Alterar Motorista                           |");
        System.out.println("|2 - Alterar Passageiro                          |");
        System.out.println("|3 - Alterar Onibus                              |");
        System.out.println("|4 - Alterar Parada                              |");
        System.out.println("|5 - Alterar Viagem                              |");
        System.out.println("|6 - Alterar ParadaDecorator                     |");
        System.out.println("|7 - Alterar Bilhete                             |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoAlterar = scan.nextInt();

        if(opcaoAlterar == 0){
            return;
        }

        switch(opcaoAlterar){
            case 1: 
                break;
        
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }


    /**
     * Menu do Cliente 
     */
    public static void menuCliente(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO CLIENTE                       |");
        System.out.println("=================================================");
        System.out.println("|1 - Comprar Passagem                            |");
        System.out.println("|2 - Cancelar Passagem                           |");
        System.out.println("|3 - Exibir Viagens                              |");
        System.out.println("|4 - Exibir Paradas                              |");
        System.out.println("|0 - Voltar                                      |");
        System.out.println("=================================================");
    }

    
    /**
     * Exibir viagens disponíveis e suas paradas para o cliente 
     */
    public static void comprarPassagem(){
        System.out.println("======================================================");
        System.out.println("Viagens Disponíveis: ");
        ArrayList<Viagem> viagens = sis.getViagens();
        for(Viagem viagem: viagens){
            System.out.println(viagem.toString());
            System.out.println("\n==============================\n");
        }
        System.out.println("======================================================");
        System.out.println("Digite o ID da Viagem desejada: ");
        String id = scan.nextLine();
        Viagem viagem = sis.getViagemId(id);
        if(viagem == null){
            System.out.println("Viagem não encontrada");
            return;
        }
        System.out.println("======================================================");
        System.out.println("Paradas da Viagem: ");
        ArrayList<ParadaDecorator> paradas = viagem.getParadas();
        for(ParadaDecorator parada: paradas){
            System.out.println(parada.toString());
            System.out.println("\n==============================\n");
        }
        System.out.println("======================================================");
        System.out.println("Digite o ID da Parada de Embarque: ");
        String idEmbarque = scan.nextLine();
        System.out.println("Digite o ID da Parada de Desembarque: ");
        String idDesembarque = scan.nextLine();
        System.out.println("Digite o CPF do Passageiro: ");
        String cpf = scan.nextLine();
        MetodoPagamento metodoPagamento = selecionarMetodoPagamento();
        double valorPassagem = Constantes.VALOR_PASSAGEM;
        sis.addPagamentoPassagem(cpf, valorPassagem, metodoPagamento);
        PagamentoPassagem pagamentoPassagem = selecionarPagamentoPassagem();
        pagamentoPassagem.realizarPagamento();
        sis.addBilhete(cpf, viagem, idEmbarque, idDesembarque);
        System.out.println("Bilhete comprado com sucesso!");
        System.out.println("======================================================");
    }

    /**
     * Cancelar passagem
     */
    public static void cancelarPassagem(){
        scan.nextLine();
        System.out.println("======================================================");
        System.out.println("Digite seu CPF: ");
        String cpf = scan.nextLine();
        String id = sis.getBilheteEletronico(cpf);
        if(id == null){
            System.out.println("Bilhete não encontrado");
            return;
        }
        System.out.println("======================================================");
        System.out.println("Deseja cancelar o bilhete? 1 - Sim 0 - Não");
        int opcao = scan.nextInt();
        if(opcao == 0){
            return;
        }
        sis.removerBilhete(id);
        System.out.println("Bilhete cancelado com sucesso!");
        System.out.println("======================================================");

    }

    public static int verificarCadastro() {
        int b = 0;
        while (b == 0) {
            if (scan.hasNextLine()) scan.nextLine(); // Consome quebra de linha extra
            System.out.println("======================================================");
            System.out.println("Digite seu nome: ");
            String nome = scan.nextLine();
            System.out.println("Digite seu CPF: ");
            String cpf = scan.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scan.nextLine();
    
            // Chamada corrigida com a ordem correta dos parâmetros
            b = sis.verificarPassageiro(senha, cpf, nome);
    
            System.out.println("======================================================");
            if (b == 1) {
                System.out.println("Passageiro encontrado!");
                System.out.println("======================================================");
                return b;
            } else {
                System.out.println("Passageiro não encontrado!");
                System.out.println("Digite 1 para tentar novamente ou 0 para voltar");
                String opcaoStr = scan.nextLine();
                int opcao = Integer.parseInt(opcaoStr);
                System.out.println("======================================================");
                if (opcao == 0) {
                    return b;
                }
            }
        }
        return b;
    }
    

    public static void main(String[] args) {
       // main.Teste1();
        alimentarSistema();
        
        int opcaoInicializacao, opcaoAdministrador, opcaoCliente, numOnibus;
        String ViagemId;

        while (true){
            menuInicializacao();   
            opcaoInicializacao = scan.nextInt();

            if(opcaoInicializacao == 0){
                break;
            }

            switch(opcaoInicializacao){
               
                case 1: 
                    /**
                     * MENU DO ADMINISTRADOR
                     */
                    while (true){
                        menuAdministrador();
                        opcaoAdministrador = scan.nextInt();

                        if(opcaoAdministrador == 0){
                            break;
                        }

                        switch(opcaoAdministrador){
                           
                            case 1: 
                                menuCadastrar();
                                break;
                        
                            case 2:
                                scan.nextLine();
                                System.out.println("======================================================");
                                System.out.println("Digite o número do ônibus: ");
                                numOnibus = scan.nextInt();
                                Motorista motorista = selecionarMotoristaOnibus();
                                if(motorista == null){
                                    System.out.println("Motorista não encontrado");
                                    break;
                                }
                                sis.setMotoristaOnibus(numOnibus, motorista);
                                System.out.println("Motorista definido com sucesso!");
                                System.out.println("======================================================");

                                break;

                            case 3:
                                scan.nextLine();
                                System.out.println("======================================================");
                                String viagemId = selecionarViagem();
                                System.out.println("Definir Paradas da Viagem: ");
                                ArrayList<ParadaDecorator> paradas = new ArrayList<ParadaDecorator>();
                                while(true){
                                    System.out.println("1 - Adicionar Parada");
                                    System.out.println("0 - Finalizar");
                                    int opcao = scan.nextInt();

                                    if(opcao == 0){
                                        break;
                                    }
                                    ParadaDecorator parada = selecionarParadaDecorator();
                                    paradas.add(parada);

                                }
                                sis.setParadasViagem(viagemId, paradas);
                                System.out.println("Paradas definidas com sucesso!");
                                System.out.println("======================================================");

                                break;

                            case 4:
                                scan.nextLine();
                                System.out.println("======================================================");
                                numOnibus = selecionarOnibus();
                                ViagemId = selecionarViagem();
                                sis.setOnibusViagem(ViagemId, numOnibus);
                                System.out.println("Viagem definida com sucesso!");
                                System.out.println("======================================================");
                                break;

                            case 5:
                                excluirAdm();
                                break;

                            case 6:
                                buscarAdm();
                                break;

                            case 7:
                                alterarAdm();
                                break;

                            case 8:
                                exibirAdm();
                                break;

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }
                    break;
                case 2:
                    /**
                     * MENU DO CLIENTE
                     */
                    while (true){
                        menuCliente();
                        opcaoCliente = scan.nextInt();

                        if(opcaoCliente == 0){
                            break;
                        }

                        switch(opcaoCliente){
                            case 1: 
                                scan.nextLine();
                                System.out.println("======================================================");
                                System.out.println("|1 - Possui Cadastro e deseja comprar passagem      |");
                                System.out.println("|2 - Não possui cadastro e deseja comprar passagem  |");
                                System.out.println("|0 - Voltar                                         |");
                                System.out.println("======================================================");
                                int opcao = scan.nextInt();
                                switch(opcao){
                                    case 1:
                                        if(verificarCadastro() == 1){
                                            comprarPassagem();
                                        }else{
                                            System.out.println("Passageiro não encontrado");
                                        }
                                        break;
                                    case 2:
                                        scan.nextLine();
                                        System.out.println("======================================================");
                                        System.out.println("Digite o nome do Passageiro: ");
                                        String nome = scan.nextLine();
                                        System.out.println("Digite a idade do Passageiro: ");
                                        int idade = scan.nextInt();
                                        scan.nextLine();
                                        System.out.println("Digite o CPF do Passageiro: ");
                                        String cpf = scan.nextLine();
                                        System.out.println("Digite a senha do Passageiro: ");
                                        String senha = scan.nextLine();
                                        System.out.println("Digite o endereço do Passageiro: ");
                                        String endereco = scan.nextLine();
                                        System.out.println("Digite o telefone do Passageiro: ");
                                        String telefone = scan.nextLine();
                                        TipoAssento tipoAssento = selecionarTipoAssento();
                                        sis.addPassageiro(nome, idade, cpf, senha, endereco, telefone, tipoAssento);
                                        System.out.println("Passageiro cadastrado com sucesso!");
                                        System.out.println("======================================================");
                                        System.out.println("Exibir Passageiro cadastrado: ");
                                        System.out.println(sis.getPassageiroCPF(cpf).toString());
                                        System.out.println("======================================================");
                                        comprarPassagem();
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                comprarPassagem();
                                break;
                    
                            case 2:
                                cancelarPassagem();
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                        
                    }
                    break;
            }
        }
    }
}
