<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<header>

	<script src="<c:url value="/jquery/vis/dist/vis.js" />"
		type="text/javascript"></script>
</header>
<body>
	<h1>Hello world!</h1>
	<a href="home">home</a>
	<a href="echo/id=2,name=ouchida,email=ouchida@gmail.com">echo</a>
	<div id="mynetwork"></div>
	<script type="text/javascript">
  // create an array with nodes
  var nodes = [
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2},
    {from: 1, to: 3},
    {from: 2, to: 4},
    {from: 2, to: 5}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data= {
    nodes: nodes,
    edges: edges,
  };
  var options = {
    width: '500px',
    height: '500px'
    
  };
  var options={
		  navigation: true	  
  };
  var options={
	    dataManipulation: true
	}
  var network = new vis.Network(container, data, options);
</script>
</body>
</html>