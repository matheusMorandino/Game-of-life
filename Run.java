import java.io.File;
import java.util.Scanner;
import java.io.IOException;

class Run
{
  static ManipulaArquivos man = new ManipulaArquivos(new File("jogo.txt"));
  static JogoRegras jogo = new JogoRegras();
  static CLS cls = new CLS();

  static void limpa()
  {
    try {
      cls.main();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  static void timer(int t)
  {
    try {
      Thread.sleep(t);
    }
    catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  static void imprimeAutomato()
  {
    for(int i = 0; i < jogo.mat.length; i++)
    {
      for(int j = 0; j < jogo.mat[i].length; j++)
      {
        System.out.print( ((jogo.mat[i][j] == true) ? "@" : " ") + " " );
      }
      System.out.println();
    }
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    jogo.carregaMat(man.arq);
    int num;

    System.out.print("Digite quantas geracoes deseja: ");
    num = sc.nextInt();

    for(int i = 0; i < num; i++)
    {
      limpa();
      imprimeAutomato();
      System.out.println("Geracao " + (i+1) +"/" + num);
      timer(200);
      jogo.atualizaCelulas();
    }

  }
}
