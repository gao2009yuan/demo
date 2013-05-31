package harry.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlService extends Service {

	
	private MyBinder myBinder = new MyBinder();
	
	
	@Override
	public void onCreate() {
		Log.d("harry", "AidlService........onCreate()");
		super.onCreate();
	}




	@Override
	public void onDestroy() {
		Log.d("harry","AidlService........onDestroy()");
		super.onDestroy();
	}




	@Override
	public IBinder onBind(Intent arg0) {
		return myBinder;
	}

	
	
	
	/**binderÄÚ²¿Àà*/
	private class MyBinder extends ITest.Stub{

		@Override
		public void showTest() throws RemoteException {
			Log.d("harry", "..............remote service showTest()........");
			
		}
		
	}
	
	
	
	
	
}
