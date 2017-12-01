package br.edu.ifc.fraiburgo.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifc.fraiburgo.Contato;
import br.edu.ifc.fraiburgo.crud.ContatoCrud;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest requisicao,
			HttpServletResponse resposta)
	throws ServletException, IOException {
		
		resposta.setCharacterEncoding("utf-8");
		requisicao.setCharacterEncoding("utf-8");
		
		String nome = requisicao.getParameter("nome");
		String telefone = requisicao.getParameter("telefone");
		String email = requisicao.getParameter("email");
		String cidade = requisicao.getParameter("cidade");
		
		Contato c1 = new Contato();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setEmail(email);
		c1.setCidade(cidade);
		
		ContatoCrud cc = new ContatoCrud();
		cc.inserir(c1);
		
		
		RequestDispatcher rd = null;
		rd = requisicao.getRequestDispatcher("/cadastra.jsp");
		rd.forward(requisicao, resposta);
	}

}
