<php
	$pdo = new PDO('mysql:host=localhost;dbname=banco_usuario;port=3306;charset=utf8, 'root', '88232539'');

	$sql = "SELECT nome, quantidade FROM estoque WHERE quantidade > 1";

	$statement = $pdo -> prepare($sql);

	while($results = $statement ->fetch(PDO::FETCH_ASSOC)){
		$result[] = $results;
	}
	echo json_encode($result);
?>