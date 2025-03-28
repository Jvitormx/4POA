package pjrSerializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Filme f = new Filme("Tá_Chovendo_Hambúrguer", 2009, 7.9 , "Um cientista local é com frequência considerado um fracasso até inventar uma máquina que pode fazer os alimentos caírem do céu. Mas ele pouco sabe que as coisas estão prestes a piorar.");
		try {
			File file = new File("c:/a/");
			if(!file.exists()) file.mkdir();
			FileOutputStream arqOSer = new FileOutputStream("c:/a/Tá_Chovendo_Hambúrguer.ser");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(f);
			oOSer.close();
			System.out.println("---------------Antes de alterar avaliacao-------------");
			System.out.println(f);
			f.setAvaliacao(8.9);
			System.out.println("---------------Depois de alterar avaliacao-------------");
			System.out.println(f);
			FileInputStream arqISer = new FileInputStream("c:/a/Tá_Chovendo_Hambúrguer.ser");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			f = (Filme) iOSer.readObject();
			iOSer.close();
			System.out.println("---------------Depois de recuperar os valores-------------");
			System.out.println(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


