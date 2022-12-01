
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.admtec.livraria.Editora;
import livraria.servlet.Conexao;

public class EditoraDAO {

	/* ----CONEXÃO COM O BD-> */
 private Connection conexao;

	// Estabelece uma conexão
	public EditoraDAO() throws SQLException {
		this.conexao = Conexao.getConexao();
	}
	/* <-CONEXÃO COM O BD---- */

	/* ----Editora-> */

	// CREATE - Adiciona um registro
	public void adicionaEditora(Editora e) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "INSERT INTO Editora(Nome_Fantasia , Razao_Social , Cnpj) " + "VALUES(?,?,?)";
		PreparedStatement stmt;
		// stmt recebe o comando SQL
		stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		
		stmt.setString(1, e.getNomeFantasia());
		stmt.setString(2, e.getRazaoSocial());
		stmt.setString(3, e.getCnpj());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();

	}

	// SELECT - Retorna uma lista com o resultado da consulta
	public List<Editora> getLista(String nomeFantasia) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "SELECT * FROM Editora WHERE nome like ?";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1,nomeFantasia);

		// Recebe o resultado da consulta SQL
		ResultSet rs = stmt.executeQuery();

		List<Editora> lista = new ArrayList<>();

		// Enquanto existir registros, pega os valores do ReultSet e vai adicionando na
		// lista
		while (rs.next()) {
			// A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de
			// registros p/ a lista
			Editora e = new Editora();

			// "a" -> Autor novo - .setNome recebe o campo do banco de String "nome"
			e.setidEditora(Integer.valueOf(rs.getString("ID_Editora")));
			e.setNomeFantasia(rs.getString("Nome Fantasia"));
			e.setRazaoSocial(rs.getString("Razao Social"));
			e.setCnpj(rs.getString("CNPJ"));

			// Adiciona o registro na lista
			lista.add(e);
		}

		// Fecha a conexão com o BD
		rs.close();
		stmt.close();

		// Retorna a lista de registros, gerados pela consulta
		return lista;
	}

	// UPDATE - Atualiza registros
	public void altera(Editora e) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "UPDATE Editora set Nome_Fantasia=?, Razao_Social=?, Cnpj=?" + "WHERE ID_Editora=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setInt(4, e.getidEditora());
		stmt.setString(1, e.getNomeFantasia());
		stmt.setString(2, e.getRazaoSocial());
		stmt.setString(3, e.getCnpj());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}

	// DELETE - Apaga registros
	public void remove(int id) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "DELETE FROM Editora WHERE ID_Editora=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
		stmt.setInt(1, id);

		// Executa o codigo SQL, e fecha
		stmt.execute();
		stmt.close();

	}
}
	// <-Editora---- 

