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
		<form action="cadastrarAluno" method="post" class="escolaForm">
			<div>
				<label><strong>Nome:</strong></label> <input type="text"
					name=nomeAluno>
			</div>
			<div>
				<label><strong>CPF:</strong></label> <input type="text"
					name="cpfAluno">
			</div>
			<div>
				<label><strong>Data Nascimento:</strong></label> <input type="text"
					name="dataNascimento">
			</div>
			<div>
				<label><strong>Data Matrícula: *</strong></label> <input type="text"
					name="dataMatricula">
			</div>
			<div>
				<label><strong>Nome pai: *</strong></label> <input type="text"
					name="nomePai">
			</div>
			<div>
				<label><strong>Nome mãe: *</strong></label> <input type="text"
					name="nomeMae">
			</div>
			<div>
				<label><strong>Responsável:</strong></label> <input type="text"
					name="responsavel">
			</div>
			<div>
				<label><strong>Fone Responsável:</strong></label> <input type="text"
					name="foneResponsavel">
			</div>

			<label><strong>Matrículado:</strong></label><input type="checkbox"
				name="matriculado"> <br>
			<div>

				<input id="escolaButton" type="submit" name="salvar"
					value="Cadastrar Aluno">
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