
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.admtec.livraria.Cliente;
import br.com.admtec.livraria.Editora;
import br.com.admtec.livraria.produtos.Livro;
import br.com.admtec.livraria.produtos.Revista;
import livraria.servlet.Conexao;

public class RevistaDAO {
	/* ----CONEXÃO COM O BD-> */
	private Connection conexao;

	// Estabelece uma conexão
	public RevistaDAO() throws SQLException {
		this.conexao = Conexao.getConexao();
	}
	/* <-CONEXÃO COM O BD---- */

	/* ----REVISTA-> */

	// CREATE - Adiciona um registro
	public void adicionaRevista(Revista revista) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "INSERT INTO Revista(Titulo,Descricao,Valor, Edicao)" + "VALUES(?, ?, ?,?)";
		PreparedStatement stmt;
		// stmt recebe o comando SQL
		stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, revista.getTitulo());
		stmt.setString(2, revista.getDescricao());
		stmt.setDouble(3, revista.getValor());
		stmt.setString(4, String.valueOf(revista.getEdicao()));
	

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();

	}

	// SELECT - Retorna uma lista com o resultado da consulta
	public List<Revista> getLista(String titulo) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "SELECT * FROM Revista WHERE Titulo like ?";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, titulo);

		// Recebe o resultado da consulta SQL
		ResultSet rs = stmt.executeQuery();

		List<Revista> lista = new ArrayList<>();

		// Enquanto existir registros, pega os valores do ReultSet e vai adicionando na
		// lista
		while (rs.next()) {
			// A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de
			// registros p/ a lista
			Revista revista = new Revista();
			// "c" -> Registro novo - .setNome recebe o campo do banco de String "nome"
			revista.setId(Integer.valueOf(rs.getString("ID_Revista")));
			revista.setTitulo(rs.getString("Titulo"));
			revista.setDescricao(rs.getString("Descricao"));
			revista.setValor(Double.valueOf(rs.getString("Valor")));
			revista.setEdicao(Byte.valueOf(rs.getString("Edicao")));

			// Adiciona o registro na lista
			lista.add(revista);
		}

		// Fecha a conexão com o BD
		rs.close();
		stmt.close();

		// Retorna a lista de registros, gerados pela consulta
		return lista;
	}

	// UPDATE - Atualiza registros
	public void altera(Revista revista) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "UPDATE Revista set Titulo=? ,Descricao=? ,Valor=?, Edicao=? " + "WHERE ID_Revista=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, revista.getTitulo());
		stmt.setString(2, revista.getDescricao());
		stmt.setDouble(3, revista.getValor());
		stmt.setString(4, String.valueOf(revista.getEdicao()));
		

		// Usa o ID como parâmetro de comparação no SQL
		stmt.setInt(5, revista.getId());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}

	// DELETE - Apaga registros
	public void remove(int id) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "DELETE FROM Revista WHERE ID_Revista=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
		stmt.setInt(1, id);

		// Executa o codigo SQL, e fecha
		stmt.execute();
		stmt.close();

	}
	/* <-REVISTA---- */

}
