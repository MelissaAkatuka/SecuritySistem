<!DOCTYPE html>
<html>
  <body>
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

    // Database name
    $dbname = "mktstu21_breno";
    // Database user
    $username = "mktstu21_breno";
    // Database user password
    $password = "Y4J[OB,znVZ]";

    // If the sensor is active, saves data from ESP32 in the database
    
      //Another way to compare, if the above is equal to 0 means the two strings match perfectly
      //if(strncmp('1', $sql2) == 0)

      // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    } 

    $sql = "SELECT MOV_ID, MOV_VALUE1, MOV_ULTIMA_DETECCAO, AMB_ID FROM DETECCOES_MOVIMENTO ORDER BY id DESC";

    echo '<table cellspacing="5" cellpadding="5">
            <tr> 
              <td>ID</td> 
              <td>VALUE 1</td> 
              <td>ULTIMA_DETECCAO</td> 
              <td>AMB_ID</td>
            </tr>';
      
      if ($result = $conn->query($sql)) {
          while ($row = $result->fetch_assoc()) {
              $row_id = $row["id"];
              $row_value1 = $row["MOV_VALUE1"];
              $row_reading_time = $row["MOV_ULTIMA_DETECCAO"];
              $row_space = $row["AMB_ID"]; 
              // Uncomment to set timezone to - 1 hour (you can change 1 to any number)
              //$row_reading_time = date("Y-m-d H:i:s", strtotime("$row_reading_time - 1 hours"));
            
              // Uncomment to set timezone to + 4 hours (you can change 4 to any number)
              //$row_reading_time = date("Y-m-d H:i:s", strtotime("$row_reading_time + 4 hours"));
            
              echo '<tr> 
                      <td>' . $row_id . '</td> 
                      <td>' . $row_value1 . '</td> 
                      <td>' . $row_reading_time . '</td> 
                      <td>' . $row_space . '</td> 
                    </tr>';
          }
          $result->free();
      }

      $conn->close();
      ?> 
    </table>
  </body>
</html>