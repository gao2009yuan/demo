package harry.clint;

import harry.aidl.ITest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	
	private ITest tService = null;
	private Button btnBind = null;
	private Button btnTest = null;
	

	private ServiceConnection connection = new ServiceConnection(){

		public void onServiceConnected(ComponentName name, IBinder service) {
			
			tService = ITest.Stub.asInterface(service);
			
		}

		public void onServiceDisconnected(ComponentName name) {
			
			tService = null;
		}
	};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		this.btnBind = (Button) findViewById(R.id.btnBind);
		this.btnTest = (Button) findViewById(R.id.btnTest);
		this.btnBind.setOnClickListener(this);
		this.btnTest.setOnClickListener(this);
		
	}

	
	@Override
	protected void onDestroy() {
		unbindService(connection);
		super.onDestroy();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBind:
			Intent service = new Intent("harry.aidl.ITest");
			bindService(service, connection, BIND_AUTO_CREATE);
			
			break;
		case R.id.btnTest:
			try {
				tService.showTest();
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
	}

}
