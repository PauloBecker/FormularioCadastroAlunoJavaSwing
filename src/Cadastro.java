import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Cadastro implements ActionListener, ItemListener{
	
	JTextArea textArea;
	JLabel label;
	JTextField  nome, endereco, cidade;
	JRadioButton radioMas, radioFem;
	ButtonGroup group;
	JCheckBox checkbox1, checkbox2, checkbox3;
	JButton button;
	
	public Cadastro() {
		JFrame frame;
		frame = new JFrame("Cadastro");
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JButton button;
		
		JPanel p4 = new JPanel(new GridLayout(7, 1));
		label = new JLabel("Nome: ");		
		p4.add(label);
		nome = new JTextField(20);
		p4.add(nome);
		label = new JLabel("Endereço: ");		
		p4.add(label);
		endereco = new JTextField(20);
		p4.add(endereco);
		label = new JLabel("Cidade: ");		
		p4.add(label);
		cidade = new JTextField(20);
		p4.add(cidade);
		
		label = new JLabel("Sexo: ");		
		p4.add(label);
		radioMas = new JRadioButton("Masculino");
		radioFem = new JRadioButton("Feminino");		
		group = new ButtonGroup();
		group.add( radioMas );
		group.add( radioFem );
		JPanel panelOpc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOpc .add( radioMas );
		panelOpc .add( radioFem );		
		p4.add( panelOpc);	
		
		label = new JLabel("Cursos: ");	
		p4.add(label);
		checkbox1 = new JCheckBox("Curso 1");
		checkbox1.addItemListener(this); 
		p4.add(checkbox1);
		
		checkbox2 = new JCheckBox("Curso 2");
		checkbox2.addItemListener(this); 
		p4.add(checkbox2);
		
		checkbox3 = new JCheckBox("Curso 3");
		checkbox3.addItemListener(this); 
		p4.add(checkbox3);
		
		button = new JButton("Adicionar");
		button.addActionListener(this);
		p4.add(button);
		
		JPanel p5 = new JPanel();
		p5.add(p4);
		frame.add(p5, BorderLayout.WEST);
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);	 	
		JScrollPane scroll = new JScrollPane(textArea);
		frame.add(scroll, "Center");
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		button = new JButton("Editar");
		button.addActionListener(this);
		p1.add(button);
		button = new JButton("Limpar");
		button.addActionListener(this);
		p1.add(button);
		frame.add( p1, "South");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cb1 = "";
		String cb2 = "";
		String cb3 = "";
		if(checkbox1.isSelected()) {
			cb1 = checkbox1.getText();
		}else {
			cb1 = "";
		}
		if(checkbox2.isSelected()) {
			cb2 = checkbox2.getText();
		}else {
			cb2 = "";
		}
		if(checkbox3.isSelected()) {
			cb3 = checkbox3.getText();
		}else {
			cb3 = "";
		}
		if(e.getActionCommand().equalsIgnoreCase("Adicionar")) {
			textArea.setText(nome.getText() + "\n" +
					endereco.getText() +  "\n" +
					cidade.getText() + "\n" +
					getRadio() + "\n" +
					cb1 + "\n" +
					cb2 + "\n" +
					cb3 + "\n" );				
			
			nome.setText("");
			endereco.setText("");
			cidade.setText("");
			group.clearSelection();
			checkbox1.setSelected(false);
			checkbox2.setSelected(false);
			checkbox3.setSelected(false);
		}else if(e.getActionCommand().equalsIgnoreCase("Editar")) {
			textArea.setEditable(true);
		}else if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
			textArea.setText("");
		}else {
			textArea.setText(textArea.getText()+e.getActionCommand() + "\n");
		}
	}
	
	public String getRadio() {
		String value ="";
		if(radioMas.isSelected()){
		         value = "Masculino";
		}
		if(radioFem.isSelected()){
		         value = "Feminino";
		}
		return value;
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new Cadastro();
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}