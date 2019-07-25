package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.adapter.OnBoardAdapter;
import me.andersonmatte.englishwords.entity.OnBoardItem;


public class OnBoardingActivity extends AppCompatActivity {

    private LinearLayout page;
    private int count;
    private ImageView[] itensOnBording;
    private ViewPager viewPager;
    private OnBoardAdapter onBoardAdapter;
    private Button botaoStart;
    int posicaoVoltar = 0;
    ArrayList<OnBoardItem> listaOnBoardItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        botaoStart = (Button) findViewById(R.id.btn_get_started);
        viewPager = (ViewPager) findViewById(R.id.pager_introduction);
        page = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        this.populaItensOnBord();

        onBoardAdapter = new OnBoardAdapter(this, listaOnBoardItem);
        viewPager.setAdapter(onBoardAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Change the current position intimation
                for (int i = 0; i < count; i++) {
                    itensOnBording[i].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.non_selected_item_dot));
                }
                itensOnBording[position].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.selected_item_dot));

                int pos = position + 1;

                if (pos == count && posicaoVoltar == (count - 1)) {
                    controlaAnimacao(true);
                } else if (pos == (count - 1) && posicaoVoltar == count) {
                    controlaAnimacao(false);
                }
                posicaoVoltar = pos;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        botaoStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHome();
                //Toast.makeText(OnBoardingActivity.this, "Redirect to wherever you want", Toast.LENGTH_LONG).show();
            }
        });
        setUiPageViewController();
    }

    private void populaItensOnBord() {
        int[] header = {R.string.ob_header1, R.string.ob_header2, R.string.ob_header3};
        int[] desc = {R.string.ob_desc1, R.string.ob_desc2, R.string.ob_desc3};
        int[] imageId = {R.drawable.onboard_page1, R.drawable.onboard_page2, R.drawable.onboard_page3};
        for (int i = 0; i < imageId.length; i++) {
            OnBoardItem item = new OnBoardItem();
            item.setIdImagem(imageId[i]);
            item.setTitulo(getResources().getString(header[i]));
            item.setDescricao(getResources().getString(desc[i]));
            this.listaOnBoardItem.add(item);
        }
    }

    public void controlaAnimacao(final Boolean acima) {
        Animation show = AnimationUtils.loadAnimation(this, acima ? R.anim.slide_up_anim : R.anim.slide_down_anim);
        botaoStart.startAnimation(show);
        show.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (acima) {
                    botaoStart.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                botaoStart.clearAnimation();
                if (!acima) {
                    botaoStart.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setUiPageViewController() {
        count = onBoardAdapter.getCount();
        itensOnBording = new ImageView[count];
        for (int i = 0; i < count; i++) {
            itensOnBording[i] = new ImageView(this);
            itensOnBording[i].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.non_selected_item_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(6, 0, 6, 0);

            page.addView(itensOnBording[i], params);
        }
        itensOnBording[0].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.selected_item_dot));
    }

    //Chama a HomeActivity.
    private void mostrarHome() {
        Intent intent = new Intent(OnBoardingActivity.this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }


}

