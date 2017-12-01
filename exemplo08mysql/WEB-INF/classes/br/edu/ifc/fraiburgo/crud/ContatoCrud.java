package br.edu.ifc.fraiburgo.crud;

import java.sql.PreparedStatement;

import br.edu.ifc.fraiburgo.Contato;

public class ContatoCrud {
	
	public void inserir(Contato contato) {
		
		Conexao conexao = new Conexao();
		conexao.gerarConexao();
		
		PreparedStatement instrucao = null;
		String sql = "INSERT INTO contato(nome, telefone, email, cidade) " 
				+ "VALUES(?,?,?,?)"; 
				
		try {
			instrucao = conexao.connection.prepareStatement(sql);
			instrucao.setString(1, contato.getNome());
			instrucao.setString(2, contato.getTelefone());
			instrucao.setString(3, contato.getEmail());
			instrucao.setString(4, contato.getCidade());
			instrucao.execute();
			
			System.out.println("Contato inserido com sucesso!");
		} catch(Exception e) {
			
			System.out.println("Erro ao inserir!" + e.getMessage());
		} finally {
			try {
				instrucao.close();
				conexao.fechar();
			} catch(Exception e) {
				System.out.println("Erro ao fechar!" + e.getMessage());
			}



		
		}
		
	}

}
