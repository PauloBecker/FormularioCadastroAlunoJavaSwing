import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
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



public class Cadastro implements ActionListener, ItemListener {
	
	String texto = "" ;
	boolean editavel = false;
	
	JTextArea textArea;
	
	JTextField textNome;
	JTextField textEndereco;
	JTextField textCidade;
	
	JCheckBox curso1;
	JCheckBox curso2;
	JCheckBox curso3;
	
	JRadioButton Masculino;
	JRadioButton Feminino;
	ButtonGroup group;

	JButton Adicionar;
	JButton Editar;
	JButton Limpar;
	
	JLabel jl_Sexo;

	public Cadastro() {
		JFrame frame = new JFrame("Cadastro");
		frame.setVisible(true);
		frame.setSize(1300, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JPanel jPanel = new JPanel(new GridLayout(7,1));
		
		JLabel jl_Nome = new JLabel("Nome:");
		jPanel.add(jl_Nome);
		
		
		textNome = new JTextField(30);
		jPanel.add(textNome);
		textNome.addActionListener(this);
		textNome.setActionCommand("Enter");
		
		
		JLabel jl_Endereco = new JLabel("Endereço:");
		jPanel.add(jl_Endereco);
		
		textEndereco = new JTextField(30);
		jPanel.add(textEndereco);
		textEndereco.addActionListener(this);
		textEndereco.setActionCommand("Enter");
		
		
		JLabel jl_Cidade = new JLabel("Cidade:");
		jPanel.add(jl_Cidade);
		
		textCidade = new JTextField(30);
		jPanel.add(textCidade);
		textCidade.addActionListener(this);
		textCidade.setActionCommand("Enter");
		
		JPanel panel = new JPanel();
		panel.add(jPanel);
		frame.add(panel, BorderLayout.WEST);
		
		jl_Sexo = new JLabel("Sexo:");		
		jPanel.add(jl_Sexo);
		
		Masculino = new JRadioButton("Masculino");
		Feminino = new JRadioButton("Feminino");
		
		group = new ButtonGroup();
		group.add(Masculino);
		group.add(Feminino);
		
		JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSexo.add(Masculino);
		panelSexo.add(Feminino);
		jPanel.add(panelSexo);
		
		JLabel jl_Cursos = new JLabel("Cursos:");
		jPanel.add(jl_Cursos);
		
		curso1 = new JCheckBox("Curso 1");
		jPanel.add(curso1);
		curso1.addItemListener(this);
		
		curso2 = new JCheckBox("Curso 2");
		jPanel.add(curso2);
		curso2.addItemListener(this);
		
		curso3 = new JCheckBox("Curso 3");
		jPanel.add(curso3);
		curso3.addItemListener(this);
		
		Adicionar = new JButton("Adicionar");
		jPanel.add(Adicionar);
		Adicionar.addActionListener(this);
		
		JPanel panel3 = new JPanel();
		panel3.add(jPanel);
		frame.add(panel3, BorderLayout.WEST);
		
		textArea = new JTextArea(10,28);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.add(scrollPane, "Center");
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Editar = new  JButton("Editar");
		Editar.addActionListener(this);
		panel2.add(Editar);
		
		Limpar = new  JButton("Limpar");
		Limpar.addActionListener(this);
		panel2.add(Limpar);
		frame.add(panel2, "South");
		

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new Cadastro();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Adicionar")) {
			if(textNome.getText() != "")
			{
				texto+= textNome.getText() +"\n" ;
			}
			if(textEndereco.getText() != "")
			{
				texto+= textEndereco.getText() +"\n" ;
			}
			if(textCidade.getText() != "")
			{
				texto+= textCidade.getText() +"\n" ;
			}
			if(Feminino.isSelected())
			{
				texto += "Feminino\n";
			}
			else
			{
				texto += "Masculino\n";
			}
			if(curso1.isSelected())
			{
				texto += "Curso 1\n";
			}
			if(curso3.isSelected())
			{
				texto += "Curso 2\n";
			}
			if(curso2.isSelected())
			{
				texto += "Curso 3\n";
			}
			
			texto+= "---------------------------------------------------------------------\n";
			
			textArea.setText(texto);
			
			textNome.setText("");
			textEndereco.setText("");
			textCidade.setText("");
			
			Masculino.setSelected(false);
			Feminino.setSelected(false);
			curso1.setSelected(false);
			curso2.setSelected(false);
			curso3.setSelected(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Limpar"))
		{
			texto = "";
			textArea.setText(texto);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Editar"))
		{
			if(textArea.isEditable())
			{
				textArea.setEditable(false);
			}else
			{
				textArea.setEditable(true);
			}
		}
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}