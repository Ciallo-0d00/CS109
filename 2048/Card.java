import java.awt.*;

public class Card {

    private int x=0;
    private int y=0;
    private int kuan=82;
    private int gao=82;
    private int i=0;
    private int j=0;

    private int zpyx=0;
    private int zpyy=0;
    private int num=0;
    private boolean hbglm=false;

    public Card(int i, int j){
        this.i=i;
        this.j=j;
        cal();
    }


    public void cal(){
        x=24+90*j;
        y=25+90*i;
    }

    public Color getColor(){
        switch (num){
            case 2:
                Color c1=new Color(100,220,210,160);
                return c1;

            case 4:
                Color c2=new Color(160,220,111,125);
                return c2;

            case 8:
                Color c3=new Color(225,225,111,140);
                return c3;

            case 16:
                Color c4=new Color(225,225,111,155);
                return c4;

            case 32:
                Color c5=new Color(225,225,111,170);
                return c5;

            case 64:
                return new Color(250,150,111,185);

            case 128:
                Color c7=new Color(225,130,80,200);
                return c7;

            case 256:
                Color c8=new Color(200,90,70,215);
                return c8;

            case 512:
                Color c9=new Color(225,90,60,230);
                return c9;

            case 1024:
                Color c10=new Color(225,90,80,240);
                return c10;

            case 2048:
                Color c11=new Color(225,20,90,250);
                return c11;

            default:
                Color c0=new Color(225,225,225,110);
                return c0;


        }
    }


    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRoundRect(x,y,kuan,gao,10,10);

        if(num!=0){
            g.setColor(new Color(255,255,255));
            String zifu=Integer.toString(num);
            Font ff=new Font("Times New Roman",Font.BOLD,25);
            g.setFont(ff);
            int w=getWide(ff,zifu,g);
            zpyx=x+(kuan-w)/2;
            zpyy=y+48;
            g.drawString(zifu,zpyx,zpyy);
        }
    }

    public static int getWide(Font font,String tx,Graphics g){
        FontMetrics fm=g.getFontMetrics(font);
        int w=0;
        for(int i=0;i<tx.length();i++){
            w=w+fm.charWidth(tx.charAt(i));
        }
        return w;
    }
    public void sethbglm(boolean b) {
        this.hbglm=b;
    }

    public void setnum(int num) {
        this.num=num;
    }

    public int getnum() {
        return num;
    }

    public boolean cU(Card[][] cards, boolean b) {
        if(i==0){
            return false;
        }
        Card syg=cards[i-1][j];
        if (syg.getnum()==0){
            if(b){ syg.num=this.num;
                this.num=0;
                syg.cU(cards, b);}
            return true;
        }else if(syg.getnum()==num && !syg.hbglm){
            if(b){ syg.hbglm=true;
                syg.setnum(this.getnum()*2);
                this.num=0;}
            return true;
        }else {
            return false;
        }
    }

    public boolean cR(Card[][] cards, boolean b) {
        if(j==3){
            return false;
        }
        Card yyg =cards[i][j+1];
        if (yyg.getnum()==0){
            if(b){
                yyg.num=this.num;
                this.num=0;
                yyg.cR(cards, b);}
            return true;
        }else if(yyg.getnum()==num && !yyg.hbglm){
            if(b){ yyg.hbglm=true;
                yyg.setnum(this.getnum()*2);
                this.num=0;}
            return true;
        }else {return false;}
    }

    public boolean cL(Card[][] cards, boolean b) {
        if(j==0){
            return false ;
        }

        Card zyg =cards[i][j-1];
        if (zyg.getnum()==0){
            if(b){zyg.num=this.num;
                this.num=0;
                zyg.cL(cards, b); }
            return true;
        }else if(zyg.getnum()==num && !zyg.hbglm){
            if(b){zyg.hbglm=true;
                zyg.setnum(this.getnum()*2);
                this.num=0;}
            return true;
        }else {return false;}
    }

    public boolean cD(Card[][] cards, boolean b) {
        if(i==3){
            return false;
        }
        Card xyg =cards[i+1][j];
        if (xyg.getnum()==0){
            if(b){xyg.num=this.num;
                this.num=0;
                xyg.cD(cards, b);}
            return true;
        }else if(xyg.getnum()==num && !xyg.hbglm){
            if(b){
                xyg.hbglm=true;
                xyg.setnum(this.getnum()*2);
                this.num=0;}
            return true;
        }else {return false;}
    }
}


