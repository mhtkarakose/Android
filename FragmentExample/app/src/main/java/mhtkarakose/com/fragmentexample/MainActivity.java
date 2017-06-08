package mhtkarakose.com.fragmentexample;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.app.FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

    } // end onCreate

    public void addFragmentA(View v){

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, fragmentA, "fragmentA");

        transaction.commit(); // end of the transaction
        Log.i("FragmentA","oluşturulduu");
    }// end addFragmentA



    public  void removeFragmentA(View v){

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragmentA");

        FragmentTransaction transaction= manager.beginTransaction();

        if (fragmentA !=null){
            transaction.remove(fragmentA);
        }else{
            Toast.makeText(this, "bulunamadı", Toast.LENGTH_SHORT).show();
        }
        transaction.commit();//
    } // end removeFragmentA

    public void addFragmentB(View v) {

        FragmentB fragmentb = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, fragmentb , "fragmentB");

        transaction.commit();
    } // end addFragmentB

    public void removeFragmentB(View v){

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragmentB");

        FragmentTransaction  transaction = manager.beginTransaction();

        if(fragmentB != null) {
            transaction.remove(fragmentB);
        }else{
            Toast.makeText(this, "bulunamadı", Toast.LENGTH_SHORT).show();
        }
        transaction.commit();

    }

}// end Class
