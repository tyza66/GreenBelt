#include <OneWire.h>
#include <DallasTemperature.h>

// 初始连接在单总线上的单总线设备
OneWire oneWire(D2);
DallasTemperature sensors(&oneWire);
void setup() {
 // 设置串口通信波特率
  Serial.begin(9600);
  Serial.println("Dallas Temperature IC Control Library Demo");
  // 初始库
  sensors.begin();
}

void loop() {
Serial.print("Requesting temperatures...");
  sensors.requestTemperatures(); // 发送命令获取温度
  Serial.println("DONE");
  
  Serial.print("Temperature for the device 1 (index 0) is: ");
  Serial.println(sensors.getTempCByIndex(0));
  delay(500);  
}
