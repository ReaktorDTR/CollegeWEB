<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>������ ������ �� �������</title>
</head>
<body>
	<?php 
    // ���������� ��������� ������
    $db_host = 'localhost';
    $db_name = 'college';
    $db_username = 'root';
    $db_password = 'root';
    $db_table_to_show = 'groups';

    // ����������� � �������� ���� ������
    $connect_to_db = mysql_connect($db_host, $db_username, $db_password)
		or die("Could not connect: " . mysql_error());

    // ������������ � ���� ������
    mysql_select_db($db_name, $connect_to_db)
		or die("Could not select DB: " . mysql_error());

    // �������� ��� �������� �� ������� "Contacts"
    $qr_result = mysql_query("select * from " . $db_table_to_show)
		or die(mysql_error());

    // ������� �� �������� ����� ��������� HTML-�������
    echo '<table border="1">';
	echo '<thead>';
	echo '<tr>';
	echo '<th>ID</th>';
	echo '<th>Group</th>';
	echo '</tr>';
	echo '</thead>';
	echo '<tbody>';
	
   // ������� � HTML-������� ��� ������ �������� �� ������� MySQL 
	while($data = mysql_fetch_array($qr_result)){ 
		echo '<tr>';
		echo '<td>' . $data['id'] . '</td>';
		echo '<td>' . $data['groupName'] . '</td>';
		echo '</tr>';
	}
	
    echo '</tbody>';
	echo '</table>';

    // ��������� ���������� � ��������  ���� ������
    mysql_close($connect_to_db);
?>
</body>
</html>