package br.com.admtec.login.view;
import livraria.servlet.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TeladeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladeLogin frame = new TeladeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeladeLogin() {
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 126, 643, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel login = new JLabel("Login");
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.setBounds(167, 8, 89, 14);
		panel.add(login);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(167, 33, 364, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		senha.setBounds(167, 81, 116, 14);
		panel.add(senha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(167, 106, 364, 20);
		panel.add(txtSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection conn = Conexao.getConexao();
					String sql = "select * from Usuarios where nome=? and senha=?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtLogin.getText());
					stmt.setString(2,new String(txtSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						jfPrincipal exibir = new jfPrincipal();
						exibir.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Dados Invalidos!","ERRO", JOptionPane.ERROR_MESSAGE);
					}
					stmt.close();
					conn.close();
					
					}catch(SQLException error) {
						error.printStackTrace();
						
					}
						
			}
		});
		btnNewButton.setBounds(442, 147, 89, 23);
		panel.add(btnNewButton);
	}
}
