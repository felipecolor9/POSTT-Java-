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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
</head>

<body>
	<div id="title_page_index">Adicione Postits</div>

  	<section class=container>	
  		<div class=box>
  	 		<h1>ACESSAR SISTEMA</h1><br>

          	<form action="Autentificacao" method="post">
                <label for="POST-user">Usuario:</label><br>
                <input type="text" name="userNameLogin"><br>
                <label for="POST-user">Senha:</label><br>
                <input type="password" name="userPassLogin"><br><br>
                <button type="submit">Login</button>
          	</form>
          
            <p style="color:red;"><b>Usuario ou sistema invalidos</b><br>Favor, tentar novamente.</p>
       </div>
    
    <div class="box">
       <p> <b>Não tem um cadastro? <a href="Register.jsp">Registre-se aqui</a></b></p>
    </div>
  </section>

    <footer>
        <h2 style="margin: 0">&copy Felipe Marques, 2019.</h2>

        <p style="margin: 12px"> <br> 20 anos, estudante de cienncia da computacao, aspirante a desenvolvedor,
            <br>apaixonado por musica e arte. Atualmente estudando HTML/CSS/JS, Python, JAVA e Java Web.
            <br><br><b>Contato:</b><br>
            <a href="https://github.com/felipecolor9" id="git_link" class="social_media_link" target="_blank" rel="noopener"><i class=" fab fa-github fa-3x "></i>
            </a>
            <a href="#" id="wpp_link"><i class="fab fa-whatsapp fa-3x" target="_blank"></i></a>
            <a href="https://www.facebook.com/QuinnCansada" id="fb_link"><i class="fab fa-facebook fa-3x" target="_blank"rel="noopener"></i></a>
            <a href="https://www.instagram.com/the.hendrixx/" id="ig_link" target="_blank"><i class="fab fa-instagram fa-3x"rel="noopener"></i></a>
    </footer>

</body>
</html>