package dpark.objects;

import dpark.Game;
import dpark.GameObject;

public class Crate extends GameObject {
	boolean STOP = true;
	public static int xa1;
	public static int ya1;
    public int xa2;
    public int ya2;
    public int xa3;
    public int ya3;
    public int xa4;
    public int ya4;
    public int xa5;
    public int ya5;
    public static int[] myx1 = {xa1-16, xa1-15, xa1-14, xa1-13, xa1-12, xa1-11, xa1-10, xa1-9, xa1-8, xa1-7, xa1-6, xa1+16, xa1+15, xa1+14, xa1+13, xa1+12, xa1+11, xa1+10, xa1+9, xa1+8, xa1+7, xa1+6};

    public  static int[] myy1 = {ya1-16, ya1-15, ya1-14, ya1-13, ya1-12, ya1-11, ya1-10, ya1-9, ya1-8, ya1-7, ya1-6, ya1+16, ya1+15, ya1+14, ya1+13, ya1+12, ya1+11, ya1+10, ya1+9, ya1+8, ya1+7, ya1+6};

    public int g = 0;
	public int x_puse;
	public int y_puse;
	private int h = 1;
    public int playeris;
    public int[] u = { 15, 24, 52 };
    int e = 2;
	public Crate(String name) {
		super(name);
		z = 0;
		



		
		
		
		sprite.addStep(Game.instance.getSprite("Blockstone.png"));
	    
	}
	@Override
	public void update() {
		super.update();


        if (xa1 == plx && ya1 == ply)
        {
            Player.Collision();
        }
        if (xa1+16 == plx && ya1+16 == ply)
        {
                 Player.Collision();
        }
        if (xa1-16 == plx && ya1-16 == ply)
        {
            Player.Collision();
        }
        if (xa1-16 == plx && ya1+16 == ply)
        {
            Player.Collision();
        }
        if (xa1+16 == plx && ya1-16 == ply)
        {
            Player.Collision();
        }



        if (xa1 == plx && ya1 == ply)
        {
            Player.Collision();
        }
        if (xa1+17 == plx && ya1+17 == ply)
        {
            Player.Collision();
        }
        if (xa1-17 == plx && ya1-17 == ply)
        {
            Player.Collision();
        }
        if (xa1-17 == plx && ya1+17 == ply)
        {
            Player.Collision();
        }
        if (xa1+17 == plx && ya1-17 == ply)
        {
            Player.Collision();
        }



        if (xa1 == plx && ya1 == ply)
        {
            Player.Collision();
        }
        if (xa1+15 == plx && ya1+15 == ply)
        {
            Player.Collision();
        }
        if (xa1-15 == plx && ya1-15 == ply)
        {
            Player.Collision();
        }
        if (xa1-15 == plx && ya1+15 == ply)
        {
            Player.Collision();
        }
        if (xa1+15 == plx && ya1-15 == ply)
        {
            Player.Collision();
        }


        if (xa1 == plx1 && ya1 == ply1)
        {
            Player.Collision();
        }
        if (xa1+16 == plx1 && ya1+16 == ply1)
        {
            Player.Collision();
        }
        if (xa1-16 == plx1 && ya1-16 == ply1)
        {
            Player.Collision();
        }
        if (xa1-16 == plx1 && ya1+16 == ply1)
        {
            Player.Collision();
        }
        if (xa1+16 == plx1 && ya1-16 == ply1)
        {
            Player.Collision();
        }



        if (xa1 == plx1 && ya1 == ply1)
        {
            Player.Collision();
        }
        if (xa1+17 == plx1 && ya1+17 == ply1)
        {
            Player.Collision();
        }
        if (xa1-17 == plx1 && ya1-17 == ply1)
        {
            Player.Collision();
        }
        if (xa1-17 == plx1 && ya1+17 == ply1)
        {
            Player.Collision();
        }
        if (xa1+17 == plx1 && ya1-17 == ply1)
        {
            Player.Collision();
        }




        if (xa1 == plx1 && ya1 == ply1)
        {
            Player.Collision();
        }
        if (xa1+18 == plx1 && ya1+18 == ply1)
        {
            Player.Collision();
        }
        if (xa1-18 == plx1 && ya1-18 == ply1)
        {
            Player.Collision();
        }
        if (xa1-18 == plx1 && ya1+18 == ply1)
        {
            Player.Collision();
        }
        if (xa1+18 == plx1 && ya1-18 == ply1)
        {
            Player.Collision();
        }




        if (xa1 == plx2 && ya1 == ply2)
        {
            Player.Collision();
        }
        if (xa1+16 == plx2 && ya1+16 == ply2)
        {
            Player.Collision();
        }
        if (xa1-16 == plx2 && ya1-16 == ply2)
        {
            Player.Collision();
        }
        if (xa1-16 == plx2 && ya1+16 == ply2)
        {
            Player.Collision();
        }
        if (xa1+16 == plx2 && ya1-16 == ply2)
        {
            Player.Collision();
        }




        if (xa1 == plx3 && ya1 == ply3)
        {
            Player.Collision();
        }
        if (xa1+16 == plx3 && ya1+16 == ply3)
        {
            Player.Collision();
        }
        if (xa1-16 == plx3 && ya1-16 == ply3)
        {
            Player.Collision();
        }
        if (xa1-16 == plx3 && ya1+16 == ply3)
        {
            Player.Collision();
        }
        if (xa1+16 == plx3 && ya1-16 == ply3)
        {
            Player.Collision();
        }



        if (xa1 == plx4 && ya1 == ply4)
        {
            Player.Collision();
        }
        if (xa1+16 == plx4 && ya1+16 == ply4)
        {
            Player.Collision();
        }
        if (xa1-16 == plx4 && ya1-16 == ply4)
        {
            Player.Collision();
        }
        if (xa1-16 == plx4 && ya1+16 == ply4)
        {
            Player.Collision();
        }
        if (xa1+16 == plx4 && ya1-16 == ply4)
        {
            Player.Collision();
        }


        if (xa1 == plx5 && ya1 == ply5)
        {
            Player.Collision();
        }
        if (xa1+16 == plx5 && ya1+16 == ply5)
        {
            Player.Collision();
        }
        if (xa1-16 == plx5 && ya1-16 == ply5)
        {
            Player.Collision();
        }
        if (xa1-16 == plx5 && ya1+16 == ply5)
        {
            Player.Collision();
        }
        if (xa1+16 == plx5 && ya1-16 == ply5)
        {
            Player.Collision();
        }




        if (xa1 == plx6 && ya1 == ply6)
        {
            Player.Collision();
        }
        if (xa1+16 == plx6 && ya1+16 == ply6)
        {
            Player.Collision();
        }
        if (xa1-16 == plx6 && ya1-16 == ply6)
        {
            Player.Collision();
        }
        if (xa1-16 == plx6 && ya1+16 == ply6)
        {
            Player.Collision();
        }
        if (xa1+16 == plx6 && ya1-16 == ply6)
        {
            Player.Collision();
        }


        if (xa1 == plx7 && ya1 == ply7)
        {
            Player.Collision();
        }
        if (xa1+16 == plx7 && ya1+16 == ply7)
        {
            Player.Collision();
        }
        if (xa1-16 == plx7 && ya1-16 == ply7)
        {
            Player.Collision();
        }
        if (xa1-16 == plx7 && ya1+16 == ply7)
        {
            Player.Collision();
        }
        if (xa1+16 == plx7 && ya1-16 == ply7)
        {
            Player.Collision();
        }



        if (xa1 == plx8 && ya1 == ply8)
        {
            Player.Collision();
        }
        if (xa1+16 == plx8 && ya1+16 == ply8)
        {
            Player.Collision();
        }
        if (xa1-16 == plx8 && ya1-16 == ply8)
        {
            Player.Collision();
        }
        if (xa1-16 == plx8 && ya1+16 == ply8)
        {
            Player.Collision();
        }
        if (xa1+16 == plx8 && ya1-16 == ply8)
        {
            Player.Collision();
        }



        if (xa1 == plx9 && ya1 == ply9)
        {
            Player.Collision();
        }
        if (xa1+16 == plx9 && ya1+16 == ply9)
        {
            Player.Collision();
        }
        if (xa1-16 == plx9 && ya1-16 == ply9)
        {
            Player.Collision();
        }
        if (xa1-16 == plx9 && ya1+16 == ply9)
        {
            Player.Collision();
        }
        if (xa1+16 == plx9 && ya1-16 == ply9)
        {
            Player.Collision();
        }




        if (xa1 == plx10 && ya1 == ply10)
        {
            Player.Collision();
        }
        if (xa1+16 == plx10 && ya1+16 == ply10)
        {
            Player.Collision();
        }
        if (xa1-16 == plx10 && ya1-16 == ply10)
        {
            Player.Collision();
        }
        if (xa1-16 == plx10 && ya1+16 == ply10)
        {
            Player.Collision();
        }
        if (xa1+16 == plx10 && ya1-16 == ply10)
        {
            Player.Collision();
        }



        if (xa1 == plx11 && ya1 == ply11)
        {
            Player.Collision();
        }
        if (xa1+16 == plx11 && ya1+16 == ply11)
        {
            Player.Collision();
        }
        if (xa1-16 == plx11 && ya1-16 == ply11)
        {
            Player.Collision();
        }
        if (xa1-16 == plx11 && ya1+16 == ply11)
        {
            Player.Collision();
        }
        if (xa1+16 == plx11 && ya1-16 == ply11)
        {
            Player.Collision();
        }




        if (xa1 == plx12 && ya1 == ply12)
        {
            Player.Collision();
        }
        if (xa1+16 == plx12 && ya1+16 == ply12)
        {
            Player.Collision();
        }
        if (xa1-16 == plx12 && ya1-16 == ply12)
        {
            Player.Collision();
        }
        if (xa1-16 == plx12 && ya1+16 == ply12)
        {
            Player.Collision();
        }
        if (xa1+16 == plx12 && ya1-16 == ply12)
        {
            Player.Collision();
        }


        if (xa1 == plx13 && ya1 == ply13)
        {
            Player.Collision();
        }
        if (xa1+16 == plx13 && ya1+16 == ply13)
        {
            Player.Collision();
        }
        if (xa1-16 == plx13 && ya1-16 == ply13)
        {
            Player.Collision();
        }
        if (xa1-16 == plx13 && ya1+16 == ply13)
        {
            Player.Collision();
        }
        if (xa1+16 == plx13 && ya1-16 == ply13)
        {
            Player.Collision();
        }





        if (xa1 == plx14 && ya1 == ply14)
        {
            Player.Collision();
        }
        if (xa1+16 == plx14 && ya1+16 == ply14)
        {
            Player.Collision();
        }
        if (xa1-16 == plx14 && ya1-16 == ply14)
        {
            Player.Collision();
        }
        if (xa1-16 == plx14 && ya1+16 == ply14)
        {
            Player.Collision();
        }
        if (xa1+16 == plx14 && ya1-16 == ply14)
        {
            Player.Collision();
        }




        if (xa1 == plx15 && ya1 == ply15)
        {
            Player.Collision();
        }
        if (xa1+16 == plx15 && ya1+16 == ply15)
        {
            Player.Collision();
        }
        if (xa1-16 == plx15 && ya1-16 == ply15)
        {
            Player.Collision();
        }
        if (xa1-16 == plx15 && ya1+16 == ply15)
        {
            Player.Collision();
        }
        if (xa1+16 == plx15 && ya1-16 == ply15)
        {
            Player.Collision();
        }



        if (xa1 == plx16 && ya1 == ply16)
        {
            Player.Collision();
        }
        if (xa1+16 == plx16 && ya1+16 == ply16)
        {
            Player.Collision();
        }
        if (xa1-16 == plx16 && ya1-16 == ply16)
        {
            Player.Collision();
        }
        if (xa1-16 == plx16 && ya1+16 == ply16)
        {
            Player.Collision();
        }
        if (xa1+16 == plx16 && ya1-16 == ply16)
        {
            Player.Collision();
        }





        if (xa1 == plx17 && ya1 == ply17)
        {
            Player.Collision();
        }
        if (xa1+16 == plx17 && ya1+16 == ply17)
        {
            Player.Collision();
        }
        if (xa1-16 == plx17 && ya1-16 == ply17)
        {
            Player.Collision();
        }
        if (xa1-16 == plx17 && ya1+16 == ply17)
        {
            Player.Collision();
        }
        if (xa1+16 == plx17 && ya1-16 == ply17)
        {
            Player.Collision();
        }





        if (xa1 == plx18 && ya1 == ply18)
        {
            Player.Collision();
        }
        if (xa1+16 == plx18 && ya1+16 == ply18)
        {
            Player.Collision();
        }
        if (xa1-16 == plx18 && ya1-16 == ply18)
        {
            Player.Collision();
        }
        if (xa1-16 == plx18 && ya1+16 == ply18)
        {
            Player.Collision();
        }
        if (xa1+16 == plx18 && ya1-16 == ply18)
        {
            Player.Collision();
        }


        if (xa1 == plx19 && ya1 == ply19)
        {
            Player.Collision();
        }
        if (xa1+16 == plx19 && ya1+16 == ply19)
        {
            Player.Collision();
        }
        if (xa1-16 == plx19 && ya1-16 == ply19)
        {
            Player.Collision();
        }
        if (xa1-16 == plx19 && ya1+16 == ply19)
        {
            Player.Collision();
        }
        if (xa1+16 == plx19 && ya1-16 == ply19)
        {
            Player.Collision();
        }



        if (xa1 == plx20 && ya1 == ply20)
        {
            Player.Collision();
        }
        if (xa1+16 == plx20 && ya1+16 == ply20)
        {
            Player.Collision();
        }
        if (xa1-16 == plx20 && ya1-16 == ply20)
        {
            Player.Collision();
        }
        if (xa1-16 == plx20 && ya1+16 == ply20)
        {
            Player.Collision();
        }
        if (xa1+16 == plx20 && ya1-16 == ply20)
        {
            Player.Collision();
        }










        if (xa1 == plx21 && ya1 == ply21)
        {
            Player.Collision();
        }
            if (xa1+16 == plx21 && ya1+16 == ply21)
            {
                Player.Collision();
            }
            if (xa1-16 == plx21 && ya1-16 == ply21)
            {
                Player.Collision();
            }
            if (xa1-16 == plx21 && ya1+16 == ply21)
            {
                Player.Collision();
            }
            if (xa1+16 == plx21 && ya1-16 == ply21)
            {
                Player.Collision();
            }



            if (xa1 == plx22 && ya1 == ply22)
            {
                Player.Collision();
            }
            if (xa1+16 == plx22 && ya1+16 == ply22)
            {
                Player.Collision();
            }
            if (xa1-16 == plx22 && ya1-16 == ply22)
            {
                Player.Collision();
            }
            if (xa1-16 == plx22 && ya1+16 == ply22)
            {
                Player.Collision();
            }
            if (xa1+16 == plx22 && ya1-16 == ply22)
            {
                Player.Collision();
        }


        if (xa1 == plx23 && ya1 == ply23)
        {
            Player.Collision();
        }
        if (xa1+16 == plx23 && ya1+16 == ply23)
        {
            Player.Collision();
        }
        if (xa1-16 == plx23 && ya1-16 == ply23)
        {
            Player.Collision();
        }
        if (xa1-16 == plx23 && ya1+16 == ply23)
        {
            Player.Collision();
        }
        if (xa1+16 == plx23 && ya1-16 == ply23)
        {
            Player.Collision();
        }



        if (xa1 == plx24 && ya1 == ply24)
        {
            Player.Collision();
        }
        if (xa1+16 == plx24 && ya1+16 == ply24)
        {
            Player.Collision();
        }
        if (xa1-16 == plx24 && ya1-16 == ply24)
        {
            Player.Collision();
        }
        if (xa1-16 == plx24 && ya1+16 == ply24)
        {
            Player.Collision();
        }
        if (xa1+16 == plx24 && ya1-16 == ply24)
        {
            Player.Collision();
        }



        if (xa1 == plx25 && ya1 == ply25)
        {
            Player.Collision();
        }
        if (xa1+16 == plx25 && ya1+16 == ply25)
        {
            Player.Collision();
        }
        if (xa1-16 == plx25 && ya1-16 == ply25)
        {
            Player.Collision();
        }
        if (xa1-16 == plx25 && ya1+16 == ply25)
        {
            Player.Collision();
        }
        if (xa1+16 == plx25 && ya1-16 == ply25)
        {
            Player.Collision();
        }



        if (xa1 == plx26 && ya1 == ply26)
        {
            Player.Collision();
        }
        if (xa1+16 == plx26 && ya1+16 == ply26)
        {
            Player.Collision();
        }
        if (xa1-16 == plx26 && ya1-16 == ply26)
        {
            Player.Collision();
        }
        if (xa1-16 == plx26 && ya1+16 == ply26)
        {
            Player.Collision();
        }
        if (xa1+16 == plx26 && ya1-16 == ply26)
        {
            Player.Collision();
        }





        if (xa1 == plx27 && ya1 == ply27)
        {
            Player.Collision();
        }
        if (xa1+16 == plx27 && ya1+16 == ply27)
        {
            Player.Collision();
        }
        if (xa1-16 == plx27 && ya1-16 == ply27)
        {
            Player.Collision();
        }
        if (xa1-16 == plx27 && ya1+16 == ply27)
        {
            Player.Collision();
        }
        if (xa1+16 == plx27 && ya1-16 == ply27)
        {
            Player.Collision();
        }



        if (xa1 == plx28 && ya1 == ply28)
        {
            Player.Collision();
        }
        if (xa1+16 == plx28 && ya1+16 == ply28)
        {
            Player.Collision();
        }
        if (xa1-16 == plx28 && ya1-16 == ply28)
        {
            Player.Collision();
        }
        if (xa1-16 == plx28 && ya1+16 == ply28)
        {
            Player.Collision();
        }
        if (xa1+16 == plx28 && ya1-16 == ply28)
        {
            Player.Collision();
        }



        if (xa1 == plx29 && ya1 == ply29)
        {
            Player.Collision();
        }
        if (xa1+16 == plx29 && ya1+16 == ply29)
        {
            Player.Collision();
        }
        if (xa1-16 == plx29 && ya1-16 == ply29)
        {
            Player.Collision();
        }
        if (xa1-16 == plx29 && ya1+16 == ply29)
        {
            Player.Collision();
        }
        if (xa1+16 == plx29 && ya1-16 == ply29)
        {
            Player.Collision();
        }



        if (xa1 == plx30 && ya1 == ply30)
        {
            Player.Collision();
        }
        if (xa1+16 == plx30 && ya1+16 == ply30)
        {
            Player.Collision();
        }
        if (xa1-16 == plx30 && ya1-16 == ply30)
        {
            Player.Collision();
        }
        if (xa1-16 == plx30 && ya1+16 == ply30)
        {
            Player.Collision();
        }
        if (xa1+16 == plx30 && ya1-16 == ply30)
        {
            Player.Collision();
        }



        if (xa1 == plx31 && ya1 == ply31)
        {
            Player.Collision();
        }
        if (xa1+16 == plx31 && ya1+16 == ply31)
        {
            Player.Collision();
        }
        if (xa1-16 == plx31 && ya1-16 == ply31)
        {
            Player.Collision();
        }
        if (xa1-16 == plx31 && ya1+16 == ply31)
        {
            Player.Collision();
        }
        if (xa1+16 == plx31 && ya1-16 == ply31)
        {
            Player.Collision();
        }



        if (xa1 == plx32 && ya1 == ply32)
        {
            Player.Collision();
        }
        if (xa1+16 == plx32 && ya1+16 == ply32)
        {
            Player.Collision();
        }
        if (xa1-16 == plx32 && ya1-16 == ply32)
        {
            Player.Collision();
        }
        if (xa1-16 == plx32 && ya1+16 == ply32)
        {
            Player.Collision();
        }
        if (xa1+16 == plx32 && ya1-16 == ply32)
        {
            Player.Collision();
        }



        if (xa1 == plx33 && ya1 == ply33)
        {
            Player.Collision();
        }
        if (xa1+16 == plx33 && ya1+16 == ply33)
        {
            Player.Collision();
        }
        if (xa1-16 == plx33 && ya1-16 == ply33)
        {
            Player.Collision();
        }
        if (xa1-16 == plx33 && ya1+16 == ply33)
        {
            Player.Collision();
        }
        if (xa1+16 == plx33 && ya1-16 == ply33)
        {
            Player.Collision();
        }




        if (xa1 == plx34 && ya1 == ply34)
        {
            Player.Collision();
        }
        if (xa1+16 == plx34 && ya1+16 == ply34)
        {
            Player.Collision();
        }
        if (xa1-16 == plx34 && ya1-16 == ply34)
        {
            Player.Collision();
        }
        if (xa1-16 == plx34 && ya1+16 == ply34)
        {
            Player.Collision();
        }
        if (xa1+16 == plx34 && ya1-16 == ply34)
        {
            Player.Collision();
        }



        if (xa1 == plx35 && ya1 == ply35)
        {
            Player.Collision();
        }
        if (xa1+16 == plx35 && ya1+16 == ply35)
        {
            Player.Collision();
        }
        if (xa1-16 == plx35 && ya1-16 == ply35)
        {
            Player.Collision();
        }
        if (xa1-16 == plx35 && ya1+16 == ply35)
        {
            Player.Collision();
        }
        if (xa1+16 == plx35 && ya1-16 == ply35)
        {
            Player.Collision();
        }



        if (xa1 == plx36 && ya1 == ply36)
        {
            Player.Collision();
        }
        if (xa1+16 == plx36 && ya1+16 == ply36)
        {
            Player.Collision();
        }
        if (xa1-16 == plx36 && ya1-16 == ply36)
        {
            Player.Collision();
        }
        if (xa1-16 == plx36 && ya1+16 == ply36)
        {
            Player.Collision();
        }
        if (xa1+16 == plx36 && ya1-16 == ply36)
        {
            Player.Collision();
        }




        if (xa1 == plx37 && ya1 == ply37)
        {
            Player.Collision();
        }
        if (xa1+16 == plx37 && ya1+16 == ply37)
        {
            Player.Collision();
        }
        if (xa1-16 == plx37 && ya1-16 == ply37)
        {
            Player.Collision();
        }
        if (xa1-16 == plx37 && ya1+16 == ply37)
        {
            Player.Collision();
        }
        if (xa1+16 == plx37 && ya1-16 == ply37)
        {
            Player.Collision();
        }


        if (xa1 == plx38 && ya1 == ply38)
        {
            Player.Collision();
        }
        if (xa1+16 == plx38 && ya1+16 == ply38)
        {
            Player.Collision();
        }
        if (xa1-16 == plx38 && ya1-16 == ply38)
        {
            Player.Collision();
        }
        if (xa1-16 == plx38 && ya1+16 == ply38)
        {
            Player.Collision();
        }
        if (xa1+16 == plx38 && ya1-16 == ply38)
        {
            Player.Collision();
        }



        if (xa1 == plx39 && ya1 == ply39)
        {
            Player.Collision();
        }
        if (xa1+16 == plx39 && ya1+16 == ply39)
        {
            Player.Collision();
        }
        if (xa1-16 == plx39 && ya1-16 == ply39)
        {
            Player.Collision();
        }
        if (xa1-16 == plx39 && ya1+16 == ply39)
        {
            Player.Collision();
        }
        if (xa1+16 == plx39 && ya1-16 == ply39)
        {
            Player.Collision();
        }





        if (xa1 == plx40 && ya1 == ply40)
        {
            Player.Collision();
        }
        if (xa1+16 == plx40 && ya1+16 == ply40)
        {
            Player.Collision();
        }
        if (xa1-16 == plx40 && ya1-16 == ply40)
        {
            Player.Collision();
        }
        if (xa1-16 == plx40 && ya1+16 == ply40)
        {
            Player.Collision();
        }
        if (xa1+16 == plx40 && ya1-16 == ply40)
        {
            Player.Collision();
        }


        if (xa1 == plx41 && ya1 == ply41)
        {
            Player.Collision();
        }
        if (xa1+16 == plx41 && ya1+16 == ply41)
        {
            Player.Collision();
        }
        if (xa1-16 == plx41 && ya1-16 == ply41)
        {
            Player.Collision();
        }
        if (xa1-16 == plx41 && ya1+16 == ply41)
        {
            Player.Collision();
        }
        if (xa1+16 == plx41 && ya1-16 == ply41)
        {
            Player.Collision();
        }



        if (xa1 == plx42 && ya1 == ply42)
        {
            Player.Collision();
        }
        if (xa1+16 == plx42 && ya1+16 == ply42)
        {
            Player.Collision();
        }
        if (xa1-16 == plx42 && ya1-16 == ply42)
        {
            Player.Collision();
        }
        if (xa1-16 == plx42 && ya1+16 == ply42)
        {
            Player.Collision();
        }
        if (xa1+16 == plx42 && ya1-16 == ply42)
        {
            Player.Collision();
        }



        if (xa1 == plx43 && ya1 == ply43)
        {
            Player.Collision();
        }
        if (xa1+16 == plx43 && ya1+16 == ply43)
        {
            Player.Collision();
        }
        if (xa1-16 == plx43 && ya1-16 == ply43)
        {
            Player.Collision();
        }
        if (xa1-16 == plx43 && ya1+16 == ply43)
        {
            Player.Collision();
        }
        if (xa1+16 == plx43 && ya1-16 == ply43)
        {
            Player.Collision();
        }




        if (xa1 == plx44 && ya1 == ply44)
        {
            Player.Collision();
        }
        if (xa1+16 == plx44 && ya1+16 == ply44)
        {
            Player.Collision();
        }
        if (xa1-16 == plx44 && ya1-16 == ply44)
        {
            Player.Collision();
        }
        if (xa1-16 == plx44 && ya1+16 == ply44)
        {
            Player.Collision();
        }
        if (xa1+16 == plx44 && ya1-16 == ply44)
        {
            Player.Collision();
        }



        if (xa1 == plx45 && ya1 == ply45)
        {
            Player.Collision();
        }
        if (xa1+16 == plx45 && ya1+16 == ply45)
        {
            Player.Collision();
        }
        if (xa1-16 == plx45 && ya1-16 == ply45)
        {
            Player.Collision();
        }
        if (xa1-16 == plx45 && ya1+16 == ply45)
        {
            Player.Collision();
        }
        if (xa1+16 == plx45 && ya1-16 == ply45)
        {
            Player.Collision();
        }




        if (xa1 == plx46 && ya1 == ply46)
        {
            Player.Collision();
        }
        if (xa1+16 == plx46 && ya1+16 == ply46)
        {
            Player.Collision();
        }
        if (xa1-16 == plx46 && ya1-16 == ply46)
        {
            Player.Collision();
        }
        if (xa1-16 == plx46 && ya1+16 == ply46)
        {
            Player.Collision();
        }
        if (xa1+16 == plx46 && ya1-16 == ply46)
        {
            Player.Collision();
        }



        if (xa1 == plx47 && ya1 == ply47)
        {
            Player.Collision();
        }
        if (xa1+16 == plx47 && ya1+16 == ply47)
        {
            Player.Collision();
        }
        if (xa1-16 == plx47 && ya1-16 == ply47)
        {
            Player.Collision();
        }
        if (xa1-16 == plx47 && ya1+16 == ply47)
        {
            Player.Collision();
        }
        if (xa1+16 == plx47 && ya1-16 == ply47)
        {
            Player.Collision();
        }



        if (xa1 == plx48 && ya1 == ply48)
        {
            Player.Collision();
        }
        if (xa1+16 == plx48 && ya1+16 == ply48)
        {
            Player.Collision();
        }
        if (xa1-16 == plx48 && ya1-16 == ply48)
        {
            Player.Collision();
        }
        if (xa1-16 == plx48 && ya1+16 == ply48)
        {
            Player.Collision();
        }
        if (xa1+16 == plx48 && ya1-16 == ply48)
        {
            Player.Collision();
        }




        if (xa1 == plx49 && ya1 == ply49)
        {
            Player.Collision();
        }
        if (xa1+16 == plx49 && ya1+16 == ply49)
        {
            Player.Collision();
        }
        if (xa1-16 == plx49 && ya1-16 == ply49)
        {
            Player.Collision();
        }
        if (xa1-16 == plx49 && ya1+16 == ply49)
        {
            Player.Collision();
        }
        if (xa1+16 == plx49 && ya1-16 == ply49)
        {
            Player.Collision();
        }





        if (xa1 == plx50 && ya1 == ply50)
        {
            Player.Collision();
        }
        if (xa1+16 == plx49 && ya1+16 == ply49)
        {
            Player.Collision();
        }
        if (xa1-16 == plx49 && ya1-16 == ply49)
        {
            Player.Collision();
        }
        if (xa1-16 == plx49 && ya1+16 == ply49)
        {
            Player.Collision();
        }
        if (xa1+16 == plx49 && ya1-16 == ply49)
        {
            Player.Collision();
        }




        if (xa1 == plx50 && ya1 == ply50)
        {
            Player.Collision();
        }
        if (xa1+16 == plx50 && ya1+16 == ply50)
        {
            Player.Collision();
        }
        if (xa1-16 == plx50 && ya1-16 == ply50)
        {
            Player.Collision();
        }
        if (xa1-16 == plx50 && ya1+16 == ply50)
        {
            Player.Collision();
        }
        if (xa1+16 == plx50 && ya1-16 == ply50)
        {
            Player.Collision();
        }



        if (xa1 == plx51 && ya1 == ply51)
        {
            Player.Collision();
        }
        if (xa1+16 == plx51 && ya1+16 == ply51)
        {
            Player.Collision();
        }
        if (xa1-16 == plx51 && ya1-16 == ply51)
        {
            Player.Collision();
        }
        if (xa1-16 == plx51 && ya1+16 == ply51)
        {
            Player.Collision();
        }
        if (xa1+16 == plx51 && ya1-16 == ply51)
        {
            Player.Collision();
        }




        if (xa1 == plx52 && ya1 == ply52)
        {
            Player.Collision();
        }
        if (xa1+16 == plx52 && ya1+16 == ply52)
        {
            Player.Collision();
        }
        if (xa1-16 == plx52 && ya1-16 == ply52)
        {
            Player.Collision();
        }
        if (xa1-16 == plx52 && ya1+16 == ply52)
        {
            Player.Collision();
        }
        if (xa1+16 == plx52 && ya1-16 == ply52)
        {
            Player.Collision();
        }




        if (xa1 == plx53 && ya1 == ply53)
        {
            Player.Collision();
        }
        if (xa1+16 == plx53 && ya1+16 == ply53)
        {
            Player.Collision();
        }
        if (xa1-16 == plx53 && ya1-16 == ply53)
        {
            Player.Collision();
        }
        if (xa1-16 == plx53 && ya1+16 == ply53)
        {
            Player.Collision();
        }
        if (xa1+16 == plx53 && ya1-16 == ply53)
        {
            Player.Collision();
        }









        if (xa1 == plx53 && ya1 == ply53)
        {
            Player.Collision();
        }
        if (xa1+16 == plx53 && ya1+16 == ply53)
        {
            Player.Collision();
        }
        if (xa1-16 == plx53 && ya1-16 == ply53)
        {
            Player.Collision();
        }
        if (xa1-16 == plx53 && ya1+16 == ply53)
        {
            Player.Collision();
        }
        if (xa1+16 == plx53 && ya1-16 == ply53)
        {
            Player.Collision();
        }





        if (xa1 == plx54 && ya1 == ply54)
        {
            Player.Collision();
        }
        if (xa1+16 == plx54 && ya1+16 == ply54)
        {
            Player.Collision();
        }
        if (xa1-16 == plx54 && ya1-16 == ply54)
        {
            Player.Collision();
        }
        if (xa1-16 == plx54 && ya1+16 == ply54)
        {
            Player.Collision();
        }
        if (xa1+16 == plx54 && ya1-16 == ply54)
        {
            Player.Collision();
        }





        if (xa1 == plx55 && ya1 == ply55)
        {
            Player.Collision();
        }
        if (xa1+16 == plx55 && ya1+16 == ply55)
        {
            Player.Collision();
        }
        if (xa1-16 == plx55 && ya1-16 == ply55)
        {
            Player.Collision();
        }
        if (xa1-16 == plx55 && ya1+16 == ply55)
        {
            Player.Collision();
        }
        if (xa1+16 == plx55 && ya1-16 == ply55)
        {
            Player.Collision();
        }




        if (xa1 == plx55 && ya1 == ply55)
        {
            Player.Collision();
        }
        if (xa1+16 == plx55 && ya1+16 == ply55)
        {
            Player.Collision();
        }
        if (xa1-16 == plx55 && ya1-16 == ply55)
        {
            Player.Collision();
        }
        if (xa1-16 == plx55 && ya1+16 == ply55)
        {
            Player.Collision();
        }
        if (xa1+16 == plx55 && ya1-16 == ply55)
        {
            Player.Collision();
        }



        if (xa1 == plx56 && ya1 == ply56)
        {
            Player.Collision();
        }
        if (xa1+16 == plx56 && ya1+16 == ply56)
        {
            Player.Collision();
        }
        if (xa1-16 == plx56 && ya1-16 == ply56)
        {
            Player.Collision();
        }
        if (xa1-16 == plx56 && ya1+16 == ply56)
        {
            Player.Collision();
        }
        if (xa1+16 == plx56 && ya1-16 == ply56)
        {
            Player.Collision();
        }



        if (xa1 == plx57 && ya1 == ply57)
        {
            Player.Collision();
        }
        if (xa1+16 == plx57 && ya1+16 == ply57)
        {
            Player.Collision();
        }
        if (xa1-16 == plx57 && ya1-16 == ply57)
        {
            Player.Collision();
        }
        if (xa1-16 == plx57 && ya1+16 == ply57)
        {
            Player.Collision();
        }
        if (xa1+16 == plx57 && ya1-16 == ply57)
        {
            Player.Collision();
        }







        if (xa1+8 == plx5 && ya1+8 == ply5)
        {
            Player.Collision();
        }
        if (xa1-8 == plx5 && ya1-8 == ply5)
        {
            Player.Collision();
        }
        if (xa1-8 == plx5 && ya1+8 == ply5)
        {
            Player.Collision();
        }


        if (xa1+8 == plx6 && ya1-8 == ply6)
        {
            Player.Collision();
        }
        if (xa1+8 == plx6 && ya1+8 == ply6)
        {
            Player.Collision();
        }
        if (xa1-8 == plx6 && ya1-8 == ply6)
        {
            Player.Collision();
        }
        if (xa1-8 == plx6 && ya1+8 == ply6)
        {
            Player.Collision();
        }
        if (xa1+8 == plx6 && ya1-8 == ply6)
        {
            Player.Collision();
        }




        if (xa1+8 == plx7 && ya1-8 == ply7)
        {
            Player.Collision();
        }
        if (xa1+8 == plx7 && ya1+8 == ply7)
        {
            Player.Collision();
        }
        if (xa1-8 == plx7 && ya1-8 == ply7)
        {
            Player.Collision();
        }
        if (xa1-8 == plx7 && ya1+8 == ply7)
        {
            Player.Collision();
        }
        if (xa1+8 == plx7 && ya1-8 == ply7)
        {
            Player.Collision();
        }





        if (xa1+8 == plx8 && ya1-8 == ply8)
        {
            Player.Collision();
        }
        if (xa1+8 == plx8 && ya1+8 == ply8)
        {
            Player.Collision();
        }
        if (xa1-8 == plx8 && ya1-8 == ply8)
        {
            Player.Collision();
        }
        if (xa1-8 == plx8 && ya1+8 == ply8)
        {
            Player.Collision();
        }
        if (xa1+8 == plx8 && ya1-8 == ply8)
        {
            Player.Collision();
        }



        if (xa1+8 == plx9 && ya1-8 == ply9)
        {
            Player.Collision();
        }
        if (xa1+8 == plx9 && ya1+8 == ply9)
        {
            Player.Collision();
        }
        if (xa1-8 == plx9 && ya1-8 == ply9)
        {
            Player.Collision();
        }
        if (xa1-8 == plx9 && ya1+8 == ply9)
        {
            Player.Collision();
        }
        if (xa1+8 == plx9 && ya1-8 == ply9)
        {
            Player.Collision();
        }



        if (xa1+8 == plx10 && ya1-8 == ply10)
        {
            Player.Collision();
        }
        if (xa1+8 == plx10 && ya1+8 == ply10)
        {
            Player.Collision();
        }
        if (xa1-8 == plx10 && ya1-8 == ply10)
        {
            Player.Collision();
        }
        if (xa1-8 == plx10 && ya1+8 == ply10)
        {
            Player.Collision();
        }
        if (xa1+8 == plx10 && ya1-8 == ply10)
        {
            Player.Collision();
        }




        if (xa1+8 == plx11 && ya1-8 == ply11)
        {
            Player.Collision();
        }
        if (xa1+8 == plx11 && ya1+8 == ply11)
        {
            Player.Collision();
        }
        if (xa1-8 == plx11 && ya1-8 == ply11)
        {
            Player.Collision();
        }
        if (xa1-8 == plx11 && ya1+8 == ply11)
        {
            Player.Collision();
        }
        if (xa1+8 == plx11 && ya1-8 == ply11)
        {
            Player.Collision();
        }




        if (xa1+8 == plx12 && ya1-8 == ply12)
        {
            Player.Collision();
        }
        if (xa1+8 == plx12 && ya1+8 == ply12)
        {
            Player.Collision();
        }
        if (xa1-8 == plx12 && ya1-8 == ply12)
        {
            Player.Collision();
        }
        if (xa1-8 == plx12 && ya1+8 == ply12)
        {
            Player.Collision();
        }
        if (xa1+8 == plx12 && ya1-8 == ply12)
        {
            Player.Collision();
        }






        if (xa1+8 == plx13 && ya1-8 == ply13)
        {
            Player.Collision();
        }
        if (xa1+8 == plx13 && ya1+8 == ply13)
        {
            Player.Collision();
        }
        if (xa1-8 == plx13 && ya1-8 == ply13)
        {
            Player.Collision();
        }
        if (xa1-8 == plx13 && ya1+8 == ply13)
        {
            Player.Collision();
        }
        if (xa1+8 == plx13 && ya1-8 == ply13)
        {
            Player.Collision();
        }



        if (xa1+8 == plx14 && ya1-8 == ply14)
        {
            Player.Collision();
        }
        if (xa1+8 == plx14 && ya1+8 == ply14)
        {
            Player.Collision();
        }
        if (xa1-8 == plx14 && ya1-8 == ply14)
        {
            Player.Collision();
        }
        if (xa1-8 == plx14 && ya1+8 == ply14)
        {
            Player.Collision();
        }
        if (xa1+8 == plx14 && ya1-8 == ply14)
        {
            Player.Collision();
        }



        if (xa1+8 == plx15 && ya1-8 == ply15)
        {
            Player.Collision();
        }
        if (xa1+8 == plx15 && ya1+8 == ply15)
        {
            Player.Collision();
        }
        if (xa1-8 == plx15 && ya1-8 == ply15)
        {
            Player.Collision();
        }
        if (xa1-8 == plx15 && ya1+8 == ply15)
        {
            Player.Collision();
        }
        if (xa1+8 == plx15 && ya1-8 == ply15)
        {
            Player.Collision();
        }





        if (xa1+8 == plx16 && ya1-8 == ply16)
        {
            Player.Collision();
        }
        if (xa1+8 == plx16 && ya1+8 == ply16)
        {
            Player.Collision();
        }
        if (xa1-8 == plx16 && ya1-8 == ply16)
        {
            Player.Collision();
        }
        if (xa1-8 == plx16 && ya1+8 == ply16)
        {
            Player.Collision();
        }
        if (xa1+8 == plx16 && ya1-8 == ply16)
        {
            Player.Collision();
        }



        if (xa1+8 == plx17 && ya1-8 == plx17)
        {
            Player.Collision();
        }
        if (xa1+8 == plx17 && ya1+8 == plx17)
        {
            Player.Collision();
        }
        if (xa1-8 == plx17 && ya1-8 == plx17)
        {
            Player.Collision();
        }
        if (xa1-8 == plx17 && ya1+8 == plx17)
        {
            Player.Collision();
        }
        if (xa1+8 == plx17 && ya1-8 == plx17)
        {
            Player.Collision();
        }





        if (xa1+8 == plx18 && ya1-8 == ply18)
        {
            Player.Collision();
        }
        if (xa1+8 == plx18 && ya1+8 == ply18)
        {
            Player.Collision();
        }
        if (xa1-8 == plx18 && ya1-8 == ply18)
        {
            Player.Collision();
        }
        if (xa1-8 == plx18 && ya1+8 == ply18)
        {
            Player.Collision();
        }
        if (xa1+8 == plx18 && ya1-8 == ply18)
        {
            Player.Collision();
        }

        if (xa1+8 == plx19 && ya1-8 == ply19)
        {
            Player.Collision();
        }
        if (xa1+8 == plx19 && ya1+8 == ply19)
        {
            Player.Collision();
        }
        if (xa1-8 == plx19 && ya1-8 == ply19)
        {
            Player.Collision();
        }
        if (xa1-8 == plx19 && ya1+8 == ply19)
        {
            Player.Collision();
        }
        if (xa1+8 == plx19 && ya1-8 == ply19)
        {
            Player.Collision();
        }



        if (xa1+8 == plx20 && ya1-8 == ply20)
        {
            Player.Collision();
        }
        if (xa1+8 == plx20 && ya1+8 == ply20)
        {
            Player.Collision();
        }
        if (xa1-8 == plx20 && ya1-8 == ply20)
        {
            Player.Collision();
        }
        if (xa1-8 == plx20 && ya1+8 == ply20)
        {
            Player.Collision();
        }
        if (xa1+8 == plx20 && ya1-8 == ply20)
        {
            Player.Collision();
        }



        if (xa1+8 == plx21 && ya1-8 == ply21)
        {
            Player.Collision();
        }
        if (xa1+8 == plx21 && ya1+8 == ply21)
        {
            Player.Collision();
        }
        if (xa1-8 == plx21 && ya1-8 == ply21)
        {
            Player.Collision();
        }
        if (xa1-8 == plx21 && ya1+8 == ply21)
        {
            Player.Collision();
        }
        if (xa1+8 == plx21 && ya1-8 == ply21)
        {
            Player.Collision();
        }



        if (xa1+8 == plx22 && ya1-8 == ply22)
        {
            Player.Collision();
        }
        if (xa1+8 == plx22 && ya1+8 == ply22)
        {
            Player.Collision();
        }
        if (xa1-8 == plx22 && ya1-8 == ply22)
        {
            Player.Collision();
        }
        if (xa1-8 == plx22 && ya1+8 == ply22)
        {
            Player.Collision();
        }
        if (xa1+8 == plx22 && ya1-8 == ply22)
        {
            Player.Collision();
        }




        if (xa1+8 == plx23 && ya1-8 == ply23)
        {
            Player.Collision();
        }
        if (xa1+8 == plx23 && ya1+8 == ply23)
        {
            Player.Collision();
        }
        if (xa1-8 == plx23 && ya1-8 == ply23)
        {
            Player.Collision();
        }
        if (xa1-8 == plx23 && ya1+8 == ply23)
        {
            Player.Collision();
        }
        if (xa1+8 == plx23 && ya1-8 == ply23)
        {
            Player.Collision();
        }




        if (xa1+8 == plx24 && ya1-8 == ply24)
        {
            Player.Collision();
        }
        if (xa1+8 == plx24 && ya1+8 == ply24)
        {
            Player.Collision();
        }
        if (xa1-8 == plx24 && ya1-8 == ply24)
        {
            Player.Collision();
        }
        if (xa1-8 == plx24 && ya1+8 == ply24)
        {
            Player.Collision();
        }
        if (xa1+8 == plx24 && ya1-8 == ply24)
        {
            Player.Collision();
        }



        if (xa1+8 == plx25 && ya1-8 == ply25)
        {
            Player.Collision();
        }
        if (xa1+8 == plx25 && ya1+8 == ply25)
        {
            Player.Collision();
        }
        if (xa1-8 == plx25 && ya1-8 == ply25)
        {
            Player.Collision();
        }
        if (xa1-8 == plx25 && ya1+8 == ply25)
        {
            Player.Collision();
        }
        if (xa1+8 == plx25 && ya1-8 == ply25)
        {
            Player.Collision();
        }




        if (xa1+8 == plx26 && ya1-8 == ply26)
        {
            Player.Collision();
        }
        if (xa1+8 == plx26 && ya1+8 == ply26)
        {
            Player.Collision();
        }
        if (xa1-8 == plx26 && ya1-8 == ply26)
        {
            Player.Collision();
        }
        if (xa1-8 == plx26 && ya1+8 == ply26)
        {
            Player.Collision();
        }
        if (xa1+8 == plx26 && ya1-8 == ply26)
        {
            Player.Collision();
        }



        if (xa1+8 == plx27 && ya1-8 == ply27)
        {
            Player.Collision();
        }
        if (xa1+8 == plx27 && ya1+8 == ply27)
        {
            Player.Collision();
        }
        if (xa1-8 == plx27 && ya1-8 == ply27)
        {
            Player.Collision();
        }
        if (xa1-8 == plx27 && ya1+8 == ply27)
        {
            Player.Collision();
        }
        if (xa1+8 == plx27 && ya1-8 == ply27)
        {
            Player.Collision();
        }




        if (xa1+8 == plx28 && ya1-8 == ply28)
        {
            Player.Collision();
        }
        if (xa1+8 == plx28 && ya1+8 == ply28)
        {
            Player.Collision();
        }
        if (xa1-8 == plx28 && ya1-8 == ply28)
        {
            Player.Collision();
        }
        if (xa1-8 == plx28 && ya1+8 == ply28)
        {
            Player.Collision();
        }
        if (xa1+8 == plx28 && ya1-8 == ply28)
        {
            Player.Collision();
        }







		}
	
	
	
}
