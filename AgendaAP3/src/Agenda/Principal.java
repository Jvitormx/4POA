//Agenda de despesas de viagem | Joao Vitor Marques Xavier

package Agenda;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\nAgenda de despesas\n");
			System.out.println(
					"[1] Adicionar despesa a uma viagem | [2] Listar todas as despesas | [3] Buscar despesas por viagem | [0] Sair");
			System.out.print("Escolha uma opção: ");
			opcao = in.nextInt();
			in.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite a viagem: ");
				String viagemDespesa = in.nextLine();
				System.out.println("Digite a descricao da despesa: ");
				String descricao = in.nextLine();
				System.out.println("Digite o valor da despesa: R$");
				Double valor = in.nextDouble();
				in.nextLine();
				Agenda.adicionarDespesa(viagemDespesa, descricao, valor);
				break;

			case 2:
				Agenda.listarTodasDespesas();
				break;

			case 3:
				System.out.println("Digite a viagem para buscar suas despesas: ");
				String buscaViagem = in.nextLine();
				Agenda.listarDespesasPorViagem(buscaViagem);
				break;

			}

		} while (opcao != 0);
		in.close();
	}

}
