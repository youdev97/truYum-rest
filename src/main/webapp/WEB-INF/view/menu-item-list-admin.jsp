<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>truYum</title>
<link rel="icon" type="image/ico" href="/resources/images/truyum-logo-dark.png" />
<link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
</head>
<body>
	<header>
		<span class="header-title">truYum</span> <img class="header-logo"
			src="/resources/images/truyum-logo-light.png" alt="truYum Logo"></img>
		<nav>
			<a class="nav-link" href="/show-menu-list-admin">Menu</a>
		</nav>
	</header>
	<article>
		<h2 class="article-heading">Menu Items</h2>
		<table>
			<tr>
				<th class="col-left">Name</th>
				<th class="col-right">Price</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td class="col-left">${menuItem.name}</td>
					<td class="col-right">${menuItem.price}</td>
					<td>${menuItem.active ? 'Yes': 'No'}</td>
					<td>${menuItem.dateOfLaunch}</td>
					<td>${menuItem.category}</td>
					<td>${menuItem.freeDelivery ? 'Yes': 'No'}</td>
					<td><a class="action-link" href="/show-edit-menu-item?menuItemId=${menuItem.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<footer>
		<p>Copyright &copy; 2019</p>
	</footer>
</body>
</html>