import java.awt.Color;

public class JogoSenhaLogica {

	private static JogoSenhaLogica instance;
	private GeradorSenha senhaJogo = new GeradorSenha();

	public static JogoSenhaLogica getInstance() {
		if (instance == null)
			instance = new JogoSenhaLogica();

		return instance;
	}
	
	public void geraSenha() {
		senhaJogo.geraSenha();
	}
	
	public Color[] verificaSenha(Color[] cores) {
		Color[] dicas = new Color[4];
		
		int[] verificacao = {0, 0, 0, 0};
		
		if(senhaJogo.getSenha()[0].equals(cores[0]) && senhaJogo.getSenha()[1].equals(cores[1]) && senhaJogo.getSenha()[2].equals(cores[2]) && senhaJogo.getSenha()[3].equals(cores[3])) {
			System.out.println("\nGanhou! (=");
			
			dicas[0] = Color.black;
			dicas[1] = Color.black;
			dicas[2] = Color.black;
			dicas[3] = Color.black;			
		}
		else {
			int j = 0;
			
			for(int i = 0; i < 4; i++) {
				if(senhaJogo.getSenha()[i].equals(cores[i])) {
					dicas[j] = Color.black;
					verificacao[i] = -1;
					j++;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				if((senhaJogo.getSenha()[0].equals(cores[i])) && (i != 0) && verificacao[0] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				if((senhaJogo.getSenha()[1].equals(cores[i])) && (i != 1) && verificacao[1] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				if((senhaJogo.getSenha()[2].equals(cores[i])) && (i != 2) && verificacao[2] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				if((senhaJogo.getSenha()[3].equals(cores[i])) && (i != 3) && verificacao[3] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
		}
		
		return dicas;
	}
	
	public boolean tentativaCorreta(Color[] cores) {
		for(int i = 0; i < 4; i ++) {
			if(!(senhaJogo.getSenha()[i].equals(cores[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public Color[] debugCores() {
		return senhaJogo.getSenha();
	}
}