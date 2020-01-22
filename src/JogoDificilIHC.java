import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class JogoDificilIHC extends JFrame {
	
	//Corpo do Jogo - Uma matriz representando as 12 linhas das tentativas com 13 blocos por linha (1 é o separador das dicas)
	private JButton[][] tentativas = new JButton[12][13];
	private JButton[] resposta = new JButton[6];
	
	//Botoes das cores
	private JButton bcor1, bcor2, bcor3, bcor4, bcor5, bcor6;
	
	//Botoes de Tentativas
	private JButton tentar, limpar;
	
	private JogoHandler jogoHandler = new JogoHandler();
	
	private Dimension tamanhoCores = new Dimension(35, 35);
	private Dimension tamanhoDicas = new Dimension(16, 16);
	
	//Tentativas das cores
	
	private Color[] linhaDaTentativa = {Color.white, Color.white, Color.white, Color.white, Color.white, Color.white};
	Color[] dicas = new Color[6];
	private int cores = 0, ntentativa = 0;
	
	public JogoDificilIHC() {
		
		super("MasterMind");
		setLayout(null);		
		
		//Senha Resultado
		
		resposta = senhaResultado();
		
		//Corpo do Jogo
		
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 2, tentativas[0]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 3, tentativas[1]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 4, tentativas[2]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 5, tentativas[3]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 6, tentativas[4]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 7, tentativas[5]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 8, tentativas[6]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 9, tentativas[7]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 10, tentativas[8]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 11, tentativas[9]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 12, tentativas[10]);
		printCores(linhaDaTentativa[0], linhaDaTentativa[1], linhaDaTentativa[2], linhaDaTentativa[3], linhaDaTentativa[4], linhaDaTentativa[5], 13, tentativas[11]);
		//Botoes das cores
		
		bcor1 = new JButton();
		bcor1.setBounds(60, 610, tamanhoCores.width, tamanhoCores.height);
		bcor1.setBackground(Color.red);
		add(bcor1);
		
		bcor2 = new JButton();
		bcor2.setBounds(100, 610, tamanhoCores.width, tamanhoCores.height);
		bcor2.setBackground(Color.green);
		add(bcor2);
		
		bcor3 = new JButton();
		bcor3.setBounds(140, 610, tamanhoCores.width, tamanhoCores.height);
		bcor3.setBackground(Color.blue);
		add(bcor3);
		
		bcor4 = new JButton();
		bcor4.setBounds(180, 610, tamanhoCores.width, tamanhoCores.height);
		bcor4.setBackground(Color.cyan);
		add(bcor4);
		
		bcor5 = new JButton();
		bcor5.setBounds(220, 610, tamanhoCores.width, tamanhoCores.height);
		bcor5.setBackground(Color.pink);
		add(bcor5);
		
		bcor6 = new JButton();
		bcor6.setBounds(260, 610, tamanhoCores.width, tamanhoCores.height);
		bcor6.setBackground(Color.yellow);
		add(bcor6);
		
		//Botoes de Tentativas
		
		tentar = new JButton("Tentar!");
		tentar.setBounds(87, 660, 85, 40);
		add(tentar);
		
		limpar = new JButton("Limpar");
		limpar.setBounds(187, 660, 85, 40);
		add(limpar);
		
		//Handlers
		
		bcor1.addActionListener(jogoHandler);
		bcor2.addActionListener(jogoHandler);
		bcor3.addActionListener(jogoHandler);
		bcor4.addActionListener(jogoHandler);
		bcor5.addActionListener(jogoHandler);
		bcor6.addActionListener(jogoHandler);
		tentar.addActionListener(jogoHandler);
		limpar.addActionListener(jogoHandler);
		
	}
	
	private class JogoHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == bcor1) {
				if(cores < 6){
				//	System.out.println("Bcor1 funcionando. " + bcor1.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.red);
					linhaDaTentativa[cores] = Color.red;
					cores++;
				}
			}
			else if(event.getSource() == bcor2) {
				if(cores < 6){
				//	System.out.println("Bcor2 funcionando. " + bcor2.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.green);
					linhaDaTentativa[cores] = Color.green;
					cores++;
				}
			}
			else if(event.getSource() == bcor3) {
				if(cores < 6){
				//	System.out.println("Bcor3 funcionando. " + bcor3.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.blue);
					linhaDaTentativa[cores] = Color.blue;
					cores++;
				}
			}
			else if(event.getSource() == bcor4) {
				if(cores < 6){
				//	System.out.println("Bcor4 funcionando. " + bcor4.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.cyan);
					linhaDaTentativa[cores] = Color.cyan;
					cores++;
				}
			}
			else if(event.getSource() == bcor5) {
				if(cores < 6){
				//	System.out.println("Bcor5 funcionando. " + bcor5.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.pink);
					linhaDaTentativa[cores] = Color.pink;
					cores++;
				}
			}
			else if(event.getSource() == bcor6) {
				if(cores < 6){
				//	System.out.println("Bcor6 funcionando. " + bcor6.getBackground().toString()); //Debug
					tentativas[ntentativa][cores].setBackground(Color.yellow);
					linhaDaTentativa[cores] = Color.yellow;
					cores++;
				}
			}
			else if(event.getSource() == tentar) {
				
				if(cores >= 6) {
				//	System.out.println("Chamado a Tentativa, indo para linha debaixo"); //Debug
					dicas = JogoSenhaLogicaDificil.getInstance().verificaSenha(linhaDaTentativa);
					tentativas[ntentativa][7].setBackground(dicas[0]);
					tentativas[ntentativa][8].setBackground(dicas[1]);
					tentativas[ntentativa][9].setBackground(dicas[2]);
					tentativas[ntentativa][10].setBackground(dicas[3]);
					tentativas[ntentativa][11].setBackground(dicas[4]);
					tentativas[ntentativa][12].setBackground(dicas[5]);
					cores = 0;
					
					if(JogoSenhaLogicaDificil.getInstance().tentativaCorreta(linhaDaTentativa) == true) {
						resposta[0].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[0]);
						resposta[1].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[1]);
						resposta[2].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[2]);
						resposta[3].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[3]);	
						resposta[4].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[4]);	
						resposta[5].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[5]);	
						
						JOptionPane.showMessageDialog(null, "Você ganhou! Parabéns!", "Você ganhou!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else if ((ntentativa + 1) == 12){
						resposta[0].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[0]);
						resposta[1].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[1]);
						resposta[2].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[2]);
						resposta[3].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[3]);	
						resposta[4].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[4]);	
						resposta[5].setBackground(JogoSenhaLogicaDificil.getInstance().debugCores()[5]);	
						
						JOptionPane.showMessageDialog(null, "Você perdeu! Que Pena!", "Você Perdeu!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						
					}
					
					ntentativa++;
				}
				
			}
			else if(event.getSource() == limpar) {
			
				tentativas[ntentativa][0].setBackground(Color.white);
				tentativas[ntentativa][1].setBackground(Color.white);
				tentativas[ntentativa][2].setBackground(Color.white);
				tentativas[ntentativa][3].setBackground(Color.white);
				tentativas[ntentativa][4].setBackground(Color.white);
				tentativas[ntentativa][5].setBackground(Color.white);
				cores = 0;
				
			}
			
		}
	}
	
	//Corpo do Jogo
	
	private JButton[] senhaResultado(){
		JButton[] senha = new JButton[6];
		
		senha[0] = new JButton();
		senha[0].setBounds(25, 10, tamanhoCores.width, tamanhoCores.height);
		senha[0].setBackground(Color.white);
		senha[0].setEnabled(false);
		add(senha[0]);
		
		senha[1] = new JButton();
		senha[1].setBounds(65, 10, tamanhoCores.width, tamanhoCores.height);
		senha[1].setBackground(Color.white);
		senha[1].setEnabled(false);
		add(senha[1]);
		
		senha[2] = new JButton();
		senha[2].setBounds(105, 10, tamanhoCores.width, tamanhoCores.height);
		senha[2].setBackground(Color.white);
		senha[2].setEnabled(false);
		add(senha[2]);
		
		senha[3] = new JButton();
		senha[3].setBounds(145, 10, tamanhoCores.width, tamanhoCores.height);
		senha[3].setBackground(Color.white);
		senha[3].setEnabled(false);
		add(senha[3]);
		
		senha[4] = new JButton();
		senha[4].setBounds(185, 10, tamanhoCores.width, tamanhoCores.height);
		senha[4].setBackground(Color.white);
		senha[4].setEnabled(false);
		add(senha[4]);
		
		senha[5] = new JButton();
		senha[5].setBounds(225, 10, tamanhoCores.width, tamanhoCores.height);
		senha[5].setBackground(Color.white);
		senha[5].setEnabled(false);
		add(senha[5]);

		return senha;
	}
	
	private void printCores(Color Cor1, Color Cor2, Color Cor3, Color Cor4, Color Cor5, Color Cor6, int pos, JButton tentativas[]) {
		
		//As 6 cores
		
		tentativas[0] = new JButton();
		tentativas[0].setBounds(25, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[0].setBackground(Cor1);
		tentativas[0].setEnabled(false);
		add(tentativas[0]);
		
		tentativas[1] = new JButton();
		tentativas[1].setBounds(65, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[1].setBackground(Cor2);
		tentativas[1].setEnabled(false);
		add(tentativas[1]);
		
		tentativas[2] = new JButton();
		tentativas[2].setBounds(105, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[2].setBackground(Cor3);
		tentativas[2].setEnabled(false);
		add(tentativas[2]);
		
		tentativas[3] = new JButton();
		tentativas[3].setBounds(145, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[3].setBackground(Cor4);
		tentativas[3].setEnabled(false);
		add(tentativas[3]);
		
		tentativas[4] = new JButton();
		tentativas[4].setBounds(185, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[4].setBackground(Cor4);
		tentativas[4].setEnabled(false);
		add(tentativas[4]);
		
		tentativas[5] = new JButton();
		tentativas[5].setBounds(225, (pos * 43), tamanhoCores.width, tamanhoCores.height);
		tentativas[5].setBackground(Cor4);
		tentativas[5].setEnabled(false);
		add(tentativas[5]);
		
		//Separador
		
		tentativas[6] = new JButton();
		tentativas[6].setBounds(270, (pos * 43), 3, 35);
		tentativas[6].setBackground(Color.black);
		tentativas[6].setEnabled(false);
		add(tentativas[6]);
		
		//As 6 dicas
		
		tentativas[7] = new JButton();
		tentativas[7].setBounds(290, (pos * 43), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[7].setBackground(Color.white);
		tentativas[7].setEnabled(false);
		add(tentativas[7]);
		
		tentativas[8] = new JButton();
		tentativas[8].setBounds(310, (pos * 43), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[8].setBackground(Color.white);
		tentativas[8].setEnabled(false);
		add(tentativas[8]);
		
		tentativas[9] = new JButton();
		tentativas[9].setBounds(330, (pos * 43), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[9].setBackground(Color.white);
		tentativas[9].setEnabled(false);
		add(tentativas[9]);
		
		tentativas[10] = new JButton();
		tentativas[10].setBounds(290, ((pos * 43) + 19), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[10].setBackground(Color.white);
		tentativas[10].setEnabled(false);
		add(tentativas[10]);
		
		tentativas[11] = new JButton();
		tentativas[11].setBounds(310, ((pos * 43) + 19), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[11].setBackground(Color.white);
		tentativas[11].setEnabled(false);
		add(tentativas[11]);
		
		tentativas[12] = new JButton();
		tentativas[12].setBounds(330, ((pos * 43) + 19), tamanhoDicas.width, tamanhoDicas.height);
		tentativas[12].setBackground(Color.white);
		tentativas[12].setEnabled(false);
		add(tentativas[12]);
		
	}
}
