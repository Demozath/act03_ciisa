package com.demozath.act03_ciisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String usuario = "CIISA";
    String password = "4321";
    MediaPlayer sonidoError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnIngresar(View view){
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        String Nombreusuario = etNombre.getText().toString();
        String PasswordUsuario = etPassword.getText().toString();

        if (Nombreusuario.equals(this.usuario) && (PasswordUsuario.equals(this.password))){
            Toast toast = Toast.makeText(getApplicationContext(),"Bienvenido !",Toast.LENGTH_LONG);
            toast.show();
            Intent intent = new Intent(MainActivity.this,LobbyActivity.class);
            startActivity(intent);

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Usuario Incorrecto :C !",Toast.LENGTH_LONG);
            toast.show();
            sonidoError = MediaPlayer.create(this,R.raw.cuack);
            sonidoError.start();
            Vibrator vibracionError = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibracionError.vibrate(1000);
        }
    }

    public void registro_usuarios(View view){

        TextView registro_usuarios = (TextView) findViewById(R.id.registro_usuarios);
        registro_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,Activity_registro_usuarios.class);
                startActivity(intent);
            }
        });
}
}