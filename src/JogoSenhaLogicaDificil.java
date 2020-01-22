import java.awt.Color;

public class JogoSenhaLogicaDificil {

	private static JogoSenhaLogicaDificil instance;
	private GeradorSenhaDificil senhaJogoDificil = new GeradorSenhaDificil();
	
	public static JogoSenhaLogicaDificil getInstance() {
		if (instance == null)
			instance = new JogoSenhaLogicaDificil();

		return instance;
	}
	
	public void geraSenhaDificil() {
		senhaJogoDificil.geraSenhaDificil();
	}
	
	public Color[] verificaSenha(Color[] cores) {
		Color[] dicas = new Color[6];
		
		int[] verificacao = {0, 0, 0, 0, 0, 0};
		
		if(senhaJogoDificil.getSenhaDificil()[0].equals(cores[0]) && senhaJogoDificil.getSenhaDificil()[1].equals(cores[1]) && senhaJogoDificil.getSenhaDificil()[2].equals(cores[2]) && senhaJogoDificil.getSenhaDificil()[3].equals(cores[3]) && senhaJogoDificil.getSenhaDificil()[4].equals(cores[4]) && senhaJogoDificil.getSenhaDificil()[5].equals(cores[5])) {
			System.out.println("\nGanhou! (=");
			
			dicas[0] = Color.black;
			dicas[1] = Color.black;
			dicas[2] = Color.black;
			dicas[3] = Color.black;	
			dicas[4] = Color.black;
			dicas[5] = Color.black;
		}
		else {
			int j = 0;
			
			for(int i = 0; i < 6; i++) {
				if(senhaJogoDificil.getSenhaDificil()[i].equals(cores[i])) {
					dicas[j] = Color.black;
					verificacao[i] = -1;
					j++;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[0].equals(cores[i])) && (i != 0) && verificacao[0] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[1].equals(cores[i])) && (i != 1) && verificacao[1] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[2].equals(cores[i])) && (i != 2) && verificacao[2] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[3].equals(cores[i])) && (i != 3) && verificacao[3] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[4].equals(cores[i])) && (i != 4) && verificacao[4] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if((senhaJogoDificil.getSenhaDificil()[5].equals(cores[i])) && (i != 5) && verificacao[5] != -1) {
					dicas[j] = Color.gray;
					j++;
					break;
				}
			}
		}
		
		return dicas;
	}
	
	public boolean tentativaCorreta(Color[] cores) {
		for(int i = 0; i < 6; i ++) {
			if(!(senhaJogoDificil.getSenhaDificil()[i].equals(cores[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public Color[] debugCores() {
		return senhaJogoDificil.getSenhaDificil();
	}
}