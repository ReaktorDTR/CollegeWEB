<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Запрос данных из таблицы</title>
</head>
<body>
	<?php 
    // определяем начальные данные
    $db_host = 'localhost';
    $db_name = 'college';
    $db_username = 'root';
    $db_password = 'root';
    $db_table_to_show = 'groups';

    // соединяемся с сервером базы данных
    $connect_to_db = mysql_connect($db_host, $db_username, $db_password)
		or die("Could not connect: " . mysql_error());

    // подключаемся к базе данных
    mysql_select_db($db_name, $connect_to_db)
		or die("Could not select DB: " . mysql_error());

    // выбираем все значения из таблицы "Contacts"
    $qr_result = mysql_query("select * from " . $db_table_to_show)
		or die(mysql_error());

    // выводим на страницу сайта заголовки HTML-таблицы
    echo '<table border="1">';
	echo '<thead>';
	echo '<tr>';
	echo '<th>ID</th>';
	echo '<th>Group</th>';
	echo '</tr>';
	echo '</thead>';
	echo '<tbody>';
	
   // выводим в HTML-таблицу все данные клиентов из таблицы MySQL 
	while($data = mysql_fetch_array($qr_result)){ 
		echo '<tr>';
		echo '<td>' . $data['id'] . '</td>';
		echo '<td>' . $data['groupName'] . '</td>';
		echo '</tr>';
	}
	
    echo '</tbody>';
	echo '</table>';

    // закрываем соединение с сервером  базы данных
    mysql_close($connect_to_db);
?>
</body>
</html>