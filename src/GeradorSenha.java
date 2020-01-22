import java.awt.Color;
import java.util.Random;

public class GeradorSenha {
	private Color[] coresDisponiveis = { Color.red, Color.green, Color.blue, Color.cyan, Color.pink, Color.yellow };
	private Color[] resultado = new Color[4];
	private Random gerador = new Random();
	
	public void geraSenha() {
		resultado[0] = coresDisponiveis[gerador.nextInt(6)];
        resultado[1] = coresDisponiveis[gerador.nextInt(6)];
        resultado[2] = coresDisponiveis[gerador.nextInt(6)];
        resultado[3] = coresDisponiveis[gerador.nextInt(6)];
       // System.out.println(resultado[0].toString() + resultado[1].toString() + resultado[2].toString() + resultado[3].toString()); //Debug
	}
	
	public Color[] getSenha() {
		return resultado;
	}
}
