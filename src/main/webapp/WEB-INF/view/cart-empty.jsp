<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>truYum</title>
		<link rel="icon" type="image/ico" href="/resources/images/truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="/resources/style/style.css">
	</head>
	<body>
		<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="/resources/images/truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="/show-menu-list-customer">Menu</a>
				<a class="nav-link" href="/show-cart">Cart</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Cart</h2>
			<p class="article-message">No items in cart. Use 'Add to Cart' option in 
				<a class="article-link" href="/show-menu-list-customer">Menu Item List</a>.
			</p>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>