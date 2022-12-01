import java.sql.SQLException;
import java.util.Date;

import br.com.admtec.livraria.Cliente;
import br.com.admtec.livraria.Editora;
import br.com.admtec.livraria.produtos.Revista;

public class TesteDAO {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Revista revista = new Revista();
		revista.setTitulo("Playboy");
		revista.setValor(10.90);
		revista.setEdicao(9);
		RevistaDAO revistadao = new RevistaDAO();
		revistadao.adicionaRevista(revista); 
		
				
		/*Editora editora = new Editora();
		editora.setNomeFantasia("teste 1");
		editora.setRazaoSocial("teste 2");
		editora.setCnpj("12345678941");
		
		BdEditora editoradao = new BdEditora();
		editoradao.adicionaEditora(editora);*/
			
				
		
		/*Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		cliente.setDataNasc(new Date());
		cliente.setSexo("F");
		cliente.setCpf("1232423");
		cliente.setFone("34396550");
		cliente.setEndereco("Rua do sol");
		cliente.setEmail("eweredcs@gmail.com");
		
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.adicionaCliente(cliente);*/
		
	}

}
//Nome, Data_Nascimento, sexo, CPF, Telefone, Endereco, Email 
