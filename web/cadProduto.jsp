<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
<f:view>
	<h:form>
	<h:outputText value="Nome: "/>
	<br/>
	<h:inputText value="#{ProdutoController.produto.nome}" id="nome"/>
	<br/>
	<h:outputText value="Valor do Produto: "/>
	<br/>
	<h:inputText value="#{ProdutoController.produto.valorProduto}" id="valorProduto"/>
	<br/>
	<h:outputText value="qtd do Produto: "/>
	<br/>
	<h:inputText value="#{ProdutoController.produto.saldoProduto}" id="saldoProduto"/>
	<br/>
	<h:outputText value="Status_estoque: "/>
	<br/>
	<h:inputText value="#{ProdutoController.produto.Status_estoque}" id="Status_estoque"/>
	<br/>
	</h:form>
</f:view>
</body>
</html>