import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;

public class MenuIHC extends JFrame {
	
	private JLabel logo;
	private JButton jogar, regras;
	
	private JComboBox<String> niveis;
	private String[] nomesNiveis = {"F�cil", "Dif�cil"};
	
	private MenuHandler menuHandler = new MenuHandler();
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public MenuIHC(){
		
		super("MasterMind");
		setLayout(null);
		
		Icon logoMaster = new ImageIcon (getClass().getResource("mastermindlogo.jpg"));
		
		logo = new JLabel();
		logo.setBounds(40, 30, 400, 100);
		logo.setIcon(logoMaster);
		add(logo);
		
		jogar = new JButton("Jogar");
		jogar.setBounds(130, 200, 100, 50);
		add(jogar);
		
		regras = new JButton("Regras");
		regras.setBounds(260, 200, 100, 50);
		add(regras);
		
		niveis = new JComboBox<String>(nomesNiveis);
		niveis.setBounds(190, 260, 100, 30);
		add(niveis);
		
		jogar.addActionListener(menuHandler);
		regras.addActionListener(menuHandler);
	}
	
	private class MenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == jogar) {
				
				String escolhaDoNivel;
				
				escolhaDoNivel = ((String)niveis.getSelectedItem());
				
				if(escolhaDoNivel.equals("F�cil")){
					JogoIHC jogo = new JogoIHC();
					jogo.setSize(270, 600);
					jogo.setResizable(false);
					jogo.setVisible(true);
					jogo.setLocation(dim.width/2-jogo.getSize().width/2, dim.height/2-jogo.getSize().height/2);
					
					JogoSenhaLogica.getInstance().geraSenha();
				}
				else{
					
					JogoDificilIHC jogoDificil = new JogoDificilIHC();
					jogoDificil.setSize(370, 750);
					jogoDificil.setResizable(false);
					jogoDificil.setVisible(true);
					jogoDificil.setLocation(dim.width/2-jogoDificil.getSize().width/2, dim.height/2-jogoDificil.getSize().height/2);
					
					JogoSenhaLogicaDificil.getInstance().geraSenhaDificil();
					
				}
			}
			else if(event.getSource() == regras) {
				JOptionPane.showMessageDialog(null, "O objetivo do jogo � descobrir uma senha de cores escolhida pelo computador.\nO jogo funciona da seguinte forma: O computador escolhe aleatoriamente uma senha de cores de tamanho 4 de 6 cores poss�veis (para o f�cil) ou 6 de 6 cores poss�veis (para o dif�cil).\nA senha pode conter cores repetidas (em qualquer n�mero). O jogador possui 8 tentativas para acertar a senha (no f�cil) ou 12 tentativas para acertar a senha (no dif�cil).\nA cada tentativa, o jogador recebe uma resposta do sistema indicando seus acertos, de acordo com as seguintes regras:\n- Se o jogador acertar uma cor que est� escondida, mas em posi��o incorreta, ganha um ponto cinza.\n- Se o jogador acertar cor e posi��o correta, ganha um ponto preto.\n- Se o jogador n�o acerta cor n�o ganha nenhum ponto (branco).\n\n� importante ressaltar que a pontua��o n�o d� nenhuma dica ao jogador sobre qual a cor que est� certa, ou em qual posi��o.", "Regras", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
