import br.com.admtec.livraria.Cliente;
import livraria.servlet.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
	/* ----CONEXÃO COM O BD-> */

	private Connection conexao;

	// Estabelece uma conexão
	public ClienteDAO() throws SQLException {
		this.conexao = Conexao.getConexao();
	}
	/* <-CONEXÃO COM O BD---- */

	/* ----CLIENTE-> */

	// CREATE - Adiciona um registro
	public void adicionaCliente(Cliente c) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "INSERT INTO Clientes (Nome, Data_Nascimento, sexo, CPF, Telefone, Endereco, Email)" + "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		// stmt recebe o comando SQL
		stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, c.getNome());
		stmt.setDate (2, new Date(c.getDataNasc().getDate()));
		stmt.setString(3, c.getSexo());
		stmt.setString(4, c.getCpf());
		stmt.setString(5, c.getFone());
		stmt.setString(6, c.getEndereco());
		stmt.setString(7, c.getEmail());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();

	}

	// SELECT - Retorna uma lista com o resultado da consulta
	public List<Cliente> getLista(String nome) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "SELECT * FROM Clientes WHERE nome like ?";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, nome);

		// Recebe o resultado da consulta SQL
		ResultSet rs = stmt.executeQuery();

		List<Cliente> lista = new ArrayList<>();

		// Enquanto existir registros, pega os valores do ReultSet e vai adicionando na
		// lista
		while (rs.next()) {
			// A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de
			// registros p/ a lista
			Cliente c = new Cliente();

			// "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome"
			c.setCodigo(Integer.valueOf(rs.getString("Codigo")));
			c.setNome(rs.getString("Nome"));
			c.setDataNasc(rs.getDate("Data_Nascimento"));
			c.setSexo(rs.getString("sexo"));
			c.setCpf(rs.getString("CPF"));
			c.setFone(rs.getString("telefone"));
			c.setEndereco(rs.getString("Endereco"));
			c.setEmail(rs.getString("Email"));

			// Adiciona o registro na lista
			lista.add(c);
		}

		// Fecha a conexão com o BD
		rs.close();
		stmt.close();

		// Retorna a lista de registros, gerados pela consulta
		return lista;
	}

	// UPDATE - Atualiza registros
	public void altera(Cliente c) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "UPDATE Clientes set Nome=?, Data_Nascimento=?, sexo=?, CPF=?, Telefone=?, Endereco=?, Email=?" + "WHERE id_cliente=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setInt(8, c.getCodigo());
		stmt.setString(1, c.getNome());
		stmt.setDate(2, (java.sql.Date) c.getDataNasc());
		stmt.setString(3, c.getSexo());
		stmt.setString(4, c.getCpf());
		stmt.setString(5, c.getFone());
		stmt.setString(6, c.getEndereco());
		stmt.setString(7, c.getEmail());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}

	// DELETE - Apaga registros
	public void remove(int id) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "DELETE FROM Clientes WHERE Codigo=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
		stmt.setInt(1, id);

		// Executa o codigo SQL, e fecha
		stmt.execute();
		stmt.close();

	}
	/* <-CLIENTE---- */

}
