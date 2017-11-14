<?php

    $con = mysqli_connect("localhost", "root", "bcd127", "contatos_api");

    $sql = "SELECT * FROM tbl_contato;";

    $resultado = mysqli_query($con, $sql);

    $lstContatos = array();

    while($contato = mysqli_fetch_assoc($resultado)){
        $lstContatos [] = $contato;
        
//        RENOMEAR OS ATRIBUTOS
//        $lstContatos [] = array('usuario' => $contato['nome'], 'tel' => $contatos['telefone']);
    }

echo json_encode($lstContatos);

?>