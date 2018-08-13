import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class ManipulaArquivos
{
  public File arq;

	public ManipulaArquivos(File arq) {
		super();
		this.arq = arq;
	}

  public void escreve(String str, boolean bool)
  {
    try {
      FileWriter writer = new FileWriter(arq, bool);
      writer.write(str);
      writer.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void limpa()
  {
    try {
      FileWriter writer = new FileWriter(arq, false);
      writer.write("");
      writer.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public String paraString()
  {
    String aux = "";
    try {
      Scanner sc = new Scanner(arq);
      while(sc.hasNext())
      {
        aux += sc.nextLine() + "\n";
      }
      sc.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return aux;
  }

  public void imprime()
  {
    try {
      Scanner sc = new Scanner(arq);
      while(sc.hasNext())
      {
        System.out.println(sc.nextLine());
      }
      sc.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
