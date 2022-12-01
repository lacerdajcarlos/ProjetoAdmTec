import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.admtec.livraria.produtos.Ebook;
import br.com.admtec.livraria.produtos.Livro;
import livraria.servlet.Conexao;

public class EbookDAO {
	/* ----CONEXÃO COM O BD-> */
	private Connection conexao;

	// Estabelece uma conexão
	public EbookDAO() throws SQLException {
		this.conexao = Conexao.getConexao();
	}
	/* <-CONEXÃO COM O BD---- */

	/* ----Ebook-> */

	// CREATE - Adiciona um registro
	public void adicionaEbook(Ebook ebook) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "INSERT INTO Ebook(Titulo, Autor, Valor, Editora, Edicao, Ano)" + "VALUES(?, ?, ?, ?, ?,?,?)";
		PreparedStatement stmt;
		// stmt recebe o comando SQL
		stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, ebook.getTitulo());
		stmt.setString(2, ebook.getAutor());
		stmt.setDouble(3, ebook.getValor());
		stmt.setString(4, String.valueOf(ebook.getEditora()));				
		stmt.setString(5, String.valueOf(ebook.getEdicao()));
		stmt.setString(6, String.valueOf(ebook.getAno()));
	

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}
	
	// SELECT - Retorna uma lista com o resultado da consulta
	public List<Livro> getLista(String titulo) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "SELECT * FROM Ebook WHERE Titulo like ?";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, titulo);

		// Recebe o resultado da consulta SQL
		ResultSet rs = stmt.executeQuery();

		List<Livro> lista = new ArrayList<>();

		// Enquanto existir registros, pega os valores do ReultSet e vai adicionando na
		// lista
		while (rs.next()) {
			// A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de
			// registros p/ a lista
			Livro ebook = new Ebook();

			// "c" -> Registro novo - .setTitulo recebe o campo do banco de String "titulo"
			ebook.setId(Integer.valueOf(rs.getString("ID_Ebook")));
			ebook.setTitulo(rs.getString("titulo"));
			ebook.setAutor(rs.getString("autor"));
			ebook.setValor(Double.valueOf(rs.getString("valor")));
			//1.setEditora(String.valueOf(l.getEditora());
			ebook.setEdicao(Byte.valueOf(rs.getString("edicao")));
			ebook.setAno(Short.valueOf(rs.getString("ano")));

			// Adiciona o registro na lista
			lista.add(ebook);
		}

		// Fecha a conexão com o BD
		rs.close();
		stmt.close();

		// Retorna a lista de registros, gerados pela consulta
		return lista;
	}

	// UPDATE - Atualiza registros
	public void altera(Livro ebook) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "UPDATE Ebook set Titulo=?, Autor=?, Valor=?,Edicao=?, ano=?, " + "WHERE ID_Ebook=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, ebook.getTitulo());
		stmt.setString(2, ebook.getAutor());
		stmt.setDouble(3, ebook.getValor());
		stmt.setString(4, String.valueOf(ebook.getEdicao()));
		stmt.setString(5, String.valueOf(ebook.getAno()));

		// Usa o ID como parâmetro de comparação no SQL
		stmt.setInt(6, ebook.getId());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}

	// DELETE - Apaga registros
	public void remove(int id) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "DELETE FROM Ebook WHERE ID_Ebook=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
		stmt.setInt(1, id);

		// Executa o codigo SQL, e fecha
		stmt.execute();
		stmt.close();

	}
	/* <-EBOOK---- */

}


