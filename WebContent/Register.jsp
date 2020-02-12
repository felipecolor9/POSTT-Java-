<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Postit Online</title>

<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
</head>

<body>
	<div id="title_page_index">Adicione Postits</div>

	<section class=container>
		<div class=box>
			<h1>TELA DE CADASTRO</h1>
			<br>

			<form action="RegistrationSucessful.jsp" method="post">
				<label for="POST-user">Insira o seu nome completo:</label><br>
				<input type="text" name="userCompNameReg"><br><br>
				<label for="POST-user">Digite o seu nome de usuario:</label><br>
				<input type="text" name="userNameReg"><br> <br> 
				<label for="POST-user">Digite a sua senha:</label><br> 
				<input type="password" name="userPassReg"><br> <br> 
				<label for="POST-user">Confirme a sua senha:</label><br> 
				<input type="password" name="confirmUserPassReg"><br> <br>
				<button type="submit">Registrar</button>
			</form>
			<br> <a href=Login.jsp>Voltar</a>
		</div>

	</section>

	<footer>
		<h2 style="margin: 0">&copy Felipe Marques, 2020.</h2>

		<p style="margin: 12px">
			<br> 20 anos, estudante de cienncia da computacao, aspirante a
			desenvolvedor, <br>apaixonado por musica e arte. Atualmente
			estudando HTML/CSS/JS, Python, JAVA e Java Web. <br> <br> <b>Contato:</b><br>
			<a href="https://github.com/felipecolor9" id="git_link"
				class="social_media_link" target="_blank" rel="noopener"><i
				class=" fab fa-github fa-3x "></i> </a> <a href="#" id="wpp_link"><i
				class="fab fa-whatsapp fa-3x" target="_blank"></i></a> <a
				href="https://www.facebook.com/QuinnCansada" id="fb_link"><i
				class="fab fa-facebook fa-3x" target="_blank" rel="noopener"></i></a> <a
				href="https://www.instagram.com/the.hendrixx/" id="ig_link"
				target="_blank"><i class="fab fa-instagram fa-3x" rel="noopener"></i></a>
	</footer>

</body>
</html>