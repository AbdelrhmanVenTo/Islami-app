package com.example.islamiapp.TabsFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamiapp.Adapter.QuranContentAdapter;
import com.example.islamiapp.Adapter.QuranListAdapter;

import com.example.islamiapp.Base.BaseFragment;
import com.example.islamiapp.R;
import com.example.islamiapp.SouraContentActivity;



/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends BaseFragment {
    RecyclerView quranListRecyclerView ;
    QuranListAdapter adapter ;
    RecyclerView.LayoutManager layoutManager;
    public static String[] listOfSewarNames ={"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
            ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
            ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
            ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
            ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
            ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
            ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
            "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};
    View view;

    public String[] getListOfSewarNames() {
        return listOfSewarNames;
    }

    public void setListOfSewarNames(String[] listOfSewarNames) {
        this.listOfSewarNames = listOfSewarNames;
    }

    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_quran, container, false);
        quranListRecyclerView = view.findViewById(R.id.quran_recyclerView);
        adapter = new QuranListAdapter(listOfSewarNames);
        quranListRecyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL,false);
        quranListRecyclerView.setLayoutManager(layoutManager);
        adapter.setOnTextClickListener(new QuranListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position, String suraName) {
                SouraContentActivity.setSuraFileName(String.valueOf(position + 1));
                Intent intent = new Intent(getContext() , SouraContentActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    /*public void quranDataList()  {
        Scanner s = null;
        try {
            s = new Scanner(new File("assets/quranChapterNames.txt"));
            quranLists = new ArrayList<>();
            while (s.hasNextLine()){
                quranLists.add(new QuranList(s.nextLine()));
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

    }




