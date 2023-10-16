<? php
$servername = "localhost";
$username = "username";
$password = "password";
$conn = new mysqli($servername, $username, $password);
if($conn -> connect_error){
    die ("fail");
}

$sql = "CREATE TABLE employee (Emp_ID INT PRIMARY KEY, Firstname VARCHAR(25), Lastname VARCHAR(25), 
    Gender VARCHAR(6));"
if($conn -> query($sql) === TRUE){
    echo "Chuckchess";
}
else{
    echo "Popat";
}
$conn -> close();
?>