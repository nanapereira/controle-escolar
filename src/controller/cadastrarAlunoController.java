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

import model.Aluno;

@WebServlet("/cadastrarAlunoController")
public class cadastrarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarAlunoController() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

			boolean matriculado = false;
			String mensagem = null;

			if (request.getParameter("dataMatricula") != null && !request.getParameter("dataMatricula").isEmpty()) {
				Date dataMatricula = sdf.parse(request.getParameter("dataMatricula"));

				if (request.getParameter("nomePai") != null && !request.getParameter("nomePai").isEmpty()) {
					String nomePai = request.getParameter("nomePai");

					if (request.getParameter("nomeMae") != null && !request.getParameter("nomeMae").isEmpty()) {
						String nomeMae = request.getParameter("nomeMae");

						if (request.getParameter("foneResponsavel") != null
								&& !request.getParameter("foneResponsavel").isEmpty()) {
							String nomeAluno = request.getParameter("nomeAluno");
							String cpfAluno = request.getParameter("cpfAluno");
							Date dataNascimento = sdf.parse(request.getParameter("dataNascimento"));
							String responsavel = request.getParameter("responsavel");
							String foneResponsavel = request.getParameter("foneResponsavel");

							if (request.getParameter("matriculado") != null
									&& request.getParameter("matriculado").equals("on")) {
								matriculado = true;
							}
							Aluno aluno = new Aluno(nomeAluno, cpfAluno, dataNascimento, dataMatricula, nomePai,
									nomeMae, responsavel, foneResponsavel, matriculado);						
							aluno.IncluirAluno(aluno);
							mensagem = "Aluno cadastrado com sucesso!";

						}
					}

				}
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
