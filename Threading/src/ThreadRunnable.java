
public class ThreadRunnable implements Runnable{

	//creating thread by implementing Runnable interface.
	private Thread t;
	private  String threadName;
	
	 ThreadRunnable(String name)
	{
		threadName = name;
		System.out.println("Creating " +  this.threadName);
	}
	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try{
		for(int i = 4; i > 0; i--)
		{
			System.out.println("Thread: " + threadName + ", " + i);
			
				Thread.sleep(500);
			} 
		}
		catch (InterruptedException e) {
				System.out.println("Thread " + threadName + " intererupted");
			}
		System.out.println("Thread " + threadName  + " exiting");
		}
	
	public void start()
	{
		System.out.println("Starting " + threadName);
		if(t == null)
		{
			t = new Thread(this, threadName);
			t.start();

		}

	}
	
	
	public static void main(String[] args)
	{
		ThreadRunnable d1 = new ThreadRunnable("Thread-1");
		d1.start();
		ThreadRunnable d2 = new ThreadRunnable("Thread-2");
		d2.start();
		
	}
	
	}
	
	


