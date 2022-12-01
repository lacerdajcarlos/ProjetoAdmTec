import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.admtec.livraria.Cliente;
import br.com.admtec.livraria.produtos.Livro;
import br.com.admtec.livraria.produtos.LivroFisico;
import livraria.servlet.Conexao;

public class LivroDAO {
	/* ----CONEXÃO COM O BD-> */
	private Connection conexao;

	// Estabelece uma conexão
	public LivroDAO() throws SQLException {
		this.conexao = Conexao.getConexao();
	}
	/* <-CONEXÃO COM O BD---- */

	/* ----LIVRO-> */

	// CREATE - Adiciona um registro
	public void adicionaLivro(Livro l) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "INSERT INTO Livro(Titulo, Autor, Valor, Isbn, Editora, Edicao, Ano)" + "VALUES(?, ?, ?, ?, ?,?,?)";
		PreparedStatement stmt;
		// stmt recebe o comando SQL
		stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, l.getTitulo());
		stmt.setString(2, l.getAutor());
		stmt.setDouble(3, l.getValor());
		stmt.setString(4, l.getIsbn());
		stmt.setString(5, String.valueOf(l.getEditora()));				
		stmt.setString(6, String.valueOf(l.getEdicao()));
		stmt.setString(7, String.valueOf(l.getAno()));
	

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}
	
	// SELECT - Retorna uma lista com o resultado da consulta
	public List<Livro> getLista(String titulo) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "SELECT * FROM Livro WHERE Titulo like ?";
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
			Livro l = new LivroFisico();

			// "c" -> Registro novo - .setTitulo recebe o campo do banco de String "titulo"
			l.setId(Integer.valueOf(rs.getString("id_livro")));
			l.setTitulo(rs.getString("titulo"));
			l.setAutor(rs.getString("autor"));
			l.setValor(Double.valueOf(rs.getString("valor")));
			l.setIsbn(rs.getString("ISBN"));
		   // 1.setEditora(rs.getString("Editora"));
			l.setEdicao(Byte.valueOf(rs.getString("edicao")));
			l.setAno(Short.valueOf(rs.getString("ano")));

			// Adiciona o registro na lista
			lista.add(l);
		}

		// Fecha a conexão com o BD
		rs.close();
		stmt.close();

		// Retorna a lista de registros, gerados pela consulta
		return lista;
	}

	// UPDATE - Atualiza registros
	public void altera(Livro l) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "UPDATE livro set titulo=?, autor=?, valor=?,isbn=?,edicao=?, ano=?, " + "WHERE id_livro=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta os valores p/ o stmt, substituindo os "?"
		stmt.setString(1, l.getTitulo());
		stmt.setString(2, l.getAutor());
		stmt.setDouble(3, l.getValor());
		stmt.setString(4, l.getIsbn());
		stmt.setString(5, String.valueOf(l.getEdicao()));
		stmt.setString(7, String.valueOf(l.getAno()));

		// Usa o ID como parâmetro de comparação no SQL
		stmt.setInt(8, l.getId());

		// O stmt executa o comando SQL no BD, e fecha a conexão
		stmt.execute();
		stmt.close();
	}

	// DELETE - Apaga registros
	public void remove(int id) throws SQLException {
		// Prepara conexão p/ receber o comando SQL
		String sql = "DELETE FROM livro WHERE id_livro=?";
		// stmt recebe o comando SQL
		PreparedStatement stmt = this.conexao.prepareStatement(sql);

		// Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
		stmt.setInt(1, id);

		// Executa o codigo SQL, e fecha
		stmt.execute();
		stmt.close();

	}
	/* <-LIVRO---- */

}
