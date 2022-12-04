<?php

/*
  Rui Santos
  Complete project details at https://RandomNerdTutorials.com/esp32-esp8266-mysql-database-php/
  
  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files.
  
  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.
*/

$servername = "localhost";

// Database name, user and password
$dbname = "mktstu21_breno";
$username = "mktstu21_breno";
$password = "Y4J[OB,znVZ]";

// Keep this API Key value to be compatible with the ESP32 code provided in the project page. 
// If you change this value, the ESP32 sketch needs to match
$api_key_value = "tPmAT5Ab3j7F9";

$api_key= $MOV_VALUE1 = $AMB_ID = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $api_key = test_input($_POST["api_key"]);

    if($api_key == $api_key_value) {
        $MOV_VALUE1 = test_input($_POST["MOV_VALUE1"]);
        $AMB_ID = test_input($_POST["AMB_ID"]);
        
        // Create connection
        $conn = new mysqli($servername, $username, $password, $dbname);
        // Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        } 
        
        $sql2 = "SELECT CAS_SENSOR_LIGADO FROM CASA";

        if ($result2 = $conn->query($sql2)) {
            $row2 = $result2->fetch_assoc();
            $row_sensor_ligado = $row2["CAS_SENSOR_LIGADO"];
        }

        if($row_sensor_ligado == 1){
            $sql = "INSERT INTO DETECCOES_MOVIMENTO (MOV_VALUE1, AMB_ID)
            VALUES ('" . $MOV_VALUE1 . "', '" . $AMB_ID . "')";
            
            if ($conn->query($sql) === TRUE) {
                echo "New record created successfully";
            } 
            else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
    
        $conn->close();
    }
    else {
        echo "Wrong API Key provided.";
    }

}
else {
    echo "No data posted with HTTP POST.";
}

function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}