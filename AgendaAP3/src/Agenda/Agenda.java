//Agenda de despesas de viagem | Joao Vitor Marques Xavier

package Agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Agenda {
	public static void adicionarDespesa(String viagem, String descricao, Double valor) {
		try {
			FileWriter fw = new FileWriter("despesas.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(viagem+";"+descricao+";"+valor);
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarTodasDespesas() {
		try {
			FileReader fr = new FileReader("despesas.txt");
			BufferedReader br = new BufferedReader(fr);
			int quant = 0;
			while(br.ready()) {
				String aux = br.readLine();
				quant += 1;
				String [] dados = aux.split(";");
				System.out.println("Viagem: "+ dados[0] + " | Descricao: " + dados[1] + " | Valor: R$" + dados[2]);
			}
			System.out.println("Foram encontradas " + quant + " despesas no total.");
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarDespesasPorViagem(String viagem) {
		try {
			FileReader fr = new FileReader("despesas.txt");
			BufferedReader br = new BufferedReader(fr);
			int quant = 0;
			while(br.ready()) {
				String aux = br.readLine();
				if(aux.contains(viagem)) {
					quant +=1; 
					String [] dados = aux.split(";");
					System.out.println("Descricao: "+ dados[1] + " | Valor: R$" + dados[2]);
				}
			}
			if(quant == 0) {
				System.out.println("Nenhuma despesa encontrada. Esta viagem nao existe.");
			}
			System.out.println("\nForam encontradas " + quant + " despesas para " + viagem + ".");
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
