<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "br.com.felipe.projeto.controller.PostitController" %>
<%@ page import = "br.com.felipe.projeto.model.Postit" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control"      content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2012 00:00:00 GMT">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Postit Online</title>
    <link rel="stylesheet" href="css/Style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
</head>

<body>

    <div id="title_page_index">Bem vindo</div>

    <section class=container>

        <div class=box>
            <h1>Adicionar Postit: </h1><br>
                <form action="AdicionarPostit" method="get">
                    <label for="GET-postit">Nome:</label><br>
                    <input type="text" name="postitName"><br>
                    <label for="GET-postit">Descricao:</label><br>
                    <input type="text" name="postitDescription"><br><br>
                    <button type="submit">Adicionar</button> 
                </form>
        </div>
    </section>
   <section class="lastContainer">
                <table>
                    <thead>
                        <tr>
                            <th colspan="3">Postits</th>                          
                             </tr>   
                             <tr>
                             		<th id="title1table" colspan="1">#</th>
                                    <th id="title2table" colspan="2">Nome: </th>
                                    <th id="title3table" colspan="2">Descricao: </th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        ArrayList<Postit> postits = PostitController.getInstance().getList();
                           if (postits != null) {
                               for (Postit post : postits) {
                            %>  
                            <tr>
                                <td><%= post.getName()%> </td>
                                <td><%= post.getDesc()%> </td>
                            </tr>
                            <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </section>
    <footer>
        <h2 style="margin: 0">&copy Felipe Marques, 2019.</h2>

        <p style="margin: 12px"> <br> 20 anos, estudante de ciencia da computacao, aspirante a desenvolvedor,
            <br>apaixonado por musica e arte. Atualmente estudando HTML/CSS/JS, Python, JAVA e Java Web.
            <br><br><b>Contato:</b><br>
            <a href="https://github.com/felipecolor9" id="git_link" class="social_media_link" target="_blank" rel="noopener"><i class=" fab fa-github fa-3x " "></i>
            </a>
            <a href="#" id="wpp_link"><i class="fab fa-whatsapp fa-3x" target="_blank"></i></a>
            <a href="https://www.facebook.com/QuinnCansada" id="fb_link"><i class="fab fa-facebook fa-3x" target="_blank"rel="noopener"></i></a>
            <a href="https://www.instagram.com/the.hendrixx/" id="ig_link" target="_blank"><i class="fab fa-instagram fa-3x"rel="noopener"></i></a>
    </footer>

</body>
</html>