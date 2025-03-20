// 4POA/AP3 | Joao Vitor Marques Xavier - 23104708360056

package pjrLeituraEscrita;

import java.io.*;
import java.util.Scanner;

public class CalendarioMusical {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nCalendário de Músicas");
            System.out.println("1 - Adicionar uma nova música");
            System.out.println("2 - Consultar músicas");
            System.out.println("3 - Consultar músicas favoritas por mês");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcao){
                case 1: //adiciona musica
                	try{
                        FileWriter escrita = new FileWriter("/musicas.txt", true);
                        BufferedWriter bwEscrita = new BufferedWriter(escrita);

                        System.out.print("Digite a data (DD-MM-AAAA): ");
                        String data = scanner.nextLine();
                        
                        System.out.print("Digite o nome do artista: ");
                        String artista = scanner.nextLine();
                        
                        System.out.print("Digite o nome da música: ");
                        String musica = scanner.nextLine();
                        
                        System.out.print("Dê uma nota de 0 a 10: ");
                        int nota = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        String linha = data + " - " + artista + " - " + musica + " - Nota: " + nota;
                        bwEscrita.write(linha);
                        bwEscrita.newLine();

                        bwEscrita.close();
                        escrita.close();
                        System.out.println("Música adicionada");

                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2: //lista todas as musicas
                	 try{
                         FileReader leitura = new FileReader("/musicas.txt");
                         BufferedReader brLeitura = new BufferedReader(leitura);

                         System.out.println("\nMusicas registradas");

                         while(brLeitura.ready()){
                             String linha = brLeitura.readLine();
                             System.out.println(linha);
                         }

                         brLeitura.close();
                         leitura.close();

                         
                     }catch(FileNotFoundException e){
                         e.printStackTrace();
                         System.out.println("Nenhuma música registrada ainda.");
                     }catch(IOException e){
                         e.printStackTrace();
                     }
                    break;
                case 3: //lista as favoritas de um mes
                    System.out.print("Digite o mês que deseja consultar (formato MM): ");
                    String mesDigitado = scanner.nextLine();

                    try{
                        System.out.println("\n Músicas favoritas do mes " + mesDigitado + "");

                        FileReader leituraFav = new FileReader("/musicas.txt");
                        BufferedReader brLeituraFav = new BufferedReader(leituraFav);

                        while(brLeituraFav.ready()){
                            String linha = brLeituraFav.readLine();
                            String[] partes = linha.split(" - ");
                            String data = partes[0];
                            int nota = Integer.parseInt(partes[3].replace("Nota: ", "").trim());

                            //verifica se a data tem o formato esperado
                            if(data.length() >= 10){
                                String mes = data.substring(3, 5); //extrai o mes da data

                                if(mes.equals(mesDigitado) && nota >= 8){
                                    System.out.println(linha);
                                }
                            }
                        }

                        brLeituraFav.close();
                        leituraFav.close();

                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                        System.out.println("Nenhuma música registrada ainda.");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 4: //encerra 
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Invalido");
            }
        }while(opcao != 4);

        scanner.close();
    }
}
