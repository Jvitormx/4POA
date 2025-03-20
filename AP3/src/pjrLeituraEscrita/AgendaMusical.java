// 4POA/AP3 | Joao Vitor Marques Xavier - 23104708360056

package pjrLeituraEscrita;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgendaMusical {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nAgenda de Músicas");
            System.out.println("1 - Adicionar uma nova musica");
            System.out.println("2 - Consultar todas as musicas");
            System.out.println("3 - Consultar músicas por mes");
            System.out.println("4 - Consultar músicas por status");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1: //adiciona musica na agenda referente a data atual
                	try{

                        FileWriter escrita = new FileWriter("/home/jvtrx/4poa/musicas.txt", true);
                        BufferedWriter bwEscrita = new BufferedWriter(escrita);

                        LocalDate dataAtual = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        String data = dataAtual.format(formatter);

                        System.out.print("Digite o nome do artista: ");
                        String artista = scanner.nextLine();

                        System.out.print("Digite o nome da musica: ");
                        String musica = scanner.nextLine();

                        System.out.print("Nota de 0 a 10: ");
                        int nota = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Status (Ouvi, Ouvi pela metade, etc.): ");
                        String status = scanner.nextLine();

                        String linha = data + " - " + artista + " - " + musica + " - Nota: " + nota + " - " + status;
                        bwEscrita.write(linha);
                        bwEscrita.newLine();

                        bwEscrita.close();
                        escrita.close();
                        System.out.println("Musica adicionada");

                    }catch(IOException e){
                        System.out.println("Erro");
                        e.printStackTrace();
                    }
                    break;
                case 2: //lista musicas
                	try{
                        FileReader leitura = new FileReader("/home/jvtrx/4poa/musicas.txt");
                        BufferedReader brLeitura = new BufferedReader(leitura);

                        System.out.println("\nTodas as músicas registradas:");

                        while(brLeitura.ready()){
                            System.out.println(brLeitura.readLine());
                       }

                        brLeitura.close();
                        leitura.close();
                    }catch(FileNotFoundException e){
                        System.out.println("Nenhuma música registrada ainda.");
                    }catch(IOException e){
                        System.out.println("Erro ao ler o arquivo.");
                        e.printStackTrace();
                    }
                    break;
                case 3: //lista musica por mes
                	System.out.print("Digite o mes que deseja consultar (MM): ");
                    String mesDigitado = scanner.nextLine();

                    try{
                        FileReader leitura = new FileReader("/home/jvtrx/4poa/musicas.txt");
                        BufferedReader brLeitura = new BufferedReader(leitura);

                        System.out.println("\nMúsicas do mês " + mesDigitado + ":");

                        while(brLeitura.ready()){
                            String linha = brLeitura.readLine();
                            String[] partes = linha.split(" - ");
                            String data = partes[0];

                            if(data.length() >= 10 && data.substring(3, 5).equals(mesDigitado)) {
                                System.out.println(linha);
                            }
                        }

                        brLeitura.close();
                        leitura.close();
                    }catch(FileNotFoundException e){
                        System.out.println("Nenhuma música registrada ainda.");
                    }catch(IOException e) {
                        System.out.println("Erro ao ler o arquivo.");
                        e.printStackTrace();
                    }
                    break;
                case 4: //lista musica por status
                	System.out.print("Digite o status que deseja consultar (Ouvi, Pela metade, Outra vez, etc.): ");
                    String statusDigitado = scanner.nextLine();

                    try{
                        FileReader leitura = new FileReader("/home/jvtrx/4poa/musicas.txt");
                        BufferedReader brLeitura = new BufferedReader(leitura);

                        System.out.println("\nMusicas com status '" + statusDigitado + "':");

                        while(brLeitura.ready()){
                            String linha = brLeitura.readLine();
                            if(linha.endsWith(statusDigitado)){
                                System.out.println(linha);
                            }
                        }

                        brLeitura.close();
                        leitura.close();
                    }catch(FileNotFoundException e){
                        System.out.println("Nenhuma musica registrada");
                    }catch (IOException e){
                        System.out.println("Erro");
                        e.printStackTrace();
                    }
                    break;
                case 5: //encerra
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Invalido");
            }
        }while(opcao != 5);

        scanner.close();
    }

}
