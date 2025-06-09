import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Formatter arqSaida; // para escrever no arquivo
    private static Scanner arqEnt;     // para ler do arquivo

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha, resgate;
        int idUsuario, senha2;
        boolean loginRealizado = false, programaAtivo = true;
        String nome = " ", email;
        double valor = 0;
        int cotas = 0, plantar;
        String brinde = " ";

        abreArqEscrita(); // sobrescreve no início, como você deseja

        while (programaAtivo) {
            System.out.println("\n--- Menu Inicial ---");
            System.out.println("1 - Cadastrar novo usuário ou investir");
            System.out.println("2 - Fazer login");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = sc.nextInt();

            if (escolha == 1) {
                adicionaRegistro();
            } else if (escolha == 2) {
                System.out.println("Digite seu id de usuario para realizar o login:");
                idUsuario = sc.nextInt();
                System.out.println("Digite sua senha para realizar o login:");
                senha2 = sc.nextInt();

                loginRealizado = false;
                try (Scanner leitor = new Scanner(new File("clientes.txt"))) {
                    while (leitor.hasNext()) {
                        String nomeArq = leitor.next();
                        String emailArq = leitor.next();
                        int idArq = leitor.nextInt();
                        int senhaArq = leitor.nextInt();
                        double valorArq = leitor.nextDouble();
                        int cotasArq = leitor.nextInt();
                        String brindeArq = leitor.next();
                        if (idUsuario == idArq && senha2 == senhaArq) {
                            loginRealizado = true;
                            nome = nomeArq;
                            valor = valorArq;
                            cotas = cotasArq;
                            brinde = brindeArq;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo de usuários não encontrado.");
                }

                if (loginRealizado) {
                    System.out.println("Login realizado com sucesso: " + nome + ", seja bem-vindo!");
                    System.out.println("Você investiu R$" + valor + " e possui " + cotas + " cotas.");
                    if(valor > 0) {
                        System.out.println("Você recebeu o brinde " + brinde + " de pelúcia para resgatar use as cotas.");
                        System.out.println("Cada cota é uma árvore plantada.");
                        System.out.println("Deseja plantar agora? 1 para sim, 2 para não:");
                        plantar = sc.nextInt();
                        if (plantar == 1) {
                            System.out.println("Sucesso, " + cotas + " árvores foram plantadas.");
                            System.out.println("Obrigado por nos ajudar a salvar o mundo.");
                            System.out.println("Deseja resgatar agora o seu brinde?(1 - sim, 2 - não)");
                            resgate = sc.nextInt();
                            while (resgate != 1 && resgate != 2) {
                                System.out.println("Erro, opção inválida");
                                resgate = sc.nextInt();
                            }
                            if (resgate == 1) {
                                System.out.println("Brinde Resgatado, Muito Obrigado!!!");
                            } else {
                                System.out.println("Fique a vontade para resgatar quando puder");
                            }
                        } else {
                            System.out.println("Fique à vontade para plantar quando desejar.");
                        }
                    }else {
                        System.out.println("Realize seu investimento");
                    }
                } else {
                    System.out.println("ID ou senha incorretos. Tente novamente.");
                }

            } else if (escolha == 0) {
                fechaArqEsc();
                abreArqLeitura();
                leRegistro();
                fechaArqLeit();
                programaAtivo = false;
                System.out.println("Obrigado.");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public static void abreArqEscrita() {
        try {
            arqSaida = new Formatter("clientes.txt");
        } catch (SecurityException | FileNotFoundException e) {
            System.err.println("Erro ao abrir o arquivo. Fechando...");
            System.exit(1);
        }
    }

    public static void abreArqLeitura() {
        try {
            arqEnt = new Scanner(new File("clientes.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro na abertura do arquivo");
            System.exit(1);
        }
    }

    public static void adicionaRegistro() {
        Scanner input = new Scanner(System.in);
        String nome, email, brindeGanho = "-";
        int id, senha, investimento, cadastro;
        double valor = 0;
        int cotas = 0;
        int indiceBrinde;
        String[] brindes = {"Onca-Pintada", "Macaco-Aranha", "Boto-Cor-de-Rosa", "Mico-Leao-Dourado", "Ararajuba", "Capivara", "Jacaré-Açu", "Lobo-Guará", "Sucuri", "Pirarucu"};

        System.out.println("Já realizou o cadastro? (1 - sim, 2 - não)");
        cadastro = input.nextInt();
        while (cadastro != 1 && cadastro != 2) {
            System.out.println("Erro, opção inválida.");
            cadastro = input.nextInt();
        }
        System.out.println("Insira os dados completos:");
        System.out.println("Digite o primeiro nome:");
        nome = input.next();
        System.out.println("Digite o e-mail:");
        email = input.next();
        System.out.println("Digite o ID de usuário:");
        id = input.nextInt();
        System.out.println("Digite a senha:");
        senha = input.nextInt();

        System.out.println("Deseja investir? (1 - sim, 2 - não)");
        investimento = input.nextInt();
        while (investimento != 1 && investimento != 2) {
            System.out.println("Erro, opção inválida.");
            investimento = input.nextInt();
        }

        if (investimento == 1) {
            System.out.println("Quanto deseja investir:");
            valor = input.nextDouble();
            cotas = (int) valor / 50;
            indiceBrinde = (int) (Math.random() * brindes.length);
            brindeGanho = brindes[indiceBrinde];
            System.out.println("Você receberá " + cotas + " cotas.");
            System.out.println("Parabéns! Você ganhou um brinde: " + brindeGanho);
        } else {
            System.out.println("Obrigado pelo cadastro, nos ajude quando puder.");
        }

        arqSaida.format("%-12s %-18s %04d %04d %10.2f %5d %-20s\n",
                nome, email, id, senha, valor, cotas, brindeGanho);
        arqSaida.flush();
    }

    public static void leRegistro() {
        String nome, email, brinde;
        int senha, id;
        double valor;
        int cotas;
        System.out.printf("%-12s %-18s %-6s %-6s %-10s %-6s %-20s\n",
                "Nome", "Email", "ID", "Senha", "Valor", "Cotas", "Brinde");
        try {
            while (arqEnt.hasNext()) {
                nome = arqEnt.next();
                email = arqEnt.next();
                id = arqEnt.nextInt();
                senha = arqEnt.nextInt();
                valor = arqEnt.nextDouble();
                cotas = arqEnt.nextInt();
                brinde = arqEnt.next();
                System.out.printf("%-12s %-18s %04d   %04d   R$%-8.2f %-6d %-20s\n",
                        nome, email, id, senha, valor, cotas, brinde);
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Erro na leitura do arquivo");
            arqEnt.close();
            System.exit(1);
        }
    }

    public static void fechaArqEsc() {
        if (arqSaida != null) arqSaida.close();
    }

    public static void fechaArqLeit() {
        if (arqEnt != null) arqEnt.close();
    }
}
