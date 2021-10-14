package com.example.jaringan_semantik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class search_fragment extends Fragment {
    View view;
    ImageView gambar1, gb_arah1, gb_arah2, gb_arah3, gb_arah4;
    TextView test11, test12;
    TextView mainText;
    TextView textSub1,textSub2,textSub3,textSub4;
    TextView textHub1,textHub2,textHub3,textHub4;

    public static String KEY_ACTIVITY = "msg_activity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.isi_search, container, false);
        gambar1 = view.findViewById(R.id.gambar);
        test11 = view.findViewById(R.id.test1);
        test12 = view.findViewById(R.id.test2);
        gb_arah1 = view.findViewById(R.id.arah1);
        gb_arah2 = view.findViewById(R.id.arah2);
        gb_arah3 = view.findViewById(R.id.arah3);
        gb_arah4 = view.findViewById(R.id.arah4);
        mainText = view.findViewById(R.id.tx_main);
        textSub1 = view.findViewById(R.id.tx_sub1);
        textSub2 = view.findViewById(R.id.tx_sub2);
        textSub3 = view.findViewById(R.id.tx_sub3);
        textSub4 = view.findViewById(R.id.tx_sub4);
        textHub1 = view.findViewById(R.id.tx_hub1);
        textHub2 = view.findViewById(R.id.tx_hub2);
        textHub3 = view.findViewById(R.id.tx_hub3);
        textHub4 = view.findViewById(R.id.tx_hub4);

        String source = getArguments().getString(KEY_ACTIVITY);
        String main = getArguments().getString("main");
        String js1 = getArguments().getString("js1");
        String js2 = getArguments().getString("js2");
        String js3 = getArguments().getString("js3");
        String js4 = getArguments().getString("js4");
        String jh1 = getArguments().getString("jh1");
        String jh2 = getArguments().getString("jh2");
        String jh3 = getArguments().getString("jh3");
        String jh4 = getArguments().getString("jh4");
        String desk = getArguments().getString("desk");

            if(!source.isEmpty()){
                if (js2.isEmpty() && js3.isEmpty() && js4.isEmpty()){
                    mainText.setText(main);
                    textSub1.setVisibility(View.VISIBLE);textSub1.setText(js1);
                    textSub2.setVisibility(View.INVISIBLE);
                    textSub3.setVisibility(View.INVISIBLE);
                    textSub4.setVisibility(View.INVISIBLE);
                    textHub1.setVisibility(View.VISIBLE);textHub1.setText(jh1);
                    textHub2.setVisibility(View.INVISIBLE); gb_arah2.setVisibility(View.INVISIBLE);
                    textHub3.setVisibility(View.INVISIBLE); gb_arah3.setVisibility(View.INVISIBLE);
                    textHub4.setVisibility(View.INVISIBLE); gb_arah4.setVisibility(View.INVISIBLE);
                    test11.setText(main);
                    test12.setText(desk);
                }
                else if (!js2.isEmpty() && js3.isEmpty() && js4.isEmpty()) {
                    mainText.setText(main);
                    textSub1.setVisibility(View.VISIBLE);textSub1.setText(js1);
                    textSub2.setVisibility(View.VISIBLE);textSub2.setText(js2);
                    textSub3.setVisibility(View.INVISIBLE);
                    textSub4.setVisibility(View.INVISIBLE);
                    textHub1.setVisibility(View.VISIBLE);textHub1.setText(jh1);
                    textHub2.setVisibility(View.VISIBLE);textHub2.setText(jh2);
                    textHub3.setVisibility(View.INVISIBLE); gb_arah3.setVisibility(View.INVISIBLE);
                    textHub4.setVisibility(View.INVISIBLE); gb_arah4.setVisibility(View.INVISIBLE);
                    test11.setText(main);
                    test12.setText(desk);
                }
                else if(!js2.isEmpty() && !js3.isEmpty() && js4.isEmpty()) {
                    mainText.setText(main);
                    textSub1.setVisibility(View.VISIBLE);textSub1.setText(js1);
                    textSub2.setVisibility(View.VISIBLE);textSub2.setText(js2);
                    textSub3.setVisibility(View.VISIBLE);textSub3.setText(js3);
                    textSub4.setVisibility(View.INVISIBLE);
                    textHub1.setVisibility(View.VISIBLE);textHub1.setText(jh1);
                    textHub2.setVisibility(View.VISIBLE);textHub2.setText(jh2);
                    textHub3.setVisibility(View.VISIBLE);textHub3.setText(jh3);
                    textHub4.setVisibility(View.INVISIBLE); gb_arah4.setVisibility(View.INVISIBLE);
                    test11.setText(main);
                    test12.setText(desk);
                }
                else{
                    mainText.setText(main);
                    textSub1.setVisibility(View.VISIBLE);textSub1.setText(js1);
                    textSub2.setVisibility(View.VISIBLE);textSub2.setText(js2);
                    textSub3.setVisibility(View.VISIBLE);textSub3.setText(js3);
                    textSub4.setVisibility(View.VISIBLE);textSub4.setText(js4);
                    textHub1.setVisibility(View.VISIBLE);textHub1.setText(jh1);
                    textHub2.setVisibility(View.VISIBLE);textHub2.setText(jh2);
                    textHub3.setVisibility(View.VISIBLE);textHub3.setText(jh3);
                    textHub4.setVisibility(View.VISIBLE);textHub4.setText(jh4);
                    test11.setText(main);
                    test12.setText(desk);
                }
            } else{
                test11.setText("Harap Isi Kata Kunci, atau klik button ? untuk bantuan");
                test12.setText("");
                gambar1.setVisibility(View.GONE);
                mainText.setVisibility(View.GONE);
                textHub1.setVisibility(View.GONE);
                textHub2.setVisibility(View.GONE);
                textHub3.setVisibility(View.GONE);
                textHub4.setVisibility(View.GONE);
                textSub1.setVisibility(View.GONE);
                textSub2.setVisibility(View.GONE);
                textSub3.setVisibility(View.GONE);
                textSub4.setVisibility(View.GONE);
                gb_arah1.setVisibility(View.GONE);
                gb_arah2.setVisibility(View.GONE);
                gb_arah3.setVisibility(View.GONE);
                gb_arah4.setVisibility(View.GONE);
            }
        return view;
    }


}
