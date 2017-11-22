<?php

  $con = mysqli_connect("localhost", "root", "bcd127", "contatos_api");

  $nome = $_POST["nome"];
  $telefone = $_POST["telefone"];
  $imagem = $_POST["imagem"];

  if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $sql = "INSERT INTO tbl_contato (nome, telefone, imagem) VALUES ('$nome', '$telefone', '$imagem');";

    if (mysqli_query($con, $sql)){
      echo json_encode(array(
        "sucesso" => true,
        "mensagem" => "Inserido com sucesso"));
    }else{
      echo json_encode(array(
        "sucesso" => false,
        "mensagem" => "Falha ao inserir dados"));
    }

  }else{
    echo json_encode(array(
      "sucesso" => false,
      "mensagem" => "Falha ao inserir dados - ERROR: METHOD"));
  }
?>
