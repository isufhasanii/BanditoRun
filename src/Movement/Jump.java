package Movement;

public class Jump extends Thread{


    public static boolean fertig = true;
    static boolean hochpunkt = false;

    int jumpheight = 85;
    public static int originY = 235;
    public static int JumpPosition = originY;

    public Jump(){


    }

    public void run(){

        fertig = false;
        int delay = 3;

        while (fertig == false){
            Jump();

            try {
                Thread.sleep(delay);
            }catch (Exception e){
            }
        }

        hochpunkt = false;
    }
    public void Jump(){
        if (hochpunkt == false){
            JumpPosition--;
        }
        if (JumpPosition == (originY - jumpheight)){
            hochpunkt = true;
        }
        if (hochpunkt == true && JumpPosition <= originY){
            JumpPosition ++;
            if (JumpPosition == originY){
                fertig = true;
            }
        }
    }
}
