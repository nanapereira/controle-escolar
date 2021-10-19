package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;

@WebServlet("/cadastrarProfessorController")
public class cadastrarProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarProfessorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProfessor.jsp");
			boolean ativo = false;
			String mensagem = null;
			
			if (request.getParameter("nomeProfessor") != null && !request.getParameter("nomeProfessor").isEmpty()) {
				String nomeProfessor = request.getParameter("nomeProfessor");
				if (request.getParameter("ativo") != null
						&& request.getParameter("ativo").equals("on")) {
					ativo = true;
				}
				Professor professor = new Professor(nomeProfessor, ativo);
				professor.incluirProfessor(professor);
				mensagem = "Professor cadastrado com sucesso!";
			} else {
				mensagem = "Os campos precisam ser preenchidos corretamente!";
			}
			request.setAttribute("mensagem", mensagem);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
