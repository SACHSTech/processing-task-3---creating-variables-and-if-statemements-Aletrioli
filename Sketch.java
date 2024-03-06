import processing.core.PApplet;
import processing.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sketch extends PApplet {
	
  // create intHeight and intWidth variables
  int intHeight;
  int intWidth;
  double dblRandWidth;
  double dblRandHeight;
  double dblRandValue;
  Random myRand = new Random();
  boolean boolMouseClicked = false;
  double dblGravity;
  boolean boolGravity = false;

  public void settings() {
    // set dblRandValue of intHeight and intWidth variables
    intHeight = 400;
    intWidth = 400;
    dblRandWidth = intWidth / 2 * myRand.nextDouble(1);
    dblRandHeight = intHeight / 4 * myRand.nextDouble(1);
    dblRandValue = myRand.nextDouble(1);
    if (dblRandValue > 0.5){
      dblRandWidth = dblRandWidth * -1;
    }
    
    size(intWidth, intHeight);
  }

  public void setup() {
    if(dblRandValue > 0.5){
      background(13, 46, 79);
    } else {
      background(127, 204, 240);
    }
    
  }
  
  // while mouse is dragged, move house
  public void mouseDragged(MouseEvent e) {
    boolMouseClicked = true;
    dblRandWidth += mouseX - pmouseX;
    dblRandHeight += mouseY - pmouseY;
  }

  // when mouse is released, begin to fall
  public void mouseReleased(MouseEvent e) {
    if(boolMouseClicked == true){
      boolMouseClicked = false;
      boolGravity = true;
      if(dblRandHeight < 40);{
        dblGravity = -2.5;
      }
    }
  }

  public void draw() {
    clear();

    // gravity
    if(boolGravity == true){
      dblGravity += 0.25;
      dblRandHeight += dblGravity;
      try {
        TimeUnit.MILLISECONDS.sleep(1);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
    }
    if(dblRandHeight >= 40 || boolMouseClicked == true){
      boolGravity = false;
    }

    // background
    if(dblRandValue > 0.5){
      background(13, 46, 79);
    } else {
      background(127, 204, 240);
    }

    // hill
    fill(133, 214, 133);
    ellipse(intWidth / 4, intHeight, (float)(intWidth * 1.75), (float)(intHeight * 0.875));
	  
    // sun
    if(dblRandValue > 0.5){
      fill(255, 255, 255);
    } else {
      fill(247, 246, 168);
    }
    ellipse((float)(intWidth * 0.8125), (float)(intHeight * 0.1875), intWidth / 4, intHeight / 4);
  
    // clock
    fill(0);
    text(minute() + ":", (float)(intWidth * 0.8125) - (float)(intWidth*0.015), (float)(intHeight * 0.1875) + (float)(intHeight*0.01));
    if(hour() >= 10){
      text(hour() + ":", (float)(intWidth * 0.8125) - (float)(intWidth*0.058), (float)(intHeight * 0.1875) + (float)(intHeight*0.01));
    } else {
      text(hour() + ":", (float)(intWidth * 0.8125) - (float)(intWidth*0.045), (float)(intHeight * 0.1875) + (float)(intHeight*0.01));
    }
    text(second(), (float)(intWidth * 0.8125) + (float)(intWidth*0.0275), (float)(intHeight * 0.1875) + (float)(intHeight*0.01));

    // house
    fill(97, 81, 57);
    rect((float)dblRandWidth + intWidth / 4, (float)dblRandHeight + intHeight / 2, intWidth / 4, (float)(intHeight * 0.1875));

    // windows
    fill(165, 227, 242);
    rect((float)dblRandWidth + (float)(intWidth * 0.275), (float)dblRandHeight + (float)(intHeight * 0.5625), (float)(intWidth * 0.0625), (float)(intHeight * 0.0625));
    rect((float)dblRandWidth + (float)(intWidth * 0.4125), (float)dblRandHeight + (float)(intHeight * 0.5625), (float)(intWidth * 0.0625), (float)(intHeight * 0.0625));

    // window lines
    fill(0, 0, 0);
    line((float)dblRandWidth + (float)(intWidth * 0.275), (float)dblRandHeight + (float)(intHeight * 0.5625), (float)dblRandWidth + (float)(intWidth * 0.3375), (float)dblRandHeight + (float)(intHeight * 0.625));
    line((float)dblRandWidth + (float)(intWidth * 0.275), (float)dblRandHeight + (float)(intHeight * 0.625), (float)dblRandWidth + (float)(intWidth * 0.3375), (float)dblRandHeight + (float)(intHeight * 0.5625));
    line((float)dblRandWidth + (float)(intWidth * 0.4125), (float)dblRandHeight + (float)(intHeight * 0.5625), (float)dblRandWidth + (float)(intWidth * 0.475), (float)dblRandHeight + (float)(intHeight * 0.625));
    line((float)dblRandWidth + (float)(intWidth * 0.4125), (float)dblRandHeight + (float)(intHeight * 0.625), (float)dblRandWidth + (float)(intWidth * 0.475), (float)dblRandHeight + (float)(intHeight * 0.5625));

    // door
    fill(128, 114, 84);
    rect((float)dblRandWidth + (float)(intWidth * 0.35), (float)dblRandHeight + (float)(intHeight * 0.5625), (float)(intWidth * 0.05), (float)(intHeight * 0.125));

    // roof
    fill(69, 64, 53);
    triangle((float)dblRandWidth + intWidth / 4, (float)dblRandHeight + intHeight / 2, (float)dblRandWidth + (float)(intWidth * 0.375), (float)dblRandHeight + (float)(intHeight * 0.375), (float)dblRandWidth + intWidth / 2, (float)dblRandHeight + intHeight / 2);
  } 
}