<?php	
	$conexao=mysql_connect("localhost","root","bcd127");

	//Especifica qual database será utilizado
	mysql_select_db("dbContatosAPI");
	
	$sql = "select * from contato;";
	
	$select = mysql_query($sql);
				
	$lstContato= array();
	
	
	while($contato = mysql_fetch_assoc($select))
	{
		$lstContato[] =  $contato;
	}
	
	echo json_encode($lstContato);
	
?>