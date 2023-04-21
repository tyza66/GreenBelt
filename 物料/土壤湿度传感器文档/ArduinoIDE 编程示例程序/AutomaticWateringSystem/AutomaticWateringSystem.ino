/***********************************************************************
 *       __                                                          _
 *      / /        _____  __    __  _          _   (_)   ________   | |
 *     / /____   / _____) \ \  / / | |   __   | |  | |  (  ______)  | |_____
 *    / / ___/  | |_____   \ \/ /  | |  /  \  | |  | |  | |______   |  ___  |
 *   / /\ \     | |_____|   \  /   | | / /\ \ | |  | |  (_______ )  | |   | |
 *  / /  \ \__  | |_____    / /    | |/ /  \ \| |  | |   ______| |  | |   | |
 * /_/    \___\  \______)  /_/      \__/    \__/   |_|  (________)  |_|   |_|
 *
 *
 * KeyWay Tech firmware
 *
 * Copyright (C) 2015-2020
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, in version 3.
 * learn more you can see <http://www.gnu.org/licenses/>.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

#include <Wire.h> 
#include "LCD.h" 
#include "LiquidCrystal_I2C.h"
int analogPin=A0;
int WaterPumpPin=8;
float i=0;
float j=0;
LiquidCrystal_I2C lcd(0x27,2,1,0,4,5,6,7); // 0x27 is the I2C bus address for an unmodified backpack 
void setup() 
{ // activate LCD module 
  lcd.begin (16,2); // for 16 x 2 LCD module 
  lcd.setBacklightPin(3,POSITIVE); 
  lcd.setBacklight(HIGH); 
  //这个引脚就是我们读取土壤湿度传感器的I2C信息桥
  pinMode(analogPin,INPUT);

  pinMode(WaterPumpPin,OUTPUT);
  digitalWrite(WaterPumpPin,LOW);
  Serial.begin(9600);
} 

void loop() {
    float data=analogRead(analogPin);  //这个引脚会获得经过土壤湿度传感器之后的电位 这个电位会随着土壤湿度而变化
      Serial.println(data);
    i=data/1023;
    j=(1-i)*100;
    lcd.setCursor(0, 0);
    lcd.print("The hum is: ");
    // set the cursor to column 0, line 1
    // (note: line 1 is the second row, since counting begins with 0):
    lcd.setCursor(0, 1);
    // print the number of seconds since reset:
    lcd.print((float)j, 2);
    lcd.print("%");
    delay(200);
    if(data>800)
    {
      digitalWrite(WaterPumpPin,HIGH);
     }
     else
     {
       digitalWrite(WaterPumpPin,LOW);
      }
}
