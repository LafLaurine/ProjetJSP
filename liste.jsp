<?xml version="1.0" encoding="utf-8"?>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<link rel="stylesheet" href="css/style.css" /> <!-- lien vers CSS -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Menu </title>
</head>

<body>

<%@ page pageEncoding="UTF-8"%>

<header id="header">
				<div class="inner">
						<b><a href="index.html">Home</a></b>
						<b><a href="elements.html">Elements</a></b>
				</div>
			</header>


<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
						<h2>Liste</h2>
						<a href="?"><p>Reset </p></a>
					</header>

<section id="one" class="wrapper">
				<div class="inner">
					<div>
						<article>

<h2>Veuillez entrer tous les champs</h2>

<!-- Traitements -->

<% 	String l1 = (String)request.getAttribute("liste1");
	out.println("La liste est " + l1);%> </br>
	<% String dernierElt = (String)request.getAttribute("dernierElt");
	String inverse = (String)request.getAttribute("inverse");
	out.println("Le dernier élément est " + dernierElt);%> </br>
	<%out.println("La liste inversée est " + inverse);%> </br>

	<!-- formulaire pour entrer les demandes -->

	<form action="Liste" method="GET">
	Entrer l'élement cherché : <input type="text" name="n"/> </br>
	Entrer la position de l'élément cherché : <input type="text" name="pos"/> </br>
	Entrer la position de l'élément que vous voulez supprimer : <input type="text" name="eltRmv"/> </br>
	<input type="submit" value="Valider"/>
	</form>  
	
<!-- Traitements -->
	<% String nb = (String)request.getAttribute("nb");
	out.println("La position de l'élément recherché est " + nb);%></br>

	<% String position = (String)request.getAttribute("position");
	out.println("L'entier est à la position " + position);%></br>

	<% String nbRmv = (String)request.getAttribute("nbRmv");
	out.println("La liste sans l'élément est : " + nbRmv); %>
			    	

</body>

</html>
