package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Disciplina;

@WebServlet("/cadastrarDisciplinaController")
public class cadastrarDisciplinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarDisciplinaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarDisciplina.jsp");
			boolean ativa = false;
			String mensagem = null;

			if (request.getParameter("codProfessor") != null && !request.getParameter("codProfessor").isEmpty()) {
				int codProfessor = Integer.parseInt(request.getParameter("codProfessor"));
				String descDisciplina = request.getParameter("descDisciplina");
				int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
				if (request.getParameter("ativa") != null && request.getParameter("ativa").equals("on")) {
					ativa = true;
				}
				Disciplina disciplina = new Disciplina(codProfessor, descDisciplina, cargaHoraria, ativa);
				disciplina.incluirDisciplina(disciplina);
				mensagem = "Disciplina cadastrada com sucesso!";
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
