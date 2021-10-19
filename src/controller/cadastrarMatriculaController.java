package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Matricula;

@WebServlet("/cadastrarMatriculaController")
public class cadastrarMatriculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarMatriculaController() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarMatricula.jsp");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String mensagem = null;

			if (request.getParameter("codAluno") != null && !request.getParameter("codAluno").isEmpty()) {
				if (request.getParameter("codDisciplina") != null && !request.getParameter("codDisciplina").isEmpty()) {
					int codAluno = Integer.parseInt(request.getParameter("codAluno"));
					int codDisciplina = Integer.parseInt(request.getParameter("codDisciplina"));
					Date dataMatricula = sdf.parse(request.getParameter("dataMatricula"));
					Matricula matricula = new Matricula(codAluno, codDisciplina, dataMatricula);
					matricula.gerarMatricula(matricula);
					mensagem = "Matrícula cadastrada com sucesso!";
				} else {
					mensagem = "Os campos precisam ser preenchidos corretamente!";
				}
				request.setAttribute("mensagem", mensagem);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
