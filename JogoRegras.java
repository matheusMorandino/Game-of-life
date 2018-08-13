import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class JogoRegras
{
  public static boolean[][] mat = new boolean[40][65];

  public void carregaMat(File f)
  {
    try {
      Scanner sc = new Scanner(f);
      int i = 0;
      while(sc.hasNext() && i < this.mat.length)
      {
        String aux = sc.nextLine();
        for(int j = 0; j < aux.length() && j < this.mat[i].length; j++)
        {
          this.mat[i][j] = (aux.charAt(j) != ' ') ? true : false;
        }
        i++;
      }
      sc.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public boolean status(int i,int j)
  {
    int totalAtivas = dadosCelula(i, j);

    if(this.mat[i][j] == false)
    {
      if(totalAtivas == 3)
        return true;
      else
        return false;
    }
    else
    {
      if(totalAtivas < 2 || totalAtivas > 3)
        return false;
      else
        return true;
    }
  }

  public void atualizaCelulas()
  {
    boolean[][] aux = new boolean[this.mat.length][this.mat[0].length];

    for(int i = 0; i < this.mat.length; i++)
    {
      for(int j = 0; j < this.mat[i].length; j++)
      {
        aux[i][j] = this.status(i,j);
      }
    }
    this.mat = aux;
    aux = null;
  }

  public static int dadosCelula(int a, int b)
  {
    int aux = 0;
    for(int i = -1; i <= 1; i++)
    {
      for(int j = -1; j <= 1; j++)
      {
        if(a+i >= 0 && b+j >= 0 && a+i < mat.length && b+j < mat[0].length)
        {
          if(i != 0 || j != 0)
            aux += (mat[a+i][b+j] == true) ? 1 : 0;
        }
      }
    }
    return aux;
  }
}
