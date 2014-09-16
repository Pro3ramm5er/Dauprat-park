import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.JFrame;





public class Game extends Canvas implements Runnable {
 	 public boolean leftPressed = false;
 	 public boolean rightPressed = false;
 	 public boolean one_pressed = false;
	public static Sprite main_img;
	public static Sprite hero_img;
	public BufferStrategy   bss;
	public Graphics gl;
	public  int gmlevel = 0; // 0 - Меню, 1 - начало игры
	public static JFrame frame;
    private static final long serialVersionUID = 1L;
    Boolean running;
    public  JFrame fr_level_1;
    public int pi = 0;
    public static int plx = 50;
    public static int ply = 50;
    public int is_st22 = 0;
    public boolean gm_an_1 = false;
    public Graphics gl_2;
	  int[] Wxx = {};
	  int[] Wyy = {};
	  int Wxx_now = 1;
	  int Wyy_now = 1;
	 
    public int pl_st = 0; // Сторона просмотра, 1 - up, 2 - right, 3 - down, 4 - left
	public void clearImage(Graphics gtest) {
	
		gtest.setColor(Color.BLACK);
		gtest.fillRect(0,  0, getWidth(), getHeight());
	    gtest.setColor(Color.BLACK);
	}
    public void start()
    {
    	running = true;
    	
    	new Thread(this).start();
    }
    public void run() { 
    	long lastTime = System.currentTimeMillis();
    	long delta;
    	init();
    	
    	while(running) {
    		delta = System.currentTimeMillis() - lastTime;
    		lastTime = System.currentTimeMillis();
    		update(delta);
    		render();
    	}
    	//функция run появляется после того, как мы добавили "implements Runnable"
    }
    public void init()
    {
    	main_img = getSprite("logo.png");
    	hero_img = getSprite("stop_dest.png");
    	addKeyListener(new Keyboard());
    
        
    }
    public void render()
    {
    	bss = getBufferStrategy();
    	if (bss == null)
    	{
    		createBufferStrategy(2);
    		requestFocus();
    		return;
    	}
    	gl = bss.getDrawGraphics();
    	gl.setColor(Color.black);
    	gl.fillRect(0, 0, getWidth(), getHeight());
    	main_img.draw(gl, 5, 5);
    	hero_img.draw(gl, plx, ply);
    	gl.dispose();
    	bss.show();
    	
    }
    public void update(long delta) {
        if (leftPressed == true) {
            for (int i = 1; i < Wxx_now; i++)
            {
            	if (plx == Wxx[i])
            	{
            		plx--;
            	}
            }
            
            
        }
        if (rightPressed == true) {
            for (int i = 1; i < Wxx_now; i++)
            {
            	if (plx == Wxx[i])
            	{
            		plx++;
            	}
            }
            
            
        }
        if (one_pressed == true)
        {
        	
        	
        		GetLevel_2();
        	
        	
        	
        }
        if (pl_st == 2)
        {
        	hero_img = getSprite("hero.png");
        }
        if (pl_st == 4)
        {
        	hero_img = getSprite("hero_left.png");
        }

    }
    
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static String NAME = "Daupret park, debug";
    public static void main(String[] args)  {
    	
    	Game game = new Game();
    	game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    	JFrame frame = new JFrame(Game.NAME);

    	
    	frame.setLayout(new BorderLayout());
    	frame.add(game, BorderLayout.CENTER);
    	frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        game.start();
       
    	
        
    	 
    	
    }
    
    
    
    
    

   
    public void Get_Start()
    {
    	GRPHS_ins_2lvl();
    	gmlevel = 1;
    	hero_img = getSprite("hero.png");
    	
    }


	public void GetLevel_2() {
    
	
		pi = 0;
		javax.swing.Timer timer = new javax.swing.Timer( 1000, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 0)
		    	  {
		    	  main_img = getSprite("stop_22.png");
		    	  is_st22 = 1;
		    	  }
		    	  
		      }
		  } );
		javax.swing.Timer timer_2 = new javax.swing.Timer( 1500, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 1)
		    	  {
		    	  main_img = getSprite("stop_dest.png");
		    	  is_st22 = 2;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_3 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 2)
		    	  {
		    	  main_img = getSprite("video.png");
		    	  is_st22 = 3;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_4 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 3)
		    	  {
		    	  main_img = getSprite("video_2.png");
		    	  is_st22 = 4;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_5 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 4)
		    	  {
		    	  main_img = getSprite("video_3.png");
		    	  is_st22 = 5;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_6 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 5)
		    	  {
		    	  main_img = getSprite("video_4.png");
		    	  is_st22 = 6;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_7 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 6)
		    	  {
		    	  main_img = getSprite("video_5.png");
		    	  is_st22 = 7;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_8 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 7)
		    	  {
		    	  main_img = getSprite("video_6.png");
		    	  is_st22 = 8;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_9 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 8)
		    	  {
		    	  main_img = getSprite("video_7.png");
		    	  is_st22 = 9;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_10 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 9)
		    	  {
		    	  main_img = getSprite("video_8.png");
		    	  is_st22 = 10;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_11 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 10)
		    	  {
		    	  main_img = getSprite("video_9.png");
		    	  is_st22 = 11;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_12 = new javax.swing.Timer( 400, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 11)
		    	  {
		    	  main_img = getSprite("video_10.png");
		    	  is_st22 = 12;
		    	  }
		      }
		  } );
		javax.swing.Timer timer_13 = new javax.swing.Timer( 1500, new ActionListener()
		  {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  if (is_st22 == 12)
		    	  {
		    	  main_img = getSprite("stop_dest.png");
		    	  is_st22 = 13;
		    	  }
		      }
		  } );
		  timer.start();
		  if (is_st22 == 1)
		  {
			  timer.stop();
			  timer_2.start();
		  }
		  
		  if (is_st22 == 2)
		  {
			  timer_2.stop();
			  timer_3.start();
		  }
		  
		  if (is_st22 == 3)
		  {
			  timer_3.stop();
			  timer_4.start();
		  }
		  if (is_st22 == 4)
		  {
			  timer_4.stop();
			  timer_5.start();
		  }
		  if (is_st22 == 5)
		  {
			  timer_5.stop();
			  timer_6.start();
		  }
		  if (is_st22 == 6)
		  {
			  timer_6.stop();
			  timer_7.start();
		  }
		  if (is_st22 == 7)
		  {
			  timer_7.stop();
			  timer_8.start();
			  
		  }
		  if (is_st22 == 8)
		  {
			  timer_8.stop();
			  timer_9.start();
			  
		  }
		  if (is_st22 == 9)
		  {
			  timer_9.stop();
			  timer_10.start();
			  
		  }
		  if (is_st22 == 10)
		  {
			  timer_10.stop();
			  timer_11.start();
			  
		  }
		  if (is_st22 == 11)
		  {
			  timer_11.stop();
			  timer_12.start();
			  
		  }
		  if (is_st22 == 12)
		  {
			  timer_12.stop();
			  timer_13.start();
			  
		  }
		  if (is_st22 == 13)
		  {
			  timer_13.stop();
			  Get_Start();
			  
		  }
    	//main_img = getSprite("stop_dest.png");
		
    	//one_pressed = false;
    	
    	
    }
	
	
	 
	 
	 public void GRPHS_ins_2lvl()
	 {
		 
		 //gl_2 = bss.getDrawGraphics();
		 //gl_2.setColor(Color.black);
		 //gl_2.fillRect(0, 0, getWidth(), getHeight());
		 Crate_create(0,0);
		 Crate_create(16,16);
		 Crate_create(32,32);
		 Crate_create(48,48);
		 //gl_2.dispose();
	 }
	 
	 public void Crate_create(int xa, int ya)
	 {
		 Sprite tex;
		 tex = getSprite("Blockstone.png");
		 tex.draw(gl, xa, ya);
		 Wxx[Wxx_now] = xa;
		 Wyy[Wyy_now] = ya;
		 Wxx_now ++;
		 Wyy_now ++;
	 }
	

	
	
	
    public Sprite getSprite(String path) {
        BufferedImage sourceImage = null;
            
        try {
            URL url = this.getClass().getClassLoader().getResource(path);
            sourceImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));
            
        return sprite;
    }

    
    
    
    
         class Keyboard extends KeyAdapter {
 
        	public void keyPressed(KeyEvent w) {
              	 if (gmlevel == 1)
            	 {                  
        	    if (w.getKeyCode() == KeyEvent.VK_A) {
        	        leftPressed = true;
        	        pl_st = 4;
        	    }
        	    if (w.getKeyCode() == KeyEvent.VK_D) {
        	        rightPressed = true;
        	        pl_st = 2;
        	    }	
            	}
        			if (w.getKeyCode() == KeyEvent.VK_1)
        			{

        				one_pressed = true;
        				
        			}
              	
        	} 
        	public void keyReleased(KeyEvent w) { //клавиша отпущена
             	if (gmlevel == 1)
           	    {              		
        	    if (w.getKeyCode() == KeyEvent.VK_A) {
        	        leftPressed = false;
        	    }
        	    if (w.getKeyCode() == KeyEvent.VK_D) {
        	        rightPressed = false;
        	    }
           	    }
        	}
        	 
        }
         
         
         
         
         

}

