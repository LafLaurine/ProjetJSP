<?xml version="1.0" encoding="utf-8"?>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<link rel="stylesheet" href="css/style.css" /> <!-- lien vers le css -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Infix</title>
</head>

<body>

<%@ page pageEncoding="UTF-8"%> <!-- encodage JSP -->

<header id="header">
				<div class="inner">
						<b><a href="index.html">Home</a></b>
						<b><a href="elements.html">Elements</a></b>
				</div>
			</header>


<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
						<h2>Infixe en préfixe</h2>
						<a href="?"><p>Reset </p></a>
					</header>

<section id="one" class="wrapper">
	<div class="inner">
		<div>
			<article>
				<!-- Formulaire qui va permettre d'entrer la chaîne infixe parenthésée -->
				<form action="InfixToPrefix" method="GET"> 
					Entrer une chaîne infixe parenthésée: <input type="text" name="infix"/> </br>
					<input type="submit" value="Valider"/>
				</form>   					

<!-- Conversion -->
<% 	String prefix = (String)request.getAttribute("prefix");
	if (prefix!=null)
	out.println("La conversion en prefix est : " + prefix);%> </br>
	
</div>	

</body>

</html>
