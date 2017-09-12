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
						<h2>Barchart</h2>
						<a href="?"><p>Reset </p></a>
					</header>

<section id="one" class="wrapper">
				<div class="inner">
					<div>
						<article>

<!-- Traitements -->

<% 	
	String tabTemp = (String)request.getAttribute("tab");
	out.println("Le tableau est " + tabTemp);%></br>

	<%String min = (String)request.getAttribute("min");
	out.println("Le minimum est " + min);%></br>

	<%String max = (String)request.getAttribute("max");
	out.println("Le maximum est "  + max);%></br>

	<%String moy = (String)request.getAttribute("moy");
	out.println("La moyenne est " + moy);%></br>			    	

</body>

</html>
