<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="content-language" content="en" />
	<meta name="robots" content="noindex,nofollow" />
	<link rel="stylesheet" media="screen,projection" type="text/css" href="css/reset.css" /> <!-- RESET -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="css/main.css" /> <!-- MAIN STYLE SHEET -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="css/2col.css" title="2col" /> <!-- DEFAULT: 2 COLUMNS -->
	<link rel="alternate stylesheet" media="screen,projection" type="text/css" href="css/1col.css" title="1col" /> <!-- ALTERNATE: 1 COLUMN -->
	<!--[if lte IE 6]><link rel="stylesheet" media="screen,projection" type="text/css" href="css/main-ie6.css" /><![endif]--> <!-- MSIE6 -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="css/style.css" /> <!-- GRAPHIC THEME -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="css/mystyle.css" /> <!-- WRITE YOUR CSS CODE HERE -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.switcher.js"></script>
	<script type="text/javascript" src="js/toggle.js"></script>
	<script type="text/javascript" src="js/ui.core.js"></script>
	<script type="text/javascript" src="js/ui.tabs.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".tabs > ul").tabs();
	});
	</script>
	<title>Buscaminas</title>
</head>

<body>

<div id="main">

	<!-- Columns -->
	<div id="cols" class="box">

		<!-- Content (Right Column) -->
		<div id="content" class="box">

			<!-- Table (TABLE) -->
			<h3 class="tit">Buscaminas</h3>

            <fieldset>
				<legend>Configuracion de Minas</legend>

                <form:form method="POST" ACTION="play.htm" >
                    <table class="nostyle">
                        <tr>
                            <td><label for="rowNumber">Filas:</label></td>
                            <td>
                                <input type="text" size="3" name="rowNumber" id="rowNumber" class="input-text" value="<c:out value="${minesweeper.rowNumber}" />" />
                            </td>
                            <td> <label for="colNumber">Columnas:</label></td>
                            <td>
                                <input type="text" size="3" name="colNumber" id="colNumber" class="input-text" value="<c:out value="${minesweeper.colNumber}" />" />
                            </td>
                            <td><label for="numberOfMines">Minas:</label></td>
                            <td>
                                <input type="text" size="3" name="numberOfMines" id="numberOfMines" class="input-text" value="<c:out value="${minesweeper.numberOfMines}" />"/>
                            </td>
                            <td>
                                <input type="submit" class="input-submit" value="Play" />
                            </td>
                        </tr>
                    </table>
                </form:form>

			</fieldset>


            <table>
                <c:forEach var="rowData" items="${minesweeper.myBoard}">
                    <tr>
                        <c:forEach var="cellData" items="${rowData}" >
                            <td style="width: 20px; height: 20px">
                              <img src="${cellData.status.icon}" alt="cell Image" />
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>

		</div> <!-- /content -->

	</div> <!-- /cols -->



</div> <!-- /main -->

</body>
</html>