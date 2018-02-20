package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.omg.CORBA.portable.OutputStream;

import com.jcraft.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

// seq : 116 , ancienP :  57 ,nouveauP: 56
// seq 70 , new seq :93, par :36 ,new Par :47
public class Launch {
// 34 s ------- 33.4 : chess
// 8 s --------- 4.96 s : c20d10
// 147 ------------ 91.7  : c73d10
// 180------------- 158.4 :t4i10d100
// 647  -------------- 617  : connect
// 40   --------------- 32.7 : mushroom
// 50  ---------------  42.5 : t25i10d10
//  462 ---------------  384.3 : t20i6d100

//  2099 ---------------  1712: accidents

	public static void main(String[] args) {
		//TraitementDeDonnees.startConnection();
		 long startTime = System.currentTimeMillis();
		 TraitementDeDonnees.lireDonneesBinaires("C:\\Users\\Zaki\\Desktop\\BenchMark\\accidents.dat");
		 //AlgoGen ag=new AlgoGen(100,100,0.5,0.5,0.9,0.1,6,0.1,0.5,true,1,1,0);
		// AlgoGenSansClasses ag=new AlgoGenSansClasses(100,100,0.5,0.5,0.9,0.1,6,0.1,0.5,true,1,1,0);
//		 // masqu uniforme marche pas
		 //ag.lancerAlgoGen();
		 //ag.AfficherReglesValide();
		 long stopTime = System.currentTimeMillis();
		// TraitementDeDonnees.endConnection();
		 double elapsedTime = (stopTime - startTime)/1000;
		 System.out.println(" temps d'exécutin :" +elapsedTime +" Secondes");
		 System.out.print(" temps de calcul des cout :");
		System.out.println(TraitementDeDonnees.time/1000 +" Secondes");
		 //TraitementDeDonnees.lireDonnees();
		 //	String items[]= new String[5];
		//items[0]="38";items[1]="2";items[2]="94";items[3]="120";items[4]="36";
       // Chromosome c= new Chromosome(5, items, 0.5, 0.5); c.setIndice(4);
      // TraitementDeDonnees.startConnection();
       //TraitementDeDonnees.calculFitnessCPU(c, 0.5, 0.5);
      // TraitementDeDonnees.calculFitnessCPU(c, 0.5, 0.5);
//       
    ///  ExempleBDD e= new ExempleBDD();
     

	}

	private static void printResult(InputStream input, Channel channel) throws Exception {
		int SIZE = 1024;
		byte[] tmp = new byte[SIZE];
		while (true) {
			while (input.available() > 0) {
				int i = input.read(tmp, 0, SIZE);
				if (i < 0)
					break;
				String msg = new String(tmp, 0, i);
				System.out.println(msg);
				if(msg.charAt(0)=='#' && msg.charAt(1)=='#'){ System.out.println(msg);}
				
				//System.out.print(msg);
			}
			if (channel.isClosed()) {
				System.out.println("exit-status: " + channel.getExitStatus());
				break;
			}
			try {
				Thread.sleep(300);
			} catch (Exception ee) {
			}
		}
	}

}
