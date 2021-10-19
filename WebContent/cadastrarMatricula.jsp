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
			<li><a href="consultar.jsp">Consultar</a></li>

		</ul>
	</nav>
	<main class="escolaMain">
		<form action="cadastrarMatricula" method="post" class="escolaForm">
			<div>
				<label><strong>Código Aluno:*</strong></label> <input type="text"
					name=codAluno>
			</div>
			<div>
				<label><strong>Código da Disciplina:*</strong></label> <input
					type="text" name="codDisciplina">
			</div>
			<div>
				<label><strong>Data da matrícula:</strong></label> <input
					type="text" name="dataMatricula">
			</div>
			<div>
				<input id="escolaButton" type="submit" name="salvar"
					value="Cadastrar Matrícula">
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
	</main>
</body>
</html>