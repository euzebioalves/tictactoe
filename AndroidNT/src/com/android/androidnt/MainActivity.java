package com.android.androidnt;

import com.android.androidnt.R.botao;
import com.android.androidnt.R.jogada;
import com.android.androidnt.R.label;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public Button btnNovoJogo, btnSair;
	public Button jc1, jc2, jc3, jc4, jc5, jc6, jc7, jc8, jc9;
	public TextView lblNomeJ1, lblNomeJ2, lblPlcarJ1, lblPlcarJ2,
			lblPlcarEmpate;

	public int vezJogador, placarJ1, placarJ2, placarEmpate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnNovoJogo = (Button) findViewById(botao.novo_jogo);
		btnNovoJogo.setOnClickListener(NovoJogo());

		btnSair = (Button) findViewById(botao.sair);
		btnSair.setOnClickListener(Sair());

		jc1 = (Button) findViewById(jogada.casa1);
		jc2 = (Button) findViewById(jogada.casa2);
		jc3 = (Button) findViewById(jogada.casa3);
		jc4 = (Button) findViewById(jogada.casa4);
		jc5 = (Button) findViewById(jogada.casa5);
		jc6 = (Button) findViewById(jogada.casa6);
		jc7 = (Button) findViewById(jogada.casa7);
		jc8 = (Button) findViewById(jogada.casa8);
		jc9 = (Button) findViewById(jogada.casa9);

		lblPlcarJ1 = (TextView) findViewById(label.placar_jogador_1);
		lblPlcarJ2 = (TextView) findViewById(label.placar_jogador_2);
		lblPlcarEmpate = (TextView) findViewById(label.placar_empate);

		vezJogador = 1;
		placarJ1 = 0;
		placarJ2 = 0;
		placarEmpate = 0;

		jc1.setOnClickListener(Jogar(jc1));
		jc2.setOnClickListener(Jogar(jc2));
		jc3.setOnClickListener(Jogar(jc3));
		jc4.setOnClickListener(Jogar(jc4));
		jc5.setOnClickListener(Jogar(jc5));
		jc6.setOnClickListener(Jogar(jc6));
		jc7.setOnClickListener(Jogar(jc7));
		jc8.setOnClickListener(Jogar(jc8));
		jc9.setOnClickListener(Jogar(jc9));

	}

	public OnClickListener Jogar(final Button btn) {
		return new OnClickListener() {
			public void onClick(View v) {
				if (FazerJogada(btn)) {
					int vencedor = VerificaVencedor();
					if (vencedor == 1) {
						ModificaPlacar(1);
						MostraMsg("O Jogador 1 Venceu a partida", "Parabéns!");
						NovaPartida();
					} else if (vencedor == 2) {
						ModificaPlacar(2);
						MostraMsg("O Jogador 2 Venceu a partida", "Parabéns!");
						NovaPartida();
					} else if (vencedor == 3) {
						ModificaPlacar(3);
						MostraMsg("A partida empatou", "Velha!");
						MudarJogador();
						NovaPartida();
					} else {
						MudarJogador();
					}
				}
				ModificaTextos();
			}
		};
	}

	public boolean FazerJogada(Button btn) {
		if (btn.getText().equals("")) {
			if (vezJogador == 1) {
				btn.setText("X");
			} else {
				btn.setText("O");
			}
			return true;
		}
		return false;
	}

	public void MudarJogador() {
		if (vezJogador == 1)
			vezJogador = 2;
		else
			vezJogador = 1;
	}

	public void ModificaPlacar(int placar) {
		if (placar == 1)
			placarJ1 += 1;
		else if (placar == 2)
			placarJ2 += 1;
		else
			placarEmpate += 1;
	}

	public void ModificaTextos() {
		lblPlcarJ1.setText(Integer.toString(placarJ1));
		lblPlcarJ2.setText(Integer.toString(placarJ2));
		lblPlcarEmpate.setText(Integer.toString(placarEmpate));
	}

	public void NovaPartida() {
		jc1.setText("");
		jc2.setText("");
		jc3.setText("");
		jc4.setText("");
		jc5.setText("");
		jc6.setText("");
		jc7.setText("");
		jc8.setText("");
		jc9.setText("");
	}

	public void ZeraPlacar() {
		placarJ1 = 0;
		placarJ2 = 0;
		placarEmpate = 0;
	}

	public int VerificaVencedor() {
		if ((jc1.getText().equals("X") && jc2.getText().equals("X") && jc3
				.getText().equals("X"))
				|| (jc4.getText().equals("X") && jc5.getText().equals("X") && jc6
						.getText().equals("X"))
				|| (jc7.getText().equals("X") && jc8.getText().equals("X") && jc9
						.getText().equals("X"))
				|| (jc1.getText().equals("X") && jc4.getText().equals("X") && jc7
						.getText().equals("X"))
				|| (jc2.getText().equals("X") && jc5.getText().equals("X") && jc8
						.getText().equals("X"))
				|| (jc3.getText().equals("X") && jc6.getText().equals("X") && jc9
						.getText().equals("X"))
				|| (jc1.getText().equals("X") && jc5.getText().equals("X") && jc9
						.getText().equals("X"))
				|| (jc3.getText().equals("X") && jc5.getText().equals("X") && jc7
						.getText().equals("X"))) {
			return 1;
		} else if ((jc1.getText().equals("O") && jc2.getText().equals("O") && jc3
				.getText().equals("O"))
				|| (jc4.getText().equals("O") && jc5.getText().equals("O") && jc6
						.getText().equals("O"))
				|| (jc7.getText().equals("O") && jc8.getText().equals("O") && jc9
						.getText().equals("O"))
				|| (jc1.getText().equals("O") && jc4.getText().equals("O") && jc7
						.getText().equals("O"))
				|| (jc2.getText().equals("O") && jc5.getText().equals("O") && jc8
						.getText().equals("O"))
				|| (jc3.getText().equals("O") && jc6.getText().equals("O") && jc9
						.getText().equals("O"))
				|| (jc1.getText().equals("O") && jc5.getText().equals("O") && jc9
						.getText().equals("O"))
				|| (jc3.getText().equals("O") && jc5.getText().equals("O") && jc7
						.getText().equals("O"))) {
			return 2;
		} else if ((!jc1.getText().equals("") && !jc2.getText().equals("") && !jc3
				.getText().equals(""))
				&& (!jc4.getText().equals("") && !jc5.getText().equals("") && !jc6
						.getText().equals(""))
				&& (!jc7.getText().equals("") && !jc8.getText().equals("") && !jc9
						.getText().equals(""))
				&& (!jc1.getText().equals("") && !jc4.getText().equals("") && !jc7
						.getText().equals(""))
				&& (!jc2.getText().equals("") && !jc5.getText().equals("") && !jc8
						.getText().equals(""))
				&& (!jc3.getText().equals("") && !jc6.getText().equals("") && !jc9
						.getText().equals(""))
				&& (!jc1.getText().equals("") && !jc5.getText().equals("") && !jc9
						.getText().equals(""))
				&& (!jc3.getText().equals("") && !jc5.getText().equals("") && !jc7
						.getText().equals(""))) {
			return 3;
		}
		return 0;

	}

	public View.OnClickListener NovoJogo() {
		return new OnClickListener() {
			public void onClick(View v) {
				ZeraPlacar();
				NovaPartida();
				ModificaTextos();
			}
		};
	}

	public View.OnClickListener Sair() {
		return new OnClickListener() {
			public void onClick(View v) {
				System.exit(0);
			}
		};
	}

	public void MostraMsg(String msg, String titulo) {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setMessage(msg);
		builder.setNeutralButton("OK", null);
		AlertDialog dialog = builder.create();
		dialog.setTitle(titulo);
		dialog.show();
	}

}
