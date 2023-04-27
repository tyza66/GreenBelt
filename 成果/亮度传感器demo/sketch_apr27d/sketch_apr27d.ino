//光照强度传感器控制台实时显示demo By:tyza66
int a=0; 
void setup() {
  pinMode(A0,INPUT);
  Serial.begin(9600);
}

void loop() {
  float data=analogRead(A0);  //这个引脚会获得经过土壤湿度传感器之后的电位 这个电位会随着土壤湿度而变化
  a += 1;
  if(a==10000){
    Serial.println(data);
    a = 0;
  }
}

