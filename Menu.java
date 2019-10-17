import java.util.Scanner;

public class Menu {
	static Scanner input = new Scanner(System.in);
	static String[][] usuario = new String[256][2];
	// 256 linhas 1º coluna com nome e 2º com senha
	
	static int[] count = new int[256]; // quantidade de usarios
	
	static int i = 0; // iteração para numero de usuario
	static int opcao = 0;
	
	static int[][] amigos = new int[256][256];	
	static int a, a1;
	
	static String[][] comunidade = new String[256][30];
	static int c = 0; //comunidade
	
	static int[][] membros = new int[256][256];	
	static int m, m1;
	
	
	static String[][] mensagem = new String[256][2];

	static String[][] destinatario = new String[256][2];
	static int d = 0;
	static int qnt_contas = 0;
 	
	public static void main(String[] args) 
	{

		menuPrincipal();
		int principal = input.nextInt();
		input.nextLine();

		while (true) 
		{
			if (principal == 1) 
			{
				if(login())
				{
					menuSecundario();
					menuOpcoes();
				}		

				
				return;
			} 
			else if (principal == 2) 
			{
				criarConta();

			} 
			else if (principal == 3) 
			{
				return;
			} 
			else if( principal == 4) 
			{
				printando();
			}
			else 
			{
				System.out.println("Opção não encontrada !");
			}
			menuPrincipal();
			principal = input.nextInt();
			input.nextLine();
		}

	}

	public static void menuPrincipal() 
	{
		System.out.println("\tSeja bem vindo ao IFACE");
		System.out.println("\tVocê ja tem uma conta? ");
		System.out.println("\tDigite (1) para fazer login");
		System.out.println("\tDigite (2) para criar uma nova conta");
		System.out.println("\tDigite (3) para sair do programa");
		System.out.println("\tDigite (4) para printar usuarios");
	}

	public static void menuSecundario() 
	{
		System.out.println("Escolha uma das opções abaixo: ");
		System.out.println("(1) Edição de perfil ");
		System.out.println("(2) Adição de Amigos");
		System.out.println("(3) Envio de Mensagens");
		System.out.println("(4) Criação de Comunidades");
		System.out.println("(5) Adição de membros");
		System.out.println("(6) Recuperar Informações sobre um determinado Usuário");
		System.out.println("(7) Remoção de Conta");
		System.out.println("(8) Sair da conta");
	}

	public static void menuOpcoes()
	{
		opcao = input.nextInt();
		input.nextLine();
		
		while(true)
		{
			if(opcao == 1) 
			{
				edicaoPerfil();
			}
			else if(opcao == 2) 
			{
				adicaoAmigos();
			}
			else if(opcao == 3) 
			{
				envioMensagem();
			}
			else if(opcao == 4) 
			{
				criacaoComunidade();
			}
			else if(opcao == 5) 
			{
				adicaoMembros();
			}
			else if(opcao == 6) 
			{
				recuperarDados();
			}
			else if(opcao == 7) 
			{
				removerConta();
			}
			else if(opcao == 8)
			{
				main(null);
				return;
			}
			else 
			{
				System.out.println("Opção invalida");
			}
			menuSecundario();
			opcao = input.nextInt();
			input.nextLine();
		}
			
	}

	public static boolean login() 
	{
		String login, senha;

		System.out.println("Insira seu nome de usuario");
		login = input.nextLine();

	
		System.out.println("Insira a sua senha");
		senha = input.nextLine();

		if (login == null) 
		{
			System.out.println("Usuario não pode ser nulo, digite seus dados novamente");
			limpar();
			login();
		}
		if (senha == null) 
		{
			System.out.println("senha não pode ser nulo, digite seus dados novamente");
			limpar();
			login();
		}
		int flag = 0;
		for(int i2 = 0; i2 < 256; i2++)
		{
			if(usuario[i2][0] != null)
			{
				if(usuario[i2][0].equals(login))
				{
					if(usuario[i2][1].equals(senha))
					{
						System.out.println("Bem vindo a sua conta " + usuario[i2][0]);
						i = i2;
						flag = 1;					
						return true;
		
					}
				}
			}
		}
		if(flag == 0)
		{
			System.out.println("Usuário ou senha invalidos, tente novamente");
			main(null);
			
		}
		return false;
	}

	public static void criarConta() 
	{
		System.out.println("Insira seu nome de usuario");
		usuario[i][0] = input.nextLine();
		System.out.println("Insira a sua senha");
		usuario[i][1] = input.nextLine();

		for (int k = 0; k < i; k++) 
		{
			if (usuario[k][0].equals(usuario[i][0])) 
			{
				System.out.println("Esse nome de usuario já existe, tente novamente");
				criarConta();
			}
		}

		if (usuario[i][0] != null && usuario[i][1] != null) 
		{
			System.out.println("Sua conta foi criada!");
		}
		i++;
		qnt_contas++;
	}
	
	public static void printando()
	{
		for(int k = 0; k < i; k++)
		{
			System.out.println("NOME "+k+" : "+usuario[k][0]);
		}
	}

	public static void limpar() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void edicaoPerfil() {
		limpar();
		System.out.println("Bem vindo a edição do perfil");
		System.out.println("Selecione oq você deseja editar");
		System.out.println("(1) Mudar o nome de usuario");
		System.out.println("(2) Mudar a senha");
		int edicao = input.nextInt();
		input.nextLine();
		
		if(edicao == 1) 
		{
			System.out.println("Digite o seu novo nome de usuario");
			String novoNome;
			novoNome = input.nextLine();
			// input.nextLine();
			
			// System.out.println(usuario[i][0]);
		
			boolean flag = true;

			for (int k = 0; k < 256; k++) 
			{
				if (usuario[k][0] != null && usuario[k][0].equals(novoNome)) 
				{
					System.out.println("Esse nome de usuario já existe, tente novamente");
					flag = false;
					edicaoPerfil();
				}
			}
			if(flag)
			{
				usuario[i][0] = novoNome;
				i++;
				System.out.println("Seus dados foram alterados com sucesso !");
			}
		}
		else if(edicao == 2) 
		{
			System.out.println("Digite sua nova senha");
			usuario[i][1] = input.nextLine();
			System.out.println("Sua senha foi alterada com sucesso !");
		}
		else 
		{
			System.out.println("Opção invalida");
		}
	}
	
	public static void adicaoAmigos() 
	{
		System.out.println("\tBem vindo a Adição de amigos");
		System.out.println("Digite os amigos que você deseja adicionar ");
		String user = input.nextLine();
		
		int k = 0;
		boolean encontrou = false;

		for (int i = 0; i < 256; i++) 
		{
			String usuarioDaVez = usuario[i][0];
			
			if(usuarioDaVez != null) 
			{
				if(usuarioDaVez.equals(user)) 
				{
					encontrou = true;
					k = i;
					break; 
				}
			}
		}
		
		if(!encontrou) 
		{
			System.out.println("Esse nome de usuario não existe, tente novamente");
			adicaoAmigos();
		}
				
		/* 0 - nao tem nada
		 * 1 - pendente
		 * 2 - envia/aceito
		 */
		if(amigos[k][i] == 0)
		{
			//nao foi enviado convite de amizade
			amigos[i][k] = 2;
			amigos[k][i] = 1;
			System.out.println("Convite enviado");
		}
		if(amigos[k][i] == 2)
		{
			//quando me enviou um convite
			amigos[i][k] = 2;
			amigos[k][i] = 2;
			System.out.println("Você ja tem um convite pendente");
			System.out.println("O usuario ja enviou um pedido");
				System.out.println("(0) Para rejeitar o pedido");
				System.out.println("(1) Para deixar o pedido pendente");
				System.out.println("(2) Para aceitar o pedido de amizade");
				int pedido = input.nextInt();

				if(pedido == 0)
				{
					amigos[i][k] = 0;
					System.out.println("Pedido rejeitado !");
				}
				else if(pedido == 1)
				{
					amigos[i][k] = 1;
					System.out.println("Pedido pendente");
				}
				else if(pedido == 2)
				{
					amigos[i][k] = 2;
					System.out.println("Pedido aceito");
				}
		}

	}
	
	public static void envioMensagem()
	{
		System.out.println("Bem vindo a parte do envio de mensagens");
		System.out.println("Para quem deseja enviar essa mensagem?");
		
		String user = input.nextLine();
		
		int k = 0;
		boolean encontrou = false;

		for (int i = 0; i < 256; i++) 
		{
			String usuarioDaVez = usuario[i][0];
			
			if(usuarioDaVez != null) 
			{
				if(usuarioDaVez.equals(user)) 
				{
					encontrou = true;
					k = i;
					break; 
				}
			}
		}
		
		if(!encontrou) 
		{
			System.out.println("Esse nome de usuario não existe, tente novamente");
			envioMensagem();
		}
		
		destinatario[d][0] = user;
		System.out.println(destinatario[d][0]);

		System.out.println("Insira a mensagem que deseja enviar");
		destinatario[d][1] = input.nextLine();
//		
		System.out.println("Mensagem enviada para "+destinatario[d][0]);
		d++;
		
	}
	
	public static void criacaoComunidade() 
	{
		limpar();
		System.out.println("Bem vindo a criação de comunidades");
		System.out.println("Forneça um nome: ");
		comunidade[c][0] = input.nextLine();
		System.out.println("Descrição da comunidade: ");
		comunidade[c][1] = input.nextLine();
		
		
		System.out.println("Comunidade criada com sucesso ");
	}
	
	public static void adicaoMembros() 
	{

		System.out.println("\tBem vindo a Adição de membros");
		System.out.println("Digite os membros que você deseja adicionar ");
		String user = input.nextLine();
		
		int k = 0;
		boolean encontrou = false;

		for (int i = 0; i < 256; i++) 
		{
			String usuarioDaVez = usuario[i][0];
			
			if(usuarioDaVez != null) 
			{
				if(usuarioDaVez.equals(user)) 
				{
					encontrou = true;
					k = i;
					break; 
				}
			}
		}
		
		if(!encontrou) 
		{
			System.out.println("Esse nome de usuario não existe, tente novamente");
			adicaoMembros();
		}
				
		/* 0 - nao tem nada
		 * 1 - pendente
		 * 2 - envia/aceito
		 */
		if(membros[k][i] == 0)
		{
			//nao foi enviado convite de amizade
			membros[i][k] = 2;
			membros[k][i] = 1;
			System.out.println("Convite enviado");
		}
		if(membros[k][i] == 2)
		{
			//quando me enviou um convite
				membros[i][k] = 2;
				membros[k][i] = 2;
				System.out.println("Você ja tem um convite pendente");
				System.out.println("O usuario ja enviou um pedido");
				System.out.println("(0) Para rejeitar o pedido");
				System.out.println("(1) Para deixar o pedido pendente");
				System.out.println("(2) Para aceitar o pedido de amizade");
				int pedido = input.nextInt();

				if(pedido == 0)
				{
					membros[i][k] = 0;
					System.out.println("Pedido rejeitado !");
				}
				else if(pedido == 1)
				{
					membros[i][k] = 1;
					System.out.println("Pedido pendente");
				}
				else if(pedido == 2)
				{
					membros[i][k] = 2;
					System.out.println("Pedido aceito");
				}
		}
	}
	
	public static void recuperarDados()
	{
		System.out.println("Recuperando suas informações");

		System.out.println("Nome de usuario: "+usuario[i][0]);
		System.out.println("Senha: "+usuario[i][1]);
		
		System.out.println("Amigos: ");
		if(amigos[i][i] == 0)
		{
			System.out.println("\tVocê nao tem amigos");
		}
		else 
		{
			for(int j = 0; j < 256;j++)
			{
				if(amigos[i][j] == 2)
				{
					if(amigos[j][i] == 2)
					{
						System.out.println("\t"+usuario[j][0]);
					}
				}
			}
		}
		
		System.out.println("Comunidade: ");
		if(comunidade[i][0] == null)
		{
			System.out.println("\tVocê nao tem comunidades");
		}
		else
		{
			for(int j = 0; j < 256;j++)
			{
				if(comunidade[j][0] != null)
				{
					System.out.println("\tNome : "+comunidade[j][0]);
					System.out.println("\tDescricao: "+comunidade[j][1]);					
				}
			}
		}
		
		System.out.println("Mensagem: ");
		if(destinatario[i][0] == null)
		{
			System.out.println("Você nao tem mensagens");
		}
		else
		{
			for(int j = 0; j < 256;j++)
			{
				if(destinatario[j][0] != null)
				{
					System.out.println("Nome : "+destinatario[j][0]);
					System.out.println("Descricao: "+destinatario[j][1]);
					
				}
			}
		}
		
	
	}
	
	public static void removerConta() 
	{
		int rm;
		System.out.println("\tRemoção de conta");
		System.out.println("Deseja remover sua conta?");
		System.out.println("(1) Sim\n(2) Não");
		rm = input.nextInt();
		input.nextLine();
		
		if(rm == 1)
		{
			for (int k = 0; k < i; k++) 
			{
					if (usuario[k][0].equals(usuario[i][0])) 
					{
						usuario[k][k] = null;
						amigos[k][k] = 0;
						comunidade[k][k] = null;
						destinatario[k][k] = null;
						mensagem[k][k] = null;
					}
			}	
			System.out.println("Usuario removido com sucesso!");

		}
		else if(rm == 2)
		{
			return;
		}
		else {
			System.out.println("Opção nao encontrada");
		}
		
		
	}
	
}