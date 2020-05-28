package com.example.karorok.zamtest;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureListener.DoubleTabListener{

    Data data;

    int[] ids = {R.id.recyclerView_20,R.id.recyclerView_21,R.id.recyclerView_22,R.id.recyclerView_23,
            R.id.recyclerView_24,R.id.recyclerView_25,R.id.recyclerView_26,R.id.recyclerView_27,R.id.recyclerView_28,
            R.id.recyclerView_29,R.id.recyclerView_30};

    ArrayList<RecyclerView> recyclerViews;

    NestedScrollView scrollView;

    LinearLayout parent;

    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this,new GestureListener(this));

        initView();
        parsing();
        initRecyclerView();

    }

    private void initView(){
        scrollView = findViewById(R.id.scrollView);
        parent = findViewById(R.id.parent);
        parent.setOnTouchListener(touchListener);
    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
    };

    private void initRecyclerView(){
        recyclerViews = new ArrayList<>();
        for(int i = 0; i< ids.length; i++){
            RecyclerView recyclerView = findViewById(ids[i]);
            LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(lm);
            GestureDetector gestureDetector = new GestureDetector(this,new GestureListener(this,i));
            Adapter adapter = new Adapter(data.getNumber(i).getItems(),gestureDetector);
            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new ItemDecoration(20));
            recyclerViews.add(recyclerView);
        }
    }



    private void scrollInit(){
        scrollView.scrollTo(0,0);
        for (int i = 0; i < recyclerViews.size(); i++){
            recyclerViews.get(i).smoothScrollToPosition(0);
        }
    }


    private void parsing(){
        String json = "{\n" +
                "\"20\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 3, \"text\": \"아티클\", \"color\": \"yellow\"},\n" +
                "{\"width\": 4, \"text\": \"영상\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"링크\", \"color\": \"red\"},\n" +
                "{\"width\": 6, \"text\": \"링크\", \"color\": \"red\"},\n" +
                "{\"width\": 7, \"text\": \"링크\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"21\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 5, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"22\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 6, \"text\": \"제품\", \"color\": \"yellow\"},\n" +
                "{\"width\": 6, \"text\": \"검색\", \"color\": \"blue\"},\n" +
                "{\"width\": 4, \"text\": \"개인화\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"23\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 5, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"24\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 5, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"25\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 5, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"26\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 3, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"27\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 5, \"text\": \"샘플\", \"color\": \"yellow\"},\n" +
                "{\"width\": 9, \"text\": \"제품\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"28\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 3, \"text\": \"아티클\", \"color\": \"yellow\"},\n" +
                "{\"width\": 4, \"text\": \"영상\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"링크\", \"color\": \"red\"},\n" +
                "{\"width\": 6, \"text\": \"영상\", \"color\": \"red\"},\n" +
                "{\"width\": 7, \"text\": \"영상\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"29\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 3, \"text\": \"아티클\", \"color\": \"yellow\"},\n" +
                "{\"width\": 4, \"text\": \"영상\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"링크\", \"color\": \"red\"},\n" +
                "{\"width\": 6, \"text\": \"아티클\", \"color\": \"red\"},\n" +
                "{\"width\": 7, \"text\": \"링크\", \"color\": \"red\"}\n" +
                "]\n" +
                "},\n" +
                "\"30\": {\n" +
                "\"items\": [\n" +
                "{\"width\": 3, \"text\": \"아티클\", \"color\": \"yellow\"},\n" +
                "{\"width\": 4, \"text\": \"영상\", \"color\": \"blue\"},\n" +
                "{\"width\": 5, \"text\": \"아티클\", \"color\": \"red\"},\n" +
                "{\"width\": 6, \"text\": \"링크\", \"color\": \"red\"},\n" +
                "{\"width\": 3, \"text\": \"아티클\", \"color\": \"red\"}\n" +
                "]\n" +
                "    }\n" +
                "}";
        JsonElement mJson = new JsonParser().parse(json);
        Gson gson = new Gson();
        data = gson.fromJson(mJson,Data.class);
    }



    @Override
    public void onDoubleTab(int index) {
        recyclerViews.get(index).smoothScrollToPosition(0);
    }

    @Override
    public void onDoubleTab() {
        scrollInit();
    }

    public class ItemDecoration extends RecyclerView.ItemDecoration{
        private final int right;

        public ItemDecoration(int right) {
            this.right = right;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = right;
        }
    }
}
