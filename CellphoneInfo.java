import java.util.*;

class DelayProvision{
	//To provide the delay or interval for the user convinence.
	public void doDelay(int ms){
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

//Parent of all cellphones with common features and properties.
class Cellphone{
	protected String plateform;
	protected String display;
	protected String storage;
	protected String battery;
	protected String camera;
	protected String performance;
	protected String model;
	private Scanner scan = new Scanner(System.in);
	protected DelayProvision delay = new DelayProvision();

	public void doSms(){
		System.out.println("Enter your sms : ");
		String sms = scan.nextLine();
		System.out.println("Sending your sms...");
		delay.doDelay(2000);
		System.out.println("sms sent.");
	}
	public void doMms(){
		System.out.println("browse the multimedia : ");
		String mms = scan.nextLine();
		System.out.println("Sending your mms...");
		delay.doDelay(2000);
		System.out.println("mms sent.");
	}
	public void doCall(){
		System.out.println("Enter number you want to call : ");
		String sms = scan.nextLine();
		System.out.println("Calling...");
		delay.doDelay(2000);
		System.out.println("call connected..");
		delay.doDelay(500);
		System.out.println("Please speak..");
		delay.doDelay(2000);
		System.out.println("call disconnected..");
	}
	public void displayCellphone(){
		System.out.println("Plateform = " + this.plateform + 
		"\nDisplay = " + this.display +
		"\nStorage = " + this.storage +
		"\nBattery = " + this.battery +
		"\nCamera = " + this.camera +
		"\nPerformance = " + this.performance +
		"\nModel = " + this.model );
	}
}

class Samsung extends Cellphone{
	private String irisScanner;
	private String fingerPrintPosition;
	private String fingerprintSensor;
	private String simSlot;
	private Scanner scan = new Scanner(System.in);

	public Samsung(){
		this.plateform = "android 1.5";
		this.display = "5.8 cm";
		this.storage = "64 GB";
		this.battery = "3000 MAH";
		this.camera = "12 mp";
		this.performance = "medium";
		this.model = "Samsung galaxy j7";
		this.irisScanner = "yes";
		this.fingerPrintPosition = "rear" ;
		this.fingerprintSensor = "yes";
		this.simSlot = "dual sim";
	}
	public void samsungPay(){
		System.out.println("Enter the amount u want to pay : ");
		int amount = scan.nextInt();
		delay.doDelay(1000);
		System.out.println(amount + " is deducted from your account .");
	}
	public void samsungGalary(){
		System.out.println("Viewing photos...wait");
		delay.doDelay(1000);
		System.out.println("Photos viewed.");
	}
	public void displaySamsung(){
		System.out.println("Samsung have follwing properties : ");
		displayCellphone();
		System.out.println("IrisScanner = " + this.irisScanner +
		"\nFingerPrintPosition = " + this.fingerPrintPosition +
		"\nFingerprintSensor = " + this.fingerprintSensor +
		"\nSimSlot = " + this.simSlot);
	} 

}

class Oppo extends Cellphone{
	private String headphoneJackType;
	private String connectivity;
	private Scanner scan = new Scanner(System.in);

	public Oppo(){
		this.model = "Oppo F3";
		this.plateform = "android 1.7";
		this.display = "6.8 cm";
		this.storage = "32 GB";
		this.battery = "3000 MAH";
		this.camera = "14 mp";
		this.performance = "medium";
		this.headphoneJackType = "3.5 mm";
		this.connectivity = "3G";

	}
	public void faceUnlock(){
		System.out.println("Unlocking face plz wait..");
		delay.doDelay(1000);
		System.out.println("Done.");

	}
	public void GPSTrack(){
		System.out.println("Plz turn on your location.");
		delay.doDelay(1000);
		System.out.println("Enter the destination : ");
		String destination = scan.nextLine();
		delay.doDelay(1000);
		System.out.println("Route selected ...\nyour location ----------------- " + destination);
	}
	public void FMRadio(){
		System.out.println("Fm started..");
	}
	public void displayOppo(){
		System.out.println(this.model + " have follwing properties : ");
		displayCellphone();
		System.out.println("HeadphoneJackType = " + this.headphoneJackType + 
		"\nConnectivity = " + this.connectivity);
	} 
}

class Mi extends Cellphone{
	private String selfieCamera;
	
	public Mi(){
		this.model = "MI note 5 pro";
		this.plateform = "android 1.8";
		this.display = "6.8 cm";
		this.storage = "32 GB";
		this.battery = "4000 MAH";
		this.camera = "14 mp";
		this.performance = "High";
		this.selfieCamera = "yes";	
	}
	public void faceRecognation(){
		System.out.println("capturing your face : ");
		delay.doDelay(1000);
		System.out.println("Face recognised.");
	}
	public void displayMi(){
		System.out.println(this.model + " have follwing properties : ");
		displayCellphone();
		System.out.println("SelfieCamera = " + this.selfieCamera);
	}
}

//Contains the methods which will call respctive cellphones methods after selection of cellphone
class CellphoneChoice{ 
	private Scanner scan = new Scanner(System.in);
	private DelayProvision delay = new DelayProvision();
	
	//To call the functionality of samsung's cellphone after operation selection
	public void samsungInfo(){ 
		char ch = 'y';
		//For the repetitive selections of samsung's operation.			
		do{ 
			System.out.println("Samsung features : "); 
			delay.doDelay(500);
			System.out.println("1.Call\n2.SMS\n3.MMS\n4.Samsung Pay\n5.Samsung galary\n6.Display Samsung features.");
			System.out.print("choose the operation you want to do : ");
			int opn = scan.nextInt();
			delay.doDelay(500);
			Samsung samsung = new Samsung();
			switch(opn){
				case 1:
					samsung.doCall();
					break;
				case 2:
					samsung.doSms();
					break;
				case 3:
					samsung.doMms();
					break;
				case 4:
					samsung.samsungPay();
					break;
				case 5:
					samsung.samsungGalary();
					break;
				case 6:
					samsung.displaySamsung();
					break;
				default : 
					System.out.println("Operation not available .");
			}		
			delay.doDelay(500);
			System.out.println("Do you want to use another operation of samsung : (y/n) ");
			ch = scan.next().charAt(0);
		}
		while(ch=='y');
	}
	//To call the functionality of oppo's cellphone after operation selection  
	public void oppoInfo(){	
		char ch = 'y';
		//For the repetitive selections of oppo's operation.
		do{ 
			System.out.println("Oppo features :- "); 
			delay.doDelay(500);		
			System.out.println("1.Call\n2.SMS\n3.MMS\n4.Face Unlock\n5.GPS Track\n6.FM Radio\n7.Display Oppo features.");
			System.out.print("choose the operation you want to do : ");
			int opn = scan.nextInt();
			delay.doDelay(500);						
			Oppo oppo = new Oppo();
			switch(opn){
				case 1:
					oppo.doCall();
					break;
				case 2:
					oppo.doSms();
					break;
				case 3:
					oppo.doMms();
					break;
				case 4:
					oppo.faceUnlock();
					break;
				case 5:
					oppo.GPSTrack();
					break;
				case 6:
					oppo.FMRadio();
					break;
				case 7:
					oppo.displayOppo();
					break;
				default : 
					System.out.println("Operation not available .");
			}		
			delay.doDelay(500);
			System.out.println("Do you want to use another operation of oppo : (y/n) ");
			ch = scan.next().charAt(0);
		}
		while(ch=='y');
	}
	//To call the functionality of mi's cellphone after operation selection
	public void miInfo(){  
		char ch = 'y';
		//For the repetitive selections of mi's operation.
		do{  
			System.out.println("Mi features :- "); 
			delay.doDelay(500);
			System.out.println("1.Call\n2.SMS\n3.MMS\n4.Face Recognation\n5.Display MI features.");
			System.out.print("choose the operation you want to do : ");
			int opn = scan.nextInt();
			delay.doDelay(500);	
			Mi mi = new Mi();
			switch(opn){
				case 1:
					mi.doCall();
					break;
				case 2:
					mi.doSms();
					break;
				case 3:
					mi.doMms();
					break;
				case 4:
					mi.faceRecognation();
					break;
				case 5:
					mi.displayMi();
					break;
				default : 
					System.out.println("Operation not available .");
			}		
			delay.doDelay(500);
			System.out.println("Do you want to use another operation of MI : (y/n) ");
			ch = scan.next().charAt(0);
		}
		while(ch=='y');
	}
}

public class CellphoneInfo{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		DelayProvision delay = new DelayProvision();
		CellphoneChoice cellphone = new CellphoneChoice();
		char c = 'y';
		//For the repetitive selections of cellphone.	
		do{ 
			System.out.println("Following are available cellphones : ");
			System.out.println("1.Samsung\n2.Oppo\n3.MI");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			delay.doDelay(100);
			char ch = 'y';
			switch(choice){
				case 1:
					cellphone.samsungInfo();
					break;
			
				case 2:
					cellphone.oppoInfo();
					break;
			
				case 3:
					cellphone.miInfo();
					break;
				
				default:
					System.out.println("Cellphone not available .");
	
			}
			System.out.println("Do you want try other cellphones (y/n): ");
			c = scan.next().charAt(0);
		}
		while(c=='y');
	}
}
