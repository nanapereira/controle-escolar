<%@ page import="model.Aluno"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/escolaStyle.css">


<meta charset="ISO-8859-1">
<title>Controle Escolar</title>
</head>
<body>
	<nav class="escolaNav">
		<ul>
			<li><span style="color: white">ControleEscolar</span></li>
			<li><img height="20px"></li>
			<li><a href="cadastrarAluno.jsp">Aluno</a></li>
			<li><a href="cadastrarDisciplina.jsp">Disciplina</a></li>
			<li><a href="cadastrarMatricula.jsp">Matrícula</a></li>
			<li><a href="cadastrarProfessor.jsp">Professor</a></li>
			<li><a href="consultarAluno.jsp">Consultar</a></li>
		</ul>
	</nav>
	<main class="escolaMain">
		<form action="consultarAluno" method="post" class="escolaForm">
			<div>
				<label><strong>Busca pelo nome:</strong></label><input type="text"
					name="nomeAluno">
			</div>
			<br>
			<div>
				<input id="escolaButton" type="submit" name="salvar"
					value="Consultar Aluno">
			</div>
		<%
		if (request.getAttribute("alunos") != null) {
			List<?> alunos = (List<?>) request.getAttribute("alunos");
			for (int contador = 0; contador <= (alunos.size() - 1); contador++) {
				Aluno aluno = (Aluno) alunos.get(contador);
		%>
		<form action="modificarAluno" method="post" class="escolaForm">
			<div class="escolaDivMother">
				<div class="escolaDivItem">
					<div class="escolaColumn">
						<span style="font-weight: bold">Código:</span> <span>
							<%
							out.print(aluno.getCodAluno());
							%>
						</span> <input type="hidden" name="id"
							value="<%out.print(aluno.getCodAluno());%>">
					</div>

					<div class="escolaColumn">
						<span style="font-weight: bold">Nome:</span> <span> <%
 out.print(aluno.getNomeAluno());
 %></span>
					</div>

						<div class="escolaColumn">
						<span style="font-weight: bold">Responsável:</span> <span>
							<%
							out.print(aluno.getResponsavel());
							%>
						</span>
					</div>
					<div class="escolaColumn">
						<span style="font-weight: bold">Fone:</span> <span>
							<%
							out.print(aluno.getFoneResponsavel());
							%>
						</span>
					</div>
					<div class="escolaColumn">
						<span style="font-weight: bold">Matriculado:</span> <span>
							<%
							out.print(aluno.isMatriculado());
							%>
						</span>
					</div>

					<div class="escolaColumn">
						<input id="escolaColumnButton" type="submit" name="alterar"
							value="Alterar">
						<div class="escolaColumn">
							<input id="escolaColumnButton" type="submit" name="excluir"
								value="Excluír">
						</div>
					</div>
				</div>
			</div>
			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null) {
					out.print(mensagem);
				}
				%>
			</div>
		</form>
		</form>
		<%
		}
		}
		%>
	</main>
	<%
	out.print("Teste");
	%>
</body>
</html>