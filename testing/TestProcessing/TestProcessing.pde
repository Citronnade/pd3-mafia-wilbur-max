import g4p_controls.*;

GTextField text;
GTextArea area;

public void setup(){
    size (600,440);
    text = new GTextField(this,4,126,220,30);
    area = new GTextArea(this,4,24,220,96);
}

public void draw(){
  
}

public void handleTextEvents(GEditableTextControl textcontrol, GEvent event){
  if (textcontrol == text){
     area.setText(text.getText()); 
  }
}
