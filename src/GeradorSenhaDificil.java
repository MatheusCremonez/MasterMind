import java.awt.Color;
import java.util.Random;

public class GeradorSenhaDificil {
	private Color[] coresDisponiveis = { Color.red, Color.green, Color.blue, Color.cyan, Color.pink, Color.yellow };
	private Color[] resultado = new Color[6];
	private Random gerador = new Random();
	
	public void geraSenhaDificil() {
		resultado[0] = coresDisponiveis[gerador.nextInt(6)];
        resultado[1] = coresDisponiveis[gerador.nextInt(6)];
        resultado[2] = coresDisponiveis[gerador.nextInt(6)];
        resultado[3] = coresDisponiveis[gerador.nextInt(6)];
        resultado[4] = coresDisponiveis[gerador.nextInt(6)];
        resultado[5] = coresDisponiveis[gerador.nextInt(6)];
      //System.out.println(resultado[0].toString() + resultado[1].toString() + resultado[2].toString() + resultado[3].toString() + resultado[4].toString() + resultado[5].toString()); //Debug
	}
	
	public Color[] getSenhaDificil() {
		return resultado;
	}
}
