<? php
$servername = "localhost";
$username = "username";
$password = "password";
$database = "database_name";

$connection = new mysqli($servername, $username, $password, $database);
if($connection -> connect_error){
    die("Connection failed");
}
echo("Connection successful");
$sql = "CREATE TABLE employee (
    Emp_Id INT PRIMARY KEY, firstname VARCHAR(20), lastname VARCHAR(20), gender VARCHAR(6));";
if($connection -> query($sql) === TRUE){
    echo ("Query Successfull");
}
else{
    echo ("Query UnSuccessfull");
}

$id = $_POST['emp_id'];
$firstname = $_POST['firstname'];
$lastname = $_POST['lastname'];
$gender = $_POST['gender'];

$sql = "INSERT INTO employee VALUES ($id, '$firstname', '$lastname', '$gender')";

if($connection -> query($sql) === TRUE){
    echo ("Values Inserted");
}
else{
    echo ("Net theek karo");
}

$connection -> close();
?>