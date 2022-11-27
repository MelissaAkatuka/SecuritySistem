// Bibliotecas para Inclusão do Wifi e HTTP Request pelo ESP 
#ifdef ARDUINO_ARCH_ESP32
  #include <WiFi.h>
  #include <HTTPClient.h>
#else
  #include <ESP8266WiFi.h>
  #include <ESP8266HTTPClient.h>
  #include <WiFiClient.h>
#endif

// Credenciais da Rede Wifi
const char* ssid = "Shadowhunter-2.4G";
const char* password = "AmrenMor@22";

// Variáveis Globais para Conexão ao Wifi e ao HTTP
boolean wifiConnected = false;
WiFiClient clientWifi;
String httpRequestData;
const int  port = 80;  
unsigned long timeout;

// Variáveis para Conexão ao serviço HTTP
const char server[] = "breno.mktstudio.com.br";           // Domínio: example.com, maker.ifttt.com, etc
const char resource[] = "/tcc-melissa/post-esp-data.php"; // Caminho: /post-data.php

// API Key é uma chave para manter compatibilidade com o serviço utilizado para garantir que ele tem permissão de conexão
// Esta mesma chave deve ser validada no Serviço utilizado
String apiKeyValue = "tPmAT5Ab3j7F9";

//variables for the ESP
int motionSensor1 = 2;
int motionSensor2 = 34;
int led = 12;

int lastMovement1 = 0;
int lastMovement2 = 0;

void turnOnLEDAndPIR()
{
pinMode(motionSensor1, INPUT);
pinMode(motionSensor2, INPUT);
pinMode(led, OUTPUT);
}

//Função connectWifihanged(): Controla conexão Wifi
boolean connectWifi()
{
  boolean state = true;
  int i = 0;

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("");
  Serial.println("Conectando ao Wifi...");

  // Wait for connection
  Serial.print("Conectando...");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
    if (i > 20) {
      state = false; break;
    }
    i++;
  }
  Serial.println("");
  if (state) {
    Serial.print("Conectado ao ");
    Serial.println(ssid);
    Serial.print("Endereço IP: ");
    Serial.println(WiFi.localIP());
  }else {
    Serial.println("Falha de Conexão ao Wifi.");
  }
  return state;
}

// Função connectHTTPServer(): Realiza a Conexão ao Servidor que será utilizado para Requisição HTTP
void connectHTTPServer() {
  Serial.println();
  Serial.println("/********************/");
  Serial.print("Conectando ao Servidor Web: ");
  Serial.print(server);
  Serial.println();

  if (!clientWifi.connect(server, port)) {
    Serial.println("Falha na Conexão ao Servidor Web.....");
  }else{
    Serial.println("Conectado ao Servidor Web....");
  }
  Serial.println("/********************/");
}

// Função doPostRequisition(): Realiza a requisição HTTP POST passando os parâmetros necessários ao serviço
void doPostRequisition(void) {
  connectHTTPServer();
  Serial.println("Realizando a requisicao HTTP POST...");
  Serial.print("httpRequestData = ");
  Serial.println(httpRequestData);
  Serial.println();  

  // Realizando a Requisiçao HTTP POST pela Rede Wifi
  clientWifi.print(String("POST ") + resource + " HTTP/1.1\r\n");
  clientWifi.print(String("Host: ") + server + "\r\n");
  clientWifi.println("Connection: close");
  clientWifi.println("Content-Type: application/x-www-form-urlencoded; charset=UTF-8");
  clientWifi.print("Content-Length: ");
  clientWifi.println(httpRequestData.length());
  clientWifi.println();
  clientWifi.println(httpRequestData);
  
  while (clientWifi.connected() && millis() - timeout < 2000L) {
    // Print available data (HTTP response from server)
    while (clientWifi.available()) {
      char c = clientWifi.read();
      Serial.print(c);
      timeout = millis();
    }
  }
}

void setup() {
  Serial.begin(115200);
  
  turnOnLEDAndPIR();
  
  // Conexão Wifi
  wifiConnected = connectWifi();

  if (!wifiConnected)
  {
    while (1)
    {
      Serial.println("Não é possóvel conectar ao Wifi. Por favor, verifique os dados e reinicie o ESP.");
      delay(2500);
    }
  }
}

void loop() {

  lastMovement1 = digitalRead(motionSensor1); 
  lastMovement2 = digitalRead(motionSensor2);

  if(lastMovement1 == HIGH && wifiConnected) {
     Serial.println("Motion detected!!! (Sensor 1)");
     digitalWrite(led, HIGH);

     if(wifiConnected){
      httpRequestData = "api_key=" + apiKeyValue + "&AMB_ID=2" + "&MOV_VALUE1=OK";
      doPostRequisition();
      delay(10000);
      }   
  } else if(lastMovement2 == HIGH && wifiConnected) {
     Serial.println("Motion detected!!! (Sensor 2)");
     digitalWrite(led, HIGH);

     if(wifiConnected){
      httpRequestData = "api_key=" + apiKeyValue + "&AMB_ID=34" + "&MOV_VALUE1=OK";
      doPostRequisition();
      delay(10000);
      }   
  } else {
     Serial.println("Motion stopped...");
     digitalWrite(led, LOW);
  }
}  
