<? php
$servername = "localhost";
$username = "username";
$password = "password";
$database = "myDb";
$conn = new mysqli($servername, $username, $password, $database);
if($conn -> connect_error){
    die ("fail");
}
$emp_id = $_POST['emp_id'];
$firstname = $_POST['firstname'];
$lastname = $_POST['lastname'];
$gender = $_POST['gender'];
$sql = "INSERT INTO employee (Emp_ID, Firstname, Lastname, Gender) 
    VALUES (" . $emp_id . ", " . $firstname . ", " . $lastname . ", " . $gender . ");";
if($conn -> query($sql) === TRUE){
    echo "Chuckchess";
}
else{
    echo "Popat";
}
$conn -> close();
?>