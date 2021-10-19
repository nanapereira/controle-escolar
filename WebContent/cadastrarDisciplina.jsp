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
		<form action="cadastrarDisciplina" method="post" class="escolaForm">
			<div>
				<label><strong>Código Professor:*</strong></label> <input type="text"
					name=codProfessor>
			</div>
			<div>
				<label><strong>Descrição da Disciplina:</strong></label> <input type="text"
					name="descDisciplina">
			</div>
			<div>
				<label><strong>Carga horária:</strong></label> <input type="text"
					name="cargaHoraria">
			</div>

			<label><strong>Ativa:*</strong></label><input type="checkbox"
				name="ativa"> <br>
			<div>
				<input id="escolaButton" type="submit" name="salvar"
					value="Cadastrar Disciplina">
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